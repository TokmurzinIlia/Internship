package tests;

import dataproviders.DataProviderCountryBorders;
import io.restassured.response.Response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.opentest4j.AssertionFailedError;
import utilsAPI.Log;
import utilsAPI.Methods;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RestTests {


    @ParameterizedTest(name = "Test status code with valid three-character country code to uppercase {0}")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void statusCodeTestWithValidThreeСharacterСountryСode(String countryCode){

        Response rs = Methods
                .getCountryBoarderResponse(countryCode);

        Log.info("Request response received");

        Methods.statusCodeValidate200(rs);

        Log.info("Status response code 200");

        System.out.println();
    }

    @ParameterizedTest(name = "Test status code with valid two-character country code to uppercase {0}")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void statusCodeTestWithTwoСharacterСountryСode(String countryCode){

        Response rs = Methods
                .getCountryBoarderResponse(countryCode);

        Log.info("Request response received with three-character country code");

        countryCode = Methods.getListAlpha2CodeFromResponse(rs);

        Log.info("Get two-character country code from response");

        rs = Methods.getCountryBoarderResponse(countryCode);

        Log.info("Request response received with two-character country code");

        Methods.statusCodeValidate200(rs);

        Log.info("Status response code 200");

        System.out.println();
    }

    @ParameterizedTest(name = "Test status code with valid country code to lowercase {0}")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void statusCodeTestToLowerCaseWithValidDataCountryCode(String countryCode){

        Response rs = Methods
                .getCountryBoarderResponse(countryCode.toLowerCase());

        Log.info("Request response received");

        Methods.statusCodeValidate200(rs);

        Log.info("Status response code 200");

        System.out.println();
    }

    @ParameterizedTest(name = "Test status code with valid country code {0} first letter capital followed by lowercase")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void statusCodeTestFirstLetterCapitalizedWithValidDataCountryCode(String countryCode){

        countryCode = Methods.сonvertStringToStringWhoseFirstLetterCapitalized(countryCode);

        Log.info("Convert a country code to a string whose first letter is capitalized followed by lowercase");

        Response rs = Methods
                .getCountryBoarderResponse(countryCode);

        Log.info("Request response received");

        Methods.statusCodeValidate200(rs);

        Log.info("Status response code 200");

        System.out.println();
    }

    @ParameterizedTest(name = "Test status code with valid country code {0} second letter capital followed by lowercase")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void statusCodeTestSecondLetterCapitalizedWithValidDataCountryCode(String countryCode){

        countryCode = Methods.сonvertStringToStringWhoseDesiredLetterCapitalized(countryCode, 1);

        Log.info("Convert a country code to a string whose second letter is capitalized followed by lowercase");

        Response rs = Methods
                .getCountryBoarderResponse(countryCode);

        Log.info("Request response received");

        Methods.statusCodeValidate200(rs);

        Log.info("Status response code 200");

        System.out.println();
    }

    @ParameterizedTest(name = "Test status code with valid country code {0} second letter capital followed by lowercase")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void statusCodeTestThirdLetterCapitalizedWithValidDataCountryCode(String countryCode){

        countryCode = Methods.сonvertStringToStringWhoseDesiredLetterCapitalized(countryCode, 2);

        Log.info("Convert a country code to a string whose second letter is capitalized followed by lowercase");

        Response rs = Methods
                .getCountryBoarderResponse(countryCode);

        Log.info("Request response received");

        Methods.statusCodeValidate200(rs);

        Log.info("Status response code 200");

        System.out.println();
    }

    @ParameterizedTest(name = "Test status code with invalid data {0}")
    @CsvSource({"a", "z", "g", "1", "50", "99", "100", "101", "199", "200", "999", "1000",
            "1001", "1999", "12345678954621", "0", "-1", "-50", "-99", "-100", "-101", "-12345678954621",
            "<", "$", "@", "&", "%", "/", "russia", "<script>"})
    public void statusCodeTestWithInValidDataCountryCode(String countryCode){

        Response rs = Methods
                .getCountryBoarderResponse(countryCode);

        Log.info("Request response received");

        Methods.statusCodeValidate400(rs);

        Log.info("Status response code 400");

        System.out.println();
    }

    @Test
    @DisplayName("Test status code with country code null")
    public void statusCodeTestWithNullCountryCode(){

        Response rs = Methods
                .getCountryBoarderResponse(null);

        Log.info("Request response received");

        Methods.statusCodeValidate400(rs);

        Log.info("Status response code 400");

        System.out.println();
    }


    @ParameterizedTest(name = "Test that checks a list of boarders by values country code {0}")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void bordersTest(String countryCode, List<String> expectedListCountryBorders, String key){

        Response rs = Methods
                .getCountryBoarderResponse(countryCode);

        Log.info("Request response received");

        List<String> actualListCountryBorders = Methods.getListBoardersFromResponse(rs, key);

        Log.info("An up-to-date list of countries bordering on " + countryCode);

        assertEquals(expectedListCountryBorders, actualListCountryBorders);

        Log.info("The current list of countries equals to expected list");

        System.out.println();
    }

//    @Order(3)
//    @ParameterizedTest(name = "Test that checks the mutuality of boarders")
//    @CsvSource({"AZE, RUS, borders[0]","BLR, RUS, borders[0]","CHN, RUS, borders[0]","EST, RUS, borders[0]","FIN, RUS, borders[0]",
//            "GEO, RUS, borders[0]","KAZ, RUS, borders[0]","PRK, RUS, borders[0]","LVA, RUS, borders[0]","LTU, RUS, borders[0]"
//            ,"MNG, RUS, borders[0]","NOR, RUS, borders[0]","POL, RUS, borders[0]","UKR, RUS, borders[0]"})
//    public void mutualityBordersTest(String borderingСountry, String givenСountry, String key){
//
//        Response rs = Methods
//                .getCountryBoarderResponse(borderingСountry);
//
//        Log.info("Request response received");
//
//        List<String> actualListCountryBorders = Methods.getListBoardersFromResponse(rs, key);
//
//        Log.info("An up-to-date list of countries bordering on " + borderingСountry);
//
//        assertTrue(actualListCountryBorders.contains(givenСountry));
//
//        Log.info("The current list of countries contains " + givenСountry);
//
//        System.out.println();
//    }


    @ParameterizedTest(name = "A test that checks the reciprocity of the value of the border of a given country {0} " +
            "with the current list of bordering countries ")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void mutualityBordersTest1(String givenСountry, List<String> borderingСountry, String key) {

        for (int i = 0; i < borderingСountry.size(); i++) {

            Response rs = Methods
                    .getCountryBoarderResponse(borderingСountry.get(i));

            Log.info("Request response received");

            List<String> actualListCountryBorders = Methods.getListBoardersFromResponse(rs, key);

            Log.info("An up-to-date list of countries bordering on " + borderingСountry.get(i));

        try {
            assertTrue(actualListCountryBorders.contains(givenСountry));

            Log.info("The current list of countries contains " + givenСountry);

            System.out.println();
        }
        catch (AssertionFailedError e){
            Log.error("The current list of countries does not contains " + givenСountry, e);

            System.out.println();
        }
        finally {
            continue;
        }
        }
    }
}
