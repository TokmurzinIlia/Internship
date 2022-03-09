package utilsAPI;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static endpoints.EndPoints.*;
import static io.restassured.RestAssured.given;

public class Methods {

    private static RequestSpecification requestSpec = ApiSpecification.getRequestSpecification();

    @Step("Getting a response by value {0}")
    public static Response getCountryBoarderResponse(String countryCode){
       return given()
                   .spec(requestSpec)
                   .when()
                   .get(CODES+countryCode);
    }

    @Step("Status code validate {2}}")
    public static ValidatableResponse statusCodeValidate200(Response response, int statusCode){
        return response
                    .then()
                    .statusCode(statusCode);
    }

    @Step("Status code validate 200")
    public static ValidatableResponse statusCodeValidate200(Response response){
       return response
                   .then()
                   .statusCode(200);
    }

    @Step("Status code validate 400")
    public static ValidatableResponse statusCodeValidate400(Response response){
       return response
                   .then()
                   .statusCode(400);
    }

    @Step("Getting a list borders from response by value {0} and {1}")
    public static List<String> getListBoardersFromResponse(Response response, String key){
       return response
                   .then().extract().jsonPath().get(key);
    }

    @Step("Convert a string to a string whose first letter is capitalized followed by lowercase")
    public static String сonvertStringToStringWhoseFirstLetterCapitalized(String str) {
        return
                StringUtils.capitalize(str.toLowerCase());
    }

    @Step("Convert a string to a string whose second letter is capitalized followed by lowercase")
    public static String сonvertStringToStringWhoseDesiredLetterCapitalized(String str, int desiredChar) {

        StringBuilder builder = new StringBuilder(str.toLowerCase());
        builder.setCharAt(desiredChar, Character.toUpperCase(str.charAt(desiredChar)));
        return builder.toString();

    }

    @Step("Remove last char")
    public static String removeLastChar(String str) {
        return StringUtils.chop(str);
    }

    @Step("Getting a list borders from response by value {0}")
    public static String getListAlpha2CodeFromResponse(Response response){
        return response
                    .then().extract().jsonPath().get("alpha2Code[0]");
    }
}
