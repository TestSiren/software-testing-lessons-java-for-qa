package ru.stqa.addressbook.comporators;

import ru.stqa.addressbook.models.AddressData;

import java.util.Comparator;

public class AddressComparators {
    public static final Comparator<AddressData> byFirstAndLastName =
            Comparator.comparing(AddressData::id)
                    .thenComparing(AddressData::firstname)
                    .thenComparing(AddressData::lastname);

    public static final Comparator<AddressData> byId =
            Comparator.comparing(a -> Integer.parseInt(a.id()));
}
