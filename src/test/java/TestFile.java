import PojoClass.JSONFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestFile {

    File file;
    ObjectMapper objectMapper;
    JSONFile jsonFile;
    SoftAssert softAssert;
    @BeforeClass
    public void before() throws IOException {

        file = new File("./src/test/java/resources/JsonFile.json");
        objectMapper = new ObjectMapper();
        jsonFile = objectMapper.readValue(file, JSONFile.class);
        softAssert = new SoftAssert();
    }

    @Test
    public void moneySpent(){
       double value = jsonFile.getPlayer().stream().filter(Predicate
               .not(i -> i.getCountry().contentEquals("India"))).collect(Collectors.toList()).stream()
               .mapToDouble(i->Double.parseDouble(i.getPrice_in_crores())).sum();
       softAssert.assertEquals(value, 36.5);
    }
    @Test
    public void allRounders(){
        jsonFile.getPlayer().stream().filter(i -> i.getRole().contentEquals("All-Rounder")).collect(Collectors.toList()).forEach(i -> System.out.println(i.getName()));
    }
}
