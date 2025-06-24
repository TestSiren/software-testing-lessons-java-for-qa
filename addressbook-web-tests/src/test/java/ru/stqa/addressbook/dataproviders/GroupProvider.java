package ru.stqa.addressbook.dataproviders;

import ru.stqa.addressbook.models.GroupData;

import static ru.stqa.addressbook.tests.TestBase.randomString;

import java.util.ArrayList;
import java.util.List;

public class GroupProvider {
    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("", "group name")) {
            for (var header : (List.of("", "group header"))) {
                for (var footer : (List.of("", "group footer"))) {
                    result.add(new GroupData(name, header, footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new GroupData(randomString(i * 10), randomString(i * 10), randomString(i * 10)));
        }
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("group name'", "", ""))
        );
        return result;
    }

}
