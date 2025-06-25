package ru.stqa.addressbook.comporators;

import ru.stqa.addressbook.models.GroupData;

import java.util.Comparator;

public class GroupComporators {
    public static final Comparator<GroupData> compareById = (o1, o2) -> {
        return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
    };
}
