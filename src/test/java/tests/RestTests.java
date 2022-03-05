package tests;

import dataproviders.DataProviderCountryBorders;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import utilsAPI.Log;
import utilsAPI.Methods;

import java.util.List;

import static endpoints.EndPoints.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestTests {

    @ParameterizedTest(name = "Test status code")
    @CsvSource({"RUS"})
    public void statusCodeTest(String country){
        Response rs = Methods
                .getCountryBoarderResponse(country);

        Log.info("Request response received");

        rs.then().statusCode(200);

        Log.info("Status response code 200");
    }

    @ParameterizedTest(name = "Test that checks a list of boarders by values country code {2}")
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
    @CsvSource({"AZE","BLR","CHN","EST","FIN","GEO","KAZ","PRK","LVA","LTU","MNG","NOR","POL","UKR"})
    public void mutualityBordersTest(String country){
        List<String> actualList = given()
                .baseUri(BASEURI)
                .basePath(BASEPATH)
                .contentType(ContentType.JSON)
                .when().get(CODES+country)
                .then().extract().jsonPath().getList("borders[0]");
        //System.out.println(actualList);
        assertTrue(actualList.contains("RUS"));
    }
}
