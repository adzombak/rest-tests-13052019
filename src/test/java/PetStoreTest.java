import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class PetStoreTest {



    private enum status{
        AVAILABLE,
        PENDING,
        SOLD
    }


        //static RestAssured.baseURI = Config.BASE_URI;

    static  {
        RestAssured.baseURI = Config.BASE_URI;
    }

    @Test
    public void getPetbyIdTest() {

        long petId = 2019052412031988L;

        RestAssured.given()
                //.param("""PetStoreTest.petId")
                //.basePath("")
                //.log().uri()
                .get(Config.GET_PET_BY_ID)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getPetbyStatus() {

        RestAssured.given()
                .param("status", status.AVAILABLE)
                //.param()
                //.basePath()
                //.log().uri()
                .get(Config.GET_PET_BY_STATUS)
                .then()
                .log().all()
                .statusCode(200);

        Response response = RestAssured.given().get(Config.GET_PET_BY_STATUS).thenReturn();
        ResponseBody body = response.getBody();
        System.out.println(body);
        System.out.println(body.prettyPrint());
        //System.out.println(response.prettyPrint());

        //JSONObject data = new JSONObject(response);
        //System.out.println(data);

        //JSONArray ja = new JSONArray(response.print());
        //System.out.println(ja);

    }
}