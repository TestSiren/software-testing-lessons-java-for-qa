package ru.stqa.addressbook.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.models.GroupData;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupProvider  {
    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        var value = mapper.readValue(new File("src/test/resources/groups.json"), new TypeReference<List<GroupData>>() {});
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

}
