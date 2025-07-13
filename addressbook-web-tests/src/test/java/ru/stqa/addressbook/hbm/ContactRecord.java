package ru.stqa.addressbook.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "contact") // подставьте имя таблицы
public class ContactRecord {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "domain_id", nullable = false)
    public int domainId;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "middlename")
    public String middlename;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "nickname")
    public String nickname;

    @Column(name = "company")
    public String company;

    @Column(name = "title")
    public String title;

    @Column(name = "address", columnDefinition = "TEXT")
    public String address;

    @Column(name = "addr_long", columnDefinition = "TEXT")
    public String addrLong;

    @Column(name = "addr_lat", columnDefinition = "TEXT")
    public String addrLat;

    @Column(name = "addr_status", columnDefinition = "TEXT")
    public String addrStatus;

    @Column(name = "home", columnDefinition = "TEXT")
    public String home;

    @Column(name = "mobile", columnDefinition = "TEXT")
    public String mobile;

    @Column(name = "work", columnDefinition = "TEXT")
    public String work;

    @Column(name = "fax", columnDefinition = "TEXT")
    public String fax;

    @Column(name = "email", columnDefinition = "TEXT")
    public String email;

    @Column(name = "email2", columnDefinition = "TEXT")
    public String email2;

    @Column(name = "email3", columnDefinition = "TEXT")
    public String email3;

    @Column(name = "im", columnDefinition = "TEXT")
    public String im;

    @Column(name = "im2", columnDefinition = "TEXT")
    public String im2;

    @Column(name = "im3", columnDefinition = "TEXT")
    public String im3;

    @Column(name = "homepage", columnDefinition = "TEXT")
    public String homepage;

    @Column(name = "bday")
    public Byte bday;

    @Column(name = "bmonth")
    public String bmonth;

    @Column(name = "byear")
    public String byear;

    @Column(name = "aday")
    public Byte aday;

    @Column(name = "amonth")
    public String amonth;

    @Column(name = "ayear")
    public String ayear;

    @Column(name = "address2", columnDefinition = "TEXT")
    public String address2;

    @Column(name = "phone2", columnDefinition = "TEXT")
    public String phone2;

    @Column(name = "notes", columnDefinition = "TEXT")
    public String notes;

    @Column(name = "photo", columnDefinition = "MEDIUMTEXT")
    public String photo;

    @Column(name = "x_vcard", columnDefinition = "MEDIUMTEXT")
    public String xVcard;

    @Column(name = "x_activesync", columnDefinition = "MEDIUMTEXT")
    public String xActivesync;

    @Column(name = "created")
    public Date created;

    @Column(name = "modified")
    public Date modified;

    @Column(name = "deprecated")
    public Date deprecated;

    @Column(name = "password")
    public String password;

    @Column(name = "login")
    public Date login;

    @Column(name = "role")
    public String role;

    public ContactRecord() {}

    public ContactRecord(int id, int domainId, String firstname, String middlename, String lastname, String nickname,
                         String company, String title, String address, String addrLong, String addrLat, String addrStatus,
                         String home, String mobile, String work, String fax, String email, String email2, String email3,
                         String im, String im2, String im3, String homepage, Byte bday, String bmonth, String byear,
                         Byte aday, String amonth, String ayear, String address2, String phone2, String notes, String photo,
                         String xVcard, String xActivesync, Date created, Date modified, Date deprecated,
                         String password, Date login, String role) {
        this.id = id;
        this.domainId = domainId;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.company = company;
        this.title = title;
        this.address = address;
        this.addrLong = addrLong;
        this.addrLat = addrLat;
        this.addrStatus = addrStatus;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.im = im;
        this.im2 = im2;
        this.im3 = im3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
        this.photo = photo;
        this.xVcard = xVcard;
        this.xActivesync = xActivesync;
        this.created = created;
        this.modified = modified;
        this.deprecated = deprecated;
        this.password = password;
        this.login = login;
        this.role = role;
    }
}
