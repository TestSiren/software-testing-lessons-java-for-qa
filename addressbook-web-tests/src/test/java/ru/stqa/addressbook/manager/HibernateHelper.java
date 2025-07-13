package ru.stqa.addressbook.manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.hbm.GroupRecord;
import ru.stqa.addressbook.hbm.ContactRecord;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.models.AddressData;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.cfg.JdbcSettings.*;

public class HibernateHelper extends HelperBase {
    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);
        sessionFactory = new Configuration()
                .addAnnotatedClass(GroupRecord.class)
                .addAnnotatedClass(ContactRecord.class)
                .setProperty(URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(USER, "root")
                .setProperty(PASS, "")
                .buildSessionFactory();
    }

    static List<GroupData> convertGroupList(List<GroupRecord> records) {
        List<GroupData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convertGroup(record));
        }
        return result;
    }

    private static GroupData convertGroup(GroupRecord record) {
        return new GroupData(String.valueOf(record.id), record.name, record.header, record.footer);
    }

    private static GroupRecord convertGroup(GroupData data) {
        var idStr = data.id();
        int id = idStr.isEmpty() ? 0 : Integer.parseInt(idStr);
        return new GroupRecord(id, data.name(), data.header(), data.footer());
    }

    public List<GroupData> getGroupList() {
        return convertGroupList(sessionFactory.fromSession(session ->
                session.createQuery("from GroupRecord", GroupRecord.class).list()
        ));
    }

    public long getGroupsCount(){
        return sessionFactory.fromSession(session ->
                session.createQuery("select count(*) from GroupRecord", Long.class).getSingleResult()
        );
    }

    public void createGroup(GroupData groupData){
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertGroup(groupData));
            session.getTransaction().commit();
        });
    }

    static List<AddressData> convertContactList(List<AddressData> records) {
        List<AddressData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convertContact(record));
        }
        return result;
    }

    private static AddressData convertContact(AddressData record) {
        return new AddressData(
                String.valueOf(record.id),
                record.firstname,
                record.middlename,
                record.lastname,
                record.nickname,
                record.company,
                record.title,
                record.address,
                record.addrLong,
                record.addrLat,
                record.addrStatus,
                record.home,
                record.mobile,
                record.work,
                record.fax,
                record.email,
                record.email2,
                record.email3,
                record.im,
                record.im2,
                record.im3,
                record.homepage,
                record.bday,
                record.bmonth,
                record.byear,
                record.aday,
                record.amonth,
                record.ayear,
                record.address2,
                record.phone2,
                record.notes,
                record.photo,
                record.xVcard,
                record.xActivesync,
                record.created,
                record.modified,
                record.deprecated,
                record.password,
                record.login,
                record.role
        );
    }

    private static AddressRecord convertContact(AddressData data) {
        int id = data.id().isEmpty() ? 0 : Integer.parseInt(data.id());
        AddressData record = new AddressData();
        record.id = id;
        record.firstname = data.firstname();
        record.middlename = data.middlename();
        record.lastname = data.lastname();
        record.nickname = data.nickname();
        record.company = data.company();
        record.title = data.title();
        record.address = data.address();
        record.addrLong = data.addr_long();
        record.addrLat = data.addr_lat();
        record.addrStatus = data.addr_status();
        record.home = data.home();
        record.mobile = data.mobile();
        record.work = data.work();
        record.fax = data.fax();
        record.email = data.email();
        record.email2 = data.email2();
        record.email3 = data.email3();
        record.im = data.im();
        record.im2 = data.im2();
        record.im3 = data.im3();
        record.homepage = data.homepage();
        record.bday = data.bday();
        record.bmonth = data.bmonth();
        record.byear = data.byear();
        record.aday = data.aday();
        record.amonth = data.amonth();
        record.ayear = data.ayear();
        record.address2 = data.address2();
        record.phone2 = data.phone2();
        record.notes = data.notes();
        record.photo = data.photo();
        record.xVcard = data.x_vcard();
        record.xActivesync = data.x_activesync();
        record.created = data.created();
        record.modified = data.modified();
        record.deprecated = data.deprecated();
        record.password = data.password();
        record.login = data.login();
        record.role = data.role();
        return record;
    }

    public List<AddressData> getContactList() {
        return convertContactList(sessionFactory.fromSession(session ->
                session.createQuery("from ContactRecord", ContactRecord.class).list()
        ));
    }

    public long getContactsCount(){
        return sessionFactory.fromSession(session ->
                session.createQuery("select count(*) from ContactRecord", Long.class).getSingleResult()
        );
    }

    public void createContact(AddressData contactData){
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertContact(contactData));
            session.getTransaction().commit();
        });
    }

    public List<AddressData> getContactsInGroup(GroupData group){
        return sessionFactory.fromSession(session -> {
return convertContactList(session.get(GroupRecord.class, group.id()).contacts);
        });
    }
}
