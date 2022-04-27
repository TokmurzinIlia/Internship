package steps;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilsAPI.Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStep {

    Response rs;
    List<String> actualListCountryBorders = new ArrayList<>();


//    @Then("Actual list of boarder {string}")
//    public List<String> actualListOfBoarder(String key) {
//        actualListCountryBorders = Methods.getListBoardersFromResponse(rs, key);
//            return actualListCountryBorders;
//    }

//    @Then("Actual list of boarder equals expectedList {string}")
//    public void actualListOfBoarderEqualsExpectedList(String arg0) {
//        List<String> expected = Arrays.asList(arg0.split(","));
//        System.out.println(expected);
//        assertEquals(expected, actualListCountryBorders); }


}

