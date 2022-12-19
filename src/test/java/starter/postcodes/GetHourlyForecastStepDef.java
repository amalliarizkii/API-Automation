package starter.postcodes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetHourlyForecastStepDef {

    @Steps
    CurrentWeatherAPI currentWeatherAPI;

    @Given("Get hourly forecast with postal code {int} using key {string}")
    public void getHourlyForecastWithPostalCodePostal_codeUsingKey(int postal_code, String key) {
        currentWeatherAPI.GetHourlyForecast(postal_code, key);
    }

    @When("Send request get hourly forecast")
    public void sendRequestGetHourlyForecast() {
        SerenityRest.when().get(CurrentWeatherAPI.HOURLY_FORECAST);
    }

    @And("Get hourly forecast with postal code json schema validator")
    public void getHourlyForecastWithPostalCodeJsonSchemaValidator() {
        File json = new File(CurrentWeatherAPI.JSON_FILE+"/GetHourlyForecastJsonValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
