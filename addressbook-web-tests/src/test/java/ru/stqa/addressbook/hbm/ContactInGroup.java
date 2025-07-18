package ru.stqa.addressbook.hbm;

import jakarta.persistence.*;

@Entity
@Table(name = "address_in_groups")
public class ContactInGroup {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "group_id")
    public int group_id;

    public ContactInGroup() {}

    public ContactInGroup(int id, int group_id) {
        this.id = id;
        this.group_id=group_id;
    }

}
