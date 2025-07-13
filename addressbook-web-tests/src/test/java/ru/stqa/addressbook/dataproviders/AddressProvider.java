package ru.stqa.addressbook.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.models.GroupData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressProvider {
    private static String addressFilePath;

    public static void setAddressFilePath(String path) {
        addressFilePath = path;
    }

    public static List<AddressData> addressProvider() throws IOException {
        var result = new ArrayList<AddressData>();
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        var value = mapper.readValue(new File(addressFilePath), new TypeReference<List<AddressData>>() {});
        result.addAll(value);
        return result;
    }


        for (var firstname : List.of("John")) {
            for (var lastname : List.of("Doe")) {
                for (var email : List.of("john@example.com")) {
                    result.add(new AddressData()
                            .withFirstname(firstname)
                            .withLastname(lastname)
                            .withEmail(List.of(email))
                                    .withBday(randomDay())
                                    .withBmonth(randomMonths())
                            .withByear(randomYear())
                            .withAday(randomDay())
                            .withAmonth(randomMonths())
                            .withAyear(randomYear())
                            .withMobile("99999999999")
                            .withAddress("Test address"));
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            result.add(new AddressData()
                    .withFirstname(randomString(i * 5))
                    .withLastname(randomString(i * 5))
                    .withEmail(List.of(randomString(i * 5) + "@example.com"))
                    .withMobile("99999" + i)
                    .withAddress("Random address " + i));
        }

        return result;
    }

    public static List<AddressData> negativeAddressProvider() {
        var result = new ArrayList<AddressData>(List.of(
                new AddressData()
                        .withFirstname("Bad")
                        .withLastname("Email")
                        .withEmail(List.of("bademail'"))
        ));
        return result;
    }
}
