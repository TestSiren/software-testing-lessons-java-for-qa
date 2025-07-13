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

    public long getGroupsCount() {
        return sessionFactory.fromSession(session ->
                session.createQuery("select count(*) from GroupRecord", Long.class).getSingleResult()
        );
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convertGroup(groupData));
            session.getTransaction().commit();
        });
    }

    static List<AddressData> convertContactList(List<ContactRecord> records) {
        List<AddressData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convertContact(record));
        }
        return result;
    }

    private static AddressData convertContact(ContactRecord record) {
        List<String> emails = List.of(
                record.email != null ? record.email : "",
                record.email2 != null ? record.email2 : "",
                record.email3 != null ? record.email3 : ""
        );

        int bday = record.bday != null ? record.bday.intValue() : 0;
        int aday = record.aday != null ? record.aday.intValue() : 0;

        String group = "";
        if (record.group != null) {
            group = record.group;
        }

        return new AddressData(
                String.valueOf(record.id),
                record.firstname != null ? record.firstname : "",
                record.middlename != null ? record.middlename : "",
                record.lastname != null ? record.lastname : "",
                record.nickname != null ? record.nickname : "",
                record.title != null ? record.title : "",
                record.company != null ? record.company : "",
                record.address != null ? record.address : "",
                record.home != null ? record.home : "",
                record.mobile != null ? record.mobile : "",
                record.work != null ? record.work : "",
                record.fax != null ? record.fax : "",
                emails,
                record.homepage != null ? record.homepage : "",
                bday,
                record.bmonth != null ? record.bmonth : "",
                record.byear != null ? record.byear : "",
                aday,
                record.amonth != null ? record.amonth : "",
                record.ayear != null ? record.ayear : "",
                group,
                record.photo != null ? record.photo : ""
        );
    }

    private static ContactRecord convertContact(AddressData data) {
        int id = data.id().isEmpty() ? 0 : Integer.parseInt(data.id());
        ContactRecord record = new ContactRecord();
        record.id = id;
        record.firstname = data.firstname();
        record.middlename = data.middlename();
        record.lastname = data.lastname();
        record.nickname = data.nickname();
        record.company = data.company();
        record.title = data.title();
        record.address = data.address();
        record.home = data.home();
        record.mobile = data.mobile();
        record.work = data.work();
        record.fax = data.fax();
        record.email = data.emails().size() > 0 ? data.emails().get(0) : "";
        record.email2 = data.emails().size() > 1 ? data.emails().get(1) : "";
        record.email3 = data.emails().size() > 2 ? data.emails().get(2) : "";
        record.homepage = data.homepage();
        record.bday = (byte) data.bday();
        record.bmonth = data.bmonth();
        record.byear = data.byear();
        record.aday = (byte) data.aday();
        record.amonth = data.amonth();
        record.ayear = data.ayear();
        record.group = data.group();
        record.photo = data.photo();
        return record;
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
            session.persist(convertContact(contactData));
            session.getTransaction().commit();
        });
    }

    public List<AddressData> getContactsInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            GroupRecord gr = session.get(GroupRecord.class, Integer.parseInt(group.id()));
            return convertContactList(gr.address);
        });
    }
}
