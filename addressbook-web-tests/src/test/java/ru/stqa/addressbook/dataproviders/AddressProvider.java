package ru.stqa.addressbook.dataproviders;

import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.models.AddressData;

import java.util.ArrayList;
import java.util.List;

public class AddressProvider {

    public static List<AddressData> addressProvider() {
        var result = new ArrayList<AddressData>();

        for (var firstname : List.of("John")) {
            for (var lastname : List.of("Doe")) {
                for (var email : List.of("john@example.com")) {
                    result.add(new AddressData()
                            .withFirstname(firstname)
                            .withLastname(lastname)
                            .withEmail(email)
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
                    .withEmail(CommonFunctions.randomString(i * 5) + "@example.com")
                    .withMobile("99999" + i)
                    .withPhoto(CommonFunctions.randomFile("src/test/resources/images/"))
                    .withAddress("Random address " + i));
        }

        return result;
    }

    public static List<AddressData> negativeAddressProvider() {
        var result = new ArrayList<AddressData>(List.of(
                new AddressData()
                        .withFirstname("Bad")
                        .withLastname("Email")
                        .withEmail("bademail'")
        ));
        return result;
    }
}
