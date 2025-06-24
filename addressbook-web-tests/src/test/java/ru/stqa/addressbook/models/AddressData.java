package ru.stqa.addressbook.models;

public record AddressData(String id, String firstname, String middlename,
                          String lastname, String nickname, String title,
                          String company, String address, String home,
                          String mobile, String work, String fax, String email,
                          String email2, String email3, String homepage, int bday,
                          String bmonth, String byear, int aday, String amonth,
                          String ayear, String group) {

    public AddressData() {
        this("", "firstname", "middlename", "lastname", "nickname", "title",
                "company", "address", "home", "mobile", "work", "fax", "email@example.com",
                "email2@example.com", "email3@example.com", "homepage.com", 1,
                "January", "1990", 1, "January", "2000", "[none]");
    }

    public AddressData withId(String id) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, email, email2, email3,
                homepage, bday, bmonth, byear, aday, amonth, ayear, group);
    }

    public AddressData withFirstname(String value) {
        return new AddressData(id, value, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withMiddlename(String value) {
        return new AddressData(id, firstname, value, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withLastname(String value) {
        return new AddressData(id, firstname, middlename, value, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withNickname(String value) {
        return new AddressData(id, firstname, middlename, lastname, value, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withTitle(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, value, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withCompany(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, value, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withAddress(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, value, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withHome(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, value,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withMobile(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                value, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withWork(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, value, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withFax(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, value, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withEmail(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, value, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withEmail2(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, value, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withEmail3(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, value, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withHomepage(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, value, bday, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withBday(int value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, value, bmonth, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withBmonth(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, value, byear,
                aday, amonth, ayear, group);
    }

    public AddressData withByear(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, value,
                aday, amonth, ayear, group);
    }

    public AddressData withAday(int value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                value, amonth, ayear, group);
    }

    public AddressData withAmonth(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, value, ayear, group);
    }

    public AddressData withAyear(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, value, group);
    }

    public AddressData withGroup(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, value);
    }
}
