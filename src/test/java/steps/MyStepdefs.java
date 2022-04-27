package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


import utilsAPI.Methods;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    Response rs;

    String countryCode;

    List<String> actualListCountryBorders = new ArrayList<>();
    @When("User entered valid three-character country code {string}")
    public Response userEnteredValidThreeCharacterCountryCode(String countryCode)  {
        return rs = Methods.getCountryBoarderResponse(countryCode);
    }

    @Then("User get status code 200")
    public void userGetStatusCode() {
        Methods.statusCodeValidate200(rs);
    }


    @Then("Take alpfa2 code from response")
    public String takeAlpfaCodeFromResponse() {
        countryCode = Methods.getListAlpha2CodeFromResponse(rs);
        return countryCode;
    }

    @Then("User get response with alpfa2 code")
    public Response userGetResponseWithAlpfaCode() {
        return rs = Methods.getCountryBoarderResponse(countryCode);
    }

    @Then("Actual list of boarder {string}")
    public List<String> actualListOfBoarder(String key) {
        actualListCountryBorders = Methods.getListBoardersFromResponse(rs, key);
        return actualListCountryBorders;
    }
    @Then("Actual list of boarder equals expectedList {string}")
    public void actualListOfBoarderEqualsExpectedList(String arg0) {
        List<String> expected = Arrays.asList(arg0.split(","));
        //System.out.println(expected);
        assertEquals(expected, actualListCountryBorders); }
}
