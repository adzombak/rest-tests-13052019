import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class WeatherTest {

    String idOfCity;

    @Test
    public void getWeatherPerCityTest() {
        RestAssured.baseURI = "https://pinformer.sinoptik.ua/search.php";

        ValidatableResponse response = RestAssured.given()
                .param("Lang", "ua")
                .param("return_id", "1")
                .param("q", "Lviv")
                //.log().uri()
                .get()
                .then()
                //.log().all()
                .statusCode(200);

        String cityId = response.extract().asString();
        System.out.println(cityId);
        idOfCity = cityId.substring(cityId.lastIndexOf("|") + 1);
        System.out.println(idOfCity);


//    @Test
//    public void getWeatherById () {
        RestAssured.baseURI = "https://pinformer.sinoptik.ua/pinformer4.php";

        ValidatableResponse responseWeather = RestAssured.given()
               .param("type", "js")
                .param("lang", "ua")
                .param("id", idOfCity)
                .post()
                .then()
                .log().all()
                .statusCode(200);
        String WeatherKeyValues = responseWeather.extract().asString();
        System.out.println(WeatherKeyValues);

    }
}
