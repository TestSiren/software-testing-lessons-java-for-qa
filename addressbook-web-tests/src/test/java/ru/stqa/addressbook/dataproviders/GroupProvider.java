package ru.stqa.addressbook.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.models.GroupData;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ru.stqa.addressbook.common.CommonFunctions;


public class GroupProvider  {
    private static String groupsFilePath;

    public static void setGroupsFilePath(String path) {
        groupsFilePath = path;
    }
    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File(groupsFilePath), new TypeReference<List<GroupData>>() {});
        result.addAll(value);
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
    public static List<GroupData> singleRandomGroup() {
        return List.of(new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(10))
                .withFooter(CommonFunctions.randomString(10))
                );
    }
}
