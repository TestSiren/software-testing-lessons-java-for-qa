package ru.stqa.addressbook.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.models.GroupData;

import static ru.stqa.addressbook.tests.TestBase.randomString;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupProvider {
    private static String groupsFilePath;

    public static void setGroupsFilePath(String path) {
        groupsFilePath = path;
    }

    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();

        if (groupsFilePath != null && !groupsFilePath.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(groupsFilePath);
            if (file.exists() && file.length() > 0) {
                var fromFile = mapper.readValue(file, new TypeReference<List<GroupData>>() {});
                result.addAll(fromFile);
                return result;
            }
        }

        // Если файл не задан или пустой — генерируем данные
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new GroupData()
                            .withName(name)
                            .withHeader(header)
                            .withFooter(footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new GroupData()
                    .withName(randomString(i * 10))
                    .withHeader(randomString(i * 10))
                    .withFooter(randomString(i * 10)));
        }

        return result;
    }

    public static List<GroupData> negativeGroupProvider() throws IOException {
        var positive = groupProvider();
        var result = new ArrayList<GroupData>();

        for (GroupData group : positive) {
            GroupData modified = new GroupData()
                    .withName("'" + group.name())
                    .withHeader(group.header())
                    .withFooter(group.footer());
            result.add(modified);
        }

        return result;
    }
}
