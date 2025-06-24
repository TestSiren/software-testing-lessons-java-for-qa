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
                    result.add(new GroupData()
                            .withName(name)
                            .withHeader(header)
                            .withFooter(footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new GroupData().withName(randomString(i * 10)).withHeader(randomString(i * 10)).withFooter(randomString(i * 10)));
        }
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                (new GroupData().withName(randomString(10)).withHeader(randomString(10)).withFooter(randomString(10)))));
        return result;
    }

}
