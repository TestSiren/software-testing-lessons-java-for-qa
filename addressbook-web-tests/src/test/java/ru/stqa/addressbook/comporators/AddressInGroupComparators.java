package ru.stqa.addressbook.comporators;

import ru.stqa.addressbook.models.AddressInGroup;

import java.util.Comparator;

public class AddressInGroupComparators {
    public static final Comparator<AddressInGroup> byId =
            Comparator.comparing(a -> Integer.parseInt(a.contactId()));
}

