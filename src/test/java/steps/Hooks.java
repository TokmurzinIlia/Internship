package steps;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilsAPI.Log;



public class Hooks {

    @Before
    public void beforeTest(Scenario scenario) {
        Log.info("--- Старт сценария '" + scenario.getName() + "' ---");


    }

    @After
    public void afterTest(Scenario scenario) {
        if (scenario.isFailed()) {
            Log.warn("--- Сценарий '" + scenario.getName() + "' провалился ---");
        } else {
            Log.info("--- Сценарий '" + scenario.getName() + "' выполнен успешно ---");
        }
        System.out.println("****************************************************************************************************************");
        System.out.println("****************************************************************************************************************");
        System.out.println("****************************************************************************************************************");}

}