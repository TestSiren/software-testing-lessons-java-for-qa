package ru.stqa.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;

import static ru.stqa.addressbook.common.CommonFunctions.randomString;

public class Generator {
    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-c"})
    int count;

    public static void main(String ... argv) {
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(argv);
        generator.run();
    }

    private void run() {
        var data = generate();
        save(data);
    }



    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("address".equals(type))
        {
            return generateAddress();
        } else
        {
            throw new IllegalArgumentException("Нетзвестный тип данных"+ type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10)));
        }
        return result;
    }

    private Object generateAddress() {
        return null;
    }

    private void save(Object data) {
    }
}
