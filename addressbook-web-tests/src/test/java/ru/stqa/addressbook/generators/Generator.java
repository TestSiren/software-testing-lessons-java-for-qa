package ru.stqa.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.common.CommonFunctions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generator {
    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-c"})
    int count;

    @Parameter(names = {"--imagesDir", "-id"})
    String imagesDir = "/images";

    public static void main(String ... argv) throws IOException {
            var generator = new Generator();
            JCommander.newBuilder()
                    .addObject(generator)
                    .build()
                    .parse(argv);
            generator.run();
    }


    private void run() throws IOException {
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
        var result = new ArrayList<AddressData>();
        for (int i = 0; i < count; i++) {
            result.add(new AddressData()
                    .withFirstname(CommonFunctions.randomString(i * 5))
                    .withLastname(CommonFunctions.randomString(i * 5))
                    .withEmail(List.of(CommonFunctions.randomString(i * 5) + "@example.com"))
                    .withBday(CommonFunctions.randomDay())
                    .withPhoto(CommonFunctions.randomFile(imagesDir))
                    .withBmonth(CommonFunctions.randomMonths())
                    .withByear(CommonFunctions.randomYear())
                    .withAday(CommonFunctions.randomDay())
                    .withAmonth(CommonFunctions.randomMonths())
                    .withAyear(CommonFunctions.randomYear())
                    .withMobile("99999999999")
                    .withAddress("Test address"));
        }
        return result;
    }

    private void save(Object data) throws IOException {
        ObjectMapper mapper;

        switch (format) {
            case "json" -> mapper = new ObjectMapper();
            case "yaml" -> mapper = new YAMLMapper();
            case "xml"  -> mapper = new XmlMapper();
            default     -> throw new IllegalArgumentException("Unsupported format: " + format);
        }

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String serialized = mapper.writeValueAsString(data);

        try (var writer = new FileWriter(output)) {
            writer.write(serialized);
        }
    }
}
