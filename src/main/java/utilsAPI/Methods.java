package utilsAPI;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static endpoints.EndPoints.*;
import static io.restassured.RestAssured.given;

public class Methods {
    @Step("Getting a response by value {0}")
    public static Response getCountryBoarderResponse(String countryCode){
       return given()
                .baseUri(BASEURI)
                .basePath(BASEPATH)
                .contentType(ContentType.JSON)
                .when().get(CODES+countryCode);
    }

    @Step("Getting a list borders from response by value {0} and {1}")
    public static List<String> getListBoardersFromResponse(Response response, String key){
       return response
               .then().extract().jsonPath().get(key);
    }

}
