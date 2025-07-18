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
            result.add(convert(record));
        }
        return result;
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData(String.valueOf(record.id), record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    public List<GroupData> getGroupList() {
        return convertGroupList(sessionFactory.fromSession(session ->
                session.createQuery("from GroupRecord", GroupRecord.class).list()
        ));
    }

    public long getGroupsCount() {
        return sessionFactory.fromSession(session ->
                session.createQuery("select count(*) from GroupRecord", Long.class).getSingleResult()
        );
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });
    }

    static List<AddressData> convertContactList(List<ContactRecord> records) {
        List<AddressData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }

    private static AddressData convert(ContactRecord record) {
        return new AddressData()
                .withId(String.valueOf(record.id))
                .withFirstname(record.firstname)
                .withMiddlename(record.middlename)
                .withLastname(record.lastname)
                .withNickname(record.nickname)
                .withTitle(record.title)
                .withCompany(record.company)
                .withAddress(record.address)
                .withHome(record.home)
                .withMobile(record.mobile)
                .withWork(record.work)
                .withFax(record.fax)
                .withHomepage(record.homepage)
                .withBday(record.bday)
                .withBmonth(record.bmonth)
                .withByear(record.byear)
                .withAday(record.aday)
                .withAmonth(record.amonth)
                .withAyear(record.ayear);
    }


    private static ContactRecord convert(AddressData data) {
    var id = data.id();
    if ("".equals(id)){
        id = "0";
    }
        return new ContactRecord(
                Integer.parseInt(id),
                data.firstname(),
                data.middlename(),
                data.lastname(),
                data.nickname(),
                data.title(),
                data.company(),
                data.address(),
                data.home(),
                data.mobile(),
                data.work(),
                data.fax(),
                data.homepage(),
                data.bday(),
                data.bmonth(),
                data.byear(),
                data.aday(),
                data.amonth(),
                data.ayear()
        );
    }

    public List<AddressData> getContactList() {
        return convertContactList(sessionFactory.fromSession(session ->
                session.createQuery("from ContactRecord", ContactRecord.class).list()
        ));
    }

    public long getContactsCount() {
        return sessionFactory.fromSession(session ->
                session.createQuery("select count(*) from ContactRecord", Long.class).getSingleResult()
        );
    }

    public void createContact(AddressData contactData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(contactData));
            session.getTransaction().commit();
        });
    }

    public List<AddressData> getContactsInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            GroupRecord record = session.get(GroupRecord.class, Integer.parseInt(group.id()));
            return record != null && record.contacts != null
                    ? convertContactList(record.contacts)
                    : List.of();
        });
    }
    public List<ContactInGroup> getContactInGroups() {
        return session().createQuery("from ContactInGroup", ContactInGroup.class).list();
    }

    public List<ContactInGroup> getContactInGroupsByGroup(int groupId) {
        return session().createQuery("from ContactInGroup where id.groupId = :groupId", ContactInGroup.class)
                .setParameter("groupId", groupId)
                .list();
    }

}
