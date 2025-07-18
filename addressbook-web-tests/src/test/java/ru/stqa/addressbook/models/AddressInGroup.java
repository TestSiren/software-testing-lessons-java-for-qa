package ru.stqa.addressbook.models;

import java.util.Objects;

public record AddressInGroup(
        String contactId,
        String groupId
) {
    public AddressInGroup {
        if (contactId == null) contactId = "";
        if (groupId == null) groupId = "";
    }

    public AddressInGroup withContactId(String contactId) {
        return new AddressInGroup(contactId, this.groupId);
    }

    public AddressInGroup withGroupId(String groupId) {
        return new AddressInGroup(this.contactId, groupId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AddressInGroup) obj;
        return Objects.equals(this.contactId, that.contactId) &&
                Objects.equals(this.groupId, that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, groupId);
    }
}