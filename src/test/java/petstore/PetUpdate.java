package petstore;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import javax.xml.ws.Response;


public class PetUpdate {

    static {
        RestAssured.baseURI = Config.BASE_URI;
    }


    @BeforeClass
    public static void createPetTest() {

        PetModel petForCreation = new PetModel(
                12033005,
                new CategoryModel(),
                "Jack",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        RestAssured.given()

                .contentType("application/json")
                .body(petForCreation)
                .post(Config.CREATE_PET)
                .then()
                .statusCode(200);

        String response = RestAssured.given().pathParam("petID", Config.petIdForUpdate).get(Config.GET_PET_BY_ID).body().asString();
        System.out.println("Created pet is:" + "\n" + response);

    }

    @Test
    public void updatePetTest() {

        PetModel petForUpdate = new PetModel(
                12033005,
                new CategoryModel(),
                "Tobby",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "PENDING");

        RestAssured.given()
                .contentType("application/json")
                .body(petForUpdate)
                .put(Config.UPDATE_PET)
                .then()
                .statusCode(200);


        //String response = RestAssured.given().pathParam("petID", Config.petIdForUpdate).get(Config.GET_PET_BY_ID).body().asString();
        String response = RestAssured.given().pathParam("petID", Config.petIdForUpdate).get(Config.GET_PET_BY_ID).then().extract().body().asString();
        System.out.println("Updated pet is:" + "\n" + response);

    }

    @AfterClass
    public static void petRemove() {

        RestAssured.given()
                .pathParam("petID", Config.petIdForUpdate)
                .delete(Config.DELETE_PET_BY_ID)
                .then()
                .assertThat()
                .statusCode(200);

        String response = RestAssured.given().pathParam("petID", Config.petIdForUpdate).get(Config.GET_PET_BY_ID).jsonPath().get("message");
        System.out.println("Message after removal:" + "\n" + response);

    }
}