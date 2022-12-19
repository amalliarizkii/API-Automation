package starter.postcodes;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CurrentWeatherAPI {

    public static String URL = "http://api.weatherbit.io/v2.0";
    public static final String CURRENT_WEATHER = URL+"/current";

    public static final String HOURLY_FORECAST = URL+"/forecast/hourly";
    public static final String DIR = System.getProperty("user.dir");

    public static final String JSON_FILE = DIR+"/src/test/resources/JSON";

    @Step("Get current weather data with value lan and lon")
    public void GetCurrentWeatherData(double lat, double lon, String key){
        SerenityRest.given()
                .queryParam("lat",lat)
                .queryParam("lon",lon)
                .queryParam("key",key);
    }

    @Step("Get hourly forecast with postal code")
    public void GetHourlyForecast(int postal_code, String key){
        SerenityRest.given()
                .queryParam("postal_code",postal_code)
                .queryParam("key",key);
    }
}
