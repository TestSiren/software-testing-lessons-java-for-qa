package ru.stqa.addressbook.models;

public record AddressData(String id, String firstname, String middlename,
                          String lastname, String nickname, String title,
                          String company, String address, String home,
                          String mobile, String work, String fax, String email,
                          String email2, String email3, String homepage, int bday,
                          String bmonth, String byear, int aday, String amonth,
                          String ayear, String group, String photo) {

    public AddressData() {
        this("", "firstname", "middlename", "lastname", "nickname", "title",
                "company", "address", "home", "mobile", "work", "fax", "email@example.com",
                "email2@example.com", "email3@example.com", "homepage.com", 1,
                "January", "1990", 1, "January", "2000", "[none]", "");
    }

    public AddressData withPhoto(String photo) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, email, email2, email3,
                homepage, bday, bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withId(String id) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title,
                company, address, home, mobile, work, fax, email, email2, email3,
                homepage, bday, bmonth, byear, aday, amonth, ayear, group, photo);
    }

    public AddressData withFirstname(String value) {
        return new AddressData(id, value, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withMiddlename(String value) {
        return new AddressData(id, firstname, value, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withLastname(String value) {
        return new AddressData(id, firstname, middlename, value, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withNickname(String value) {
        return new AddressData(id, firstname, middlename, lastname, value, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withTitle(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, value, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withCompany(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, value, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withAddress(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, value, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withHome(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, value,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withMobile(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                value, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withWork(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, value, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withFax(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, value, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withEmail(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, value, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withEmail2(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, value, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withEmail3(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, value, homepage, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withHomepage(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, value, bday, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withBday(int value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, value, bmonth, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withBmonth(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, value, byear,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withByear(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, value,
                aday, amonth, ayear, group, photo);
    }

    public AddressData withAday(int value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                value, amonth, ayear, group, photo);
    }

    public AddressData withAmonth(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, value, ayear, group, photo);
    }

    public AddressData withAyear(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, value, group, photo);
    }

    public AddressData withGroup(String value) {
        return new AddressData(id, firstname, middlename, lastname, nickname, title, company, address, home,
                mobile, work, fax, email, email2, email3, homepage, bday, bmonth, byear,
                aday, amonth, ayear, value, photo);
    }
}
