package ru.stqa.addressbook.dataproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.common.CommonFunctions;


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

        if (addressFilePath != null && !addressFilePath.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            var fromFile = mapper.readValue(new File(addressFilePath), new TypeReference<List<AddressData>>() {});
            result.addAll(fromFile);
        }

        for (var firstname : List.of("John")) {
            for (var lastname : List.of("Doe")) {
                for (var email : List.of("john@example.com")) {
                    result.add(new AddressData()
                            .withFirstname(firstname)
                            .withLastname(lastname)
                            .withEmail(List.of(email))
                            .withBday(CommonFunctions.randomDay())
                            .withBmonth(CommonFunctions.randomMonths())
                            .withByear(CommonFunctions.randomYear())
                            .withAday(CommonFunctions.randomDay())
                            .withAmonth(CommonFunctions.randomMonths())
                            .withAyear(CommonFunctions.randomYear())
                            .withMobile("99999999999")
                            .withAddress("Test address"));
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            result.add(new AddressData()
                    .withFirstname(CommonFunctions.randomString(i * 5))
                    .withLastname(CommonFunctions.randomString(i * 5))
                    .withEmail(List.of(CommonFunctions.randomString(i * 5) + "@example.com"))
                    .withMobile("99999" + i)
                    .withAddress("Random address " + i));
        }

        return result;
    }

    public static List<AddressData> negativeAddressProvider() throws IOException {
        var positive = addressProvider();
        var result = new ArrayList<AddressData>();

        for (AddressData address : positive) {
            AddressData modified = address.withFirstname("'" + address.firstname());
            result.add(modified);
        }

        return result;
    }
}
