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

    static  {
        RestAssured.baseURI = Config.BASE_URI;
    }

    @Test
    public void getPetbyIdTest() {

            RestAssured.given()
                    .pathParam("petID", Config.petID)
                    .get(Config.GET_PET_BY_ID)
                    .then()
                    .log().all()
                    .statusCode(Config.successfullStatusCode);
        }

    @Test
    public void deletePetbyId () {

           RestAssured.given()
                   .pathParam("petID", Config.petID)
                   .delete(Config.DELETE_PET_BY_ID)
                   .then()
                   .log().all();
                   //.header()
        //System.out.println(response.statusCode());


        }



    @Test
    public void getPetbyStatus() {

        for (Config.Statuses status : Config.Statuses.values()) {

            RestAssured.given()
                    .param("status", status)
                    .log().uri()
                    .get(Config.GET_PET_BY_STATUS)
                    .then()
                    .log().all()
                    .statusCode(Config.successfullStatusCode);
        }
    }
    }



//    Response response = RestAssured.given().get(Config.GET_PET_BY_STATUS).thenReturn();
//    ResponseBody body = response.getBody();
//        System.out.println(body);
//                System.out.println(body.prettyPrint());
//System.out.println(response.prettyPrint());
//
//JSONObject data = new JSONObject(response);
//System.out.println(data);
//
//JSONArray ja = new JSONArray(response.print());
//System.out.println(ja);