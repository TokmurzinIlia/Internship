package steps;

import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import utilsAPI.Methods;

public class Steps {
    Response rs;
    @Тогда("^цена гаджента равна \"([^\"]*)\"$")
    public Response checkGadgetPrice(String countryCode) {
        return rs = Methods.getCountryBoarderResponse(countryCode);
    }

    @Тогда("статус код 200")
    public void статусКод() {
        System.out.println("Статус код:" + rs.getStatusCode());
        Methods.statusCodeValidate200(rs);
    }
}
