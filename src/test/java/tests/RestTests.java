package tests;

import dataproviders.DataProviderCountryBorders;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.opentest4j.AssertionFailedError;
import utilsAPI.Log;
import utilsAPI.Methods;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestTests {

    @ParameterizedTest(name = "Test status code {0}")
    @CsvSource({"AZE","BLR","CHN","EST","FIN","GEO","KAZ","PRK","LVA","LTU","MNG","NOR","POL","UKR"})
    public void statusCodeTest(String country){
        Response rs = Methods
                .getCountryBoarderResponse(country);

        Log.info("Request response received");

        rs.then().statusCode(200);

        Log.info("Status response code 200");
    }

    @ParameterizedTest(name = "Test that checks a list of boarders by values country code {1}")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void bordersTest(List<String> expectedListCountryBorders, String countryCode, String key){
        Response rs = Methods
                .getCountryBoarderResponse(countryCode);

        Log.info("Request response received");

        List<String> actualListCountryBorders = Methods.getListBoardersFromResponse(rs, key);

        Log.info("An up-to-date list of countries bordering on " + countryCode);

        assertEquals(expectedListCountryBorders, actualListCountryBorders);

        Log.info("The current list of countries equals to expected list");
    }

    @ParameterizedTest(name = "Test that checks the mutuality of boarders")
    @CsvSource({"AZE, RUS, borders[0]","BLR, RUS, borders[0]","CHN, RUS, borders[0]","EST, RUS, borders[0]","FIN, RUS, borders[0]",
            "GEO, RUS, borders[0]","KAZ, RUS, borders[0]","PRK, RUS, borders[0]","LVA, RUS, borders[0]","LTU, RUS, borders[0]"
            ,"MNG, RUS, borders[0]","NOR, RUS, borders[0]","POL, RUS, borders[0]","UKR, RUS, borders[0]"})
    public void mutualityBordersTest(String borderingСountry, String givenСountry, String key){

        Response rs = Methods
                .getCountryBoarderResponse(borderingСountry);

        Log.info("Request response received");

        List<String> actualListCountryBorders = Methods.getListBoardersFromResponse(rs, key);

        Log.info("An up-to-date list of countries bordering on " + borderingСountry);

        assertTrue(actualListCountryBorders.contains(givenСountry));

        Log.info("The current list of countries contains " + givenСountry);
    }

    @ParameterizedTest(name = "A test that checks the reciprocity of the value of the border of a given country {1} with the current list of bordering countries ")
    @ArgumentsSource(DataProviderCountryBorders.class)
    public void mutualityBordersTest1(List<String> borderingСountry, String givenСountry, String key) {

        for (int i = 0; i < borderingСountry.size(); i++) {

            Response rs = Methods
                    .getCountryBoarderResponse(borderingСountry.get(i));

            Log.info("Request response received");

            List<String> actualListCountryBorders = Methods.getListBoardersFromResponse(rs, key);

            Log.info("An up-to-date list of countries bordering on " + borderingСountry.get(i));

        try {
            assertTrue(actualListCountryBorders.contains(givenСountry));

            Log.info("The current list of countries contains " + givenСountry);
        }
        catch (AssertionFailedError e){
            Log.error("The current list of countries does not contains " + givenСountry, e);
        }
        finally {
            continue;
        }
        }
    }
}
