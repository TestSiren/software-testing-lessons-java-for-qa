package ru.stqa.addressbook.hbm;

import jakarta.persistence.*;

@Entity
@Table(name = "address_in_groups")
public class ContactInGroup {

    @EmbeddedId
    public ContactInGroupId id;

    public ContactInGroup() {}

    public ContactInGroup(ContactInGroupId id) {
        this.id = id;
    }

    public int getContactId() {
        return id.contactId;
    }

    public int getGroupId() {
        return id.groupId;
    }
}
