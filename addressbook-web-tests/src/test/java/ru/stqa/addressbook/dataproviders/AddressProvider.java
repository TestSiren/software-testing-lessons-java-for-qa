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

    public static List<AddressData> addressProvider() throws IOException {
        var result = new ArrayList<AddressData>();
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        var value = mapper.readValue(new File("src/test/resources/address.json"), new TypeReference<List<AddressData>>() {});
        result.addAll(value);
        return result;
    }

    public static List<AddressData> negativeAddressProvider() throws IOException {
        var positive = addressProvider();
        var result = new ArrayList<AddressData>();

        for (AddressData address : positive) {
            AddressData modified = new AddressData()
                    .withFirstname("'" + address.firstname());
            result.add(modified);
        }

        return result;
    }
}
