package ru.stqa.addressbook.models;

public record AddressData(String firstname, String middlename, String lastname, String nickname, String title,
                          String company, String address, String home, String mobile, String work, String fax,
                          String email, String email2, String email3, String homepage) {

    public AddressData() {
        this("","","");
    }
}