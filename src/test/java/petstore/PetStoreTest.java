package petstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
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

    //RequestSpecification requestSpec = new RequestBuilder();


    @Test
    public void getPetByIdTest() {

            RestAssured.given()
                    .pathParam("petID", "12033005")
                    .get(Config.GET_PET_BY_ID)
                    .then()
                    .log().all()
                    .statusCode(200);




        }


    @Test
    public void deletePetbyId () {

        RestAssured.given()
                .pathParam("petID", "12033005")
                .delete(Config.DELETE_PET_BY_ID)
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
                .contentType("application/json")
                .body(petModel)
                .post(Config.CREATE_PET)
                .then()
                .log().all()
                .statusCode(200);
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



//
//@Test
//    public void getPetMessageBody()
//    {
//        //RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
////        RequestSpecification getPetByIdResponse = RestAssured.given().pathParam("petID", Config.petID);
////        Response response = getPetByIdResponse.get(Config.GET_PET_BY_ID);
//
//        Object response = RestAssured.given().pathParam("petID", Config.petID).get(Config.GET_PET_BY_ID).then().extract().body().jsonPath().get("name");
//
//        System.out.println(response);
//        //ValidatableResponse response = getPetByIdResponse.get(Config.GET_PET_BY_ID).then().log().all();
//
//
//
//        // Retrieve the body of the Response
//
//
////        JsonPath petNamePath = response.jsonPath();
////
////        String petName = petNamePath.get("name");
////
////        System.out.println(petName);
//
//        //return petName;
//
//        //Assert.assertEquals("NewTobby", petName);
//
//        // To check for sub string presence get the Response body as a String.
//        // Do a String.contains
//        //String bodyAsString = body.asString();
//        //Assert.assertEquals(bodyAsString.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
//    }
//




