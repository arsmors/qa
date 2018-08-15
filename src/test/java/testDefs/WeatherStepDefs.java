package testDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Response;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class WeatherStepDefs {
    private WeatherRequester weatherRequester = new WeatherRequester();
    private Response response;

    @When("we getting weather from server")
    public void get_weather() {
        response = weatherRequester.getWeather();
    }

    @Then("lon is (.*)")
    public void check_lon(BigDecimal lon) {
        assertEquals("Wrong LON", lon, response.getCoord().getLon());
    }

    @Then("lat is (.*)")
    public void check_lat(BigDecimal lat) {
        assertEquals("Wrong LAT", lat, response.getCoord().getLat());
    }


    @When("we getting wind data from server")
    public void get_wind() {
        response = weatherRequester.getWeather();
    }

    @Then("speed is (.*)")
    public void check_speed(BigDecimal speed) {
        assertEquals("Wrong speed", speed, response.getWind().getSpeed());
    }

    @Then("deg is (.*)")
    public void check_deg(Double deg) {
        assertEquals("Wrong deg", deg, response.getWind().getDeg());
    }


    @When("we getting main data from server")
    public void get_main() {
        response = weatherRequester.getWeather();
    }

    @Then("temp is (.*)")
    public void check_temp(BigDecimal temp) {
        assertEquals("Wrong temp", temp, response.getMain().getTemp());
    }

    @Then("pressure is (.*)")
    public void check_pressure(Double pressure) {
        assertEquals("Wrong pressure", pressure, response.getMain().getPressure());
    }

    @Then("humidity is (.*)")
    public void check_humidity(Double humidity) {
        assertEquals("Wrong humidity", humidity, response.getMain().getHumidity());
    }

    @Then("temp_min is (.*)")
    public void check_temp_min(BigDecimal temp_min) {
        assertEquals("Wrong temp_min", temp_min, response.getMain().getTemp_min());
    }

    @Then("temp_max is (.*)")
    public void check_temp_max(BigDecimal temp_max) {
        assertEquals("Wrong temp_max", temp_max, response.getMain().getTemp_max());
    }

}