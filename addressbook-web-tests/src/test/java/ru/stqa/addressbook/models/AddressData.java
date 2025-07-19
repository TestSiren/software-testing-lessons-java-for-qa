package ru.stqa.addressbook.models;

import java.util.List;
import java.util.Objects;


public record AddressData(
        String id,
        String firstname,
        String middlename,
        String lastname,
        String nickname,
        String title,
        String company,
        String address,
        String home,
        String mobile,
        String work,
        String fax,
        List<String> emails,
        String homepage,
        int bday,
        String bmonth,
        String byear,
        int aday,
        String amonth,
        String ayear,
        String group,
        String photo) {

    public AddressData() {
        this("", "firstname", "middlename", "lastname", "nickname", "title",
                "company", "address", "home", "mobile", "work", "fax",
                List.of("email@example.com", "email2@example.com", "email3@example.com"),
                "homepage.com", 1, "January", "1990", 1, "January", "2000", "[none]", "");
    }

    public AddressData withId(String id) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withFirstname(String value) {
        return new AddressData(id, value, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withMiddlename(String value) {
        return new AddressData(id, firstname, value, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withLastname(String value) {
        return new AddressData(id, firstname, middlename, value, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withNickname(String value) {
        return new AddressData(id, firstname, middlename, lastname, value, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withTitle(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, value,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withCompany(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                value, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withAddress(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, value, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withHome(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, value, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withMobile(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, value, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withWork(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, value, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withFax(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, value, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withEmail(List<String> value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, value, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withHomepage(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, value, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withBday(int value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, value,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withBmonth(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                value, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withByear(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, value, aday, amonth, ayear, group, photo);
    }

    public AddressData withAday(int value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, value, amonth, ayear, group, photo);
    }

    public AddressData withAmonth(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, value, ayear, group, photo);
    }

    public AddressData withAyear(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, value, group, photo);
    }

    public AddressData withGroup(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, value, photo);
    }

    public AddressData withPhoto(String photo) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, emails, homepage, bday,
                bmonth, byear, aday, amonth, ayear, group, photo);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressData that = (AddressData) o;
        return bday == that.bday &&
                aday == that.aday &&
                Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(middlename, that.middlename) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(title, that.title) &&
                Objects.equals(company, that.company) &&
                Objects.equals(address, that.address) &&
                Objects.equals(home, that.home) &&
                Objects.equals(work, that.work) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(homepage, that.homepage) &&
                Objects.equals(bmonth, that.bmonth) &&
                Objects.equals(byear, that.byear) &&
                Objects.equals(amonth, that.amonth) &&
                Objects.equals(ayear, that.ayear) &&
                Objects.equals(group, that.group)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname, nickname, title, company,
                address, home, mobile, work, fax, emails, mobile, homepage,
                bday, bmonth, byear, aday, amonth, ayear, group);
    }
}