package starter.postcodes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class GetCurrentWeatherStepDef {

    @Steps
    CurrentWeatherAPI currentWeatherAPI;

    @Given("Get current weather with value lat {double} and lon {double} using key {string}")
    public void getCurrentWeatherWithValueLatLatAndLonLonUsingKey(double lat, double lon, String key) {
        currentWeatherAPI.GetCurrentWeatherData(lat, lon, key);
    }

    @When("Send request get current weather")
    public void sendRequestGetCurrentWeather() {
        SerenityRest.when().get(CurrentWeatherAPI.CURRENT_WEATHER);
    }

    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCodeOK(int OK){
        SerenityRest.then().statusCode(OK);
    }

    @And("Get current weather with value lan and lon json schema validator")
    public void getCurrentWeatherWithValueLanAndLonJsonSchemaValidator() {
        File json = new File(CurrentWeatherAPI.JSON_FILE+"/GetCurrentWeatherJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
