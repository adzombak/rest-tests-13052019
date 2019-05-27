package petstore;

import io.restassured.RestAssured;
import org.junit.Test;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;
import java.lang.String;



public class PetStoreTest {

    static  {
        RestAssured.baseURI = Config.BASE_URI;
    }

    private enum status{
        AVAILABLE,
        PENDING,
        SOLD
    }

    @Test
    public void getPetbyIdTest() {

            RestAssured.given()
                    .pathParam("petID", Config.petID)
                    .get(Config.GET_PET_BY_ID)
                    .then()
                    .log().all()
                    .statusCode(200);
        }

    @Test
    public void createPetTest() {
        PetModel petModel = new PetModel(
                12032705,
                new CategoryModel(),
                "Tobby",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        RestAssured.given()
                .log().uri()
                //.header("Content-Type", "application/json")
                .contentType("application/xml")
                .body(petModel)
                .post(Config.CREATE_PET)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void deletePetbyId () {

            RestAssured.given()
                   .pathParam("petID", Config.petID)
                   .delete(Config.DELETE_PET_BY_ID)
                   .then()
                   .log().all();
                   //.log().status();
                   //.header()
                   //System.out.println(response.statusCode());


        }

    @Test
    public void getPetbyStatus() {

        for (status petStatus : status.values()) {

            RestAssured.given()
                    .param("status", petStatus)
                    .log().uri()
                    .get(Config.GET_PET_BY_STATUS)
                    .then()
                    .log().all()
                    .statusCode(200);
        }
    }
}



//    Response response = RestAssured.given().get(petstore.Config.GET_PET_BY_STATUS).thenReturn();
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