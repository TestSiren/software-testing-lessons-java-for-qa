package ru.stqa.addressbook.manager;

import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.models.AddressData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCHelper extends HelperBase{
    public JDBCHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<GroupData> getGroupList() {
        var groups = new ArrayList<GroupData>();

        try (var connectDB = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = connectDB.createStatement();
             var result = statement.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list");)
        {
            while (result.next()) {
                groups.add(new GroupData()
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public List<AddressData> getAddressList() {
        var address = new ArrayList<AddressData>();

        try (var connectDB = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = connectDB.createStatement();
             var result = statement.executeQuery("SELECT id, firstname, middlename, lastname, nickname, title, company, address, home, mobile, work, fax, homepage, bday, bmonth, byear, aday, amonth, ayear FROM addressbook");)
        {
            while (result.next()) {
                address.add(new AddressData()
                        .withId(result.getString("id"))
                        .withFirstname(result.getString("firstname"))
                        .withMiddlename(result.getString("middlename"))
                        .withLastname(result.getString("lastname"))
                        .withNickname(result.getString("nickname"))
                        .withTitle(result.getString("title"))
                        .withCompany(result.getString("company"))
                        .withAddress(result.getString("address"))
                        .withHome(result.getString("home"))
                        .withMobile(result.getString("mobile"))
                        .withWork(result.getString("work"))
                        .withFax(result.getString("fax"))
                        .withHomepage(result.getString("homepage"))
                        .withBday(Integer.parseInt(result.getString("bday")))
                        .withBmonth(result.getString("bmonth"))
                        .withByear(result.getString("byear"))
                        .withAday(Integer.parseInt(result.getString("aday")))
                        .withAmonth(result.getString("amonth"))
                        .withAyear(result.getString("ayear"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return address;
    }

    public void checkConsistency(){
        try (var connectDB = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = connectDB.createStatement();
             var result = statement.executeQuery("SELECT * FROM address_in_groups ag LEFT JOIN addressbook ab ON ab.id=ag.id WHERE ab.id IS NULL");)
        {
            if (result.next()) {
               throw new IllegalStateException("DB is corrupted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
