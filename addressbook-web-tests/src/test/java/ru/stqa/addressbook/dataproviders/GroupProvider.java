package ru.stqa.addressbook.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.models.GroupData;

import static ru.stqa.addressbook.common.CommonFunctions.randomString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupProvider {
    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
//        for (var name : List.of("", "group name")) {
//            for (var header : (List.of("", "group header"))) {
//                for (var footer : (List.of("", "group footer"))) {
//                    result.add(new GroupData()
//                            .withName(name)
//                            .withHeader(header)
//                            .withFooter(footer));
//                }
//            }
//        }
//        var json = "";
//        try (var reader = new FileReader("src/test/resources/generateFiles/groups.json");
//        var breader = new BufferedReader(reader)) {
//            var line = breader.readLine();
//            while (line != null) {
//             json = json + line;
//             line = breader.readLine();
//            }
//        }
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        var value = mapper.readValue(new File("src/test/resources/generateFiles/groups.json"), new TypeReference<List<GroupData>>() {});
        result.addAll(value);
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                (new GroupData().withName("'" + randomString(10)).withHeader(randomString(10)).withFooter(randomString(10)))));
        return result;
    }

}
