package tests;

import dataproviders.DataProviderCountryBordersRussia;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
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
        Methods
                .getCountryBoarderResponse(country)
                .then().statusCode(200);
    }

    @ParameterizedTest(name = "Test that checks a list of boarders by values country code {2}")
    @ArgumentsSource(DataProviderCountryBordersRussia.class)
    public void bordersTest(List<String> countryBorders, String countryCode, String key){
        Response rs = Methods
                .getCountryBoarderResponse(countryCode);
        List<String> actualList = Methods.getListBoardersFromResponse(rs, key);

        assertEquals(countryBorders, actualList);
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
