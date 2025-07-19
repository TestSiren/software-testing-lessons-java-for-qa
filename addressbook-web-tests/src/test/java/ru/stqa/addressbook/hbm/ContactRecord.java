package ru.stqa.addressbook.hbm;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    @Column(name = "id")
    public int id;

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

    @ManyToMany
    @JoinTable(name = "address_in_groups",
            inverseJoinColumns  = @JoinColumn(name = "group_id"),
            joinColumns = @JoinColumn(name = "id"))
    public List<GroupRecord> groups;

    public ContactRecord() {}

    public ContactRecord(int id, String firstname, String middlename, String lastname,
                         String nickname, String title, String company, String address,
                         String home, String mobile, String work, String fax,
                         String homepage,
                         int bday, String bmonth, String byear,
                         int aday, String amonth, String ayear) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.fax = fax;
        this.homepage = homepage;
        this.bday = Byte.valueOf((byte)bday);
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = Byte.valueOf((byte)aday);
        this.amonth = amonth;
        this.ayear = ayear;
    }
}
