package ru.stqa.addressbook.dataproviders;

import ru.stqa.addressbook.models.AddressData;

import java.util.ArrayList;
import java.util.List;

import static ru.stqa.addressbook.tests.TestBase.*;

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
                                    .withBday(randomInt("day"))
                                    .withBmonth(randomMonths())
                            .withByear(randomYear())
                            .withAday(randomInt("day"))
                            .withAmonth(randomMonths())
                            .withAyear(randomYear())
                            .withMobile("123456")
                            .withAddress("Test address"));
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            result.add(new AddressData()
                    .withFirstname(randomString(i * 5))
                    .withLastname(randomString(i * 5))
                    .withEmail(randomString(i * 5) + "@example.com")
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
                        .withEmail("bademail'")
        ));
        return result;
    }
}
