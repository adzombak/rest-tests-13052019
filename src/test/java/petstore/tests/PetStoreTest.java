package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndPoint;
import petstore.endpoints.StoreEndPoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;
import java.lang.String;

import static org.hamcrest.core.Is.is;

@RunWith(SerenityRunner.class)
public class PetStoreTest {
@Steps
    private PetEndPoint petEndpoint = new PetEndPoint();
    private StoreEndPoint storeEndPoint = new StoreEndPoint();
    private PetModel petModel;

    @Test
    public void getPetByIdTest() {
        int petId = 12033005;
        petEndpoint
                .getPetByIdTest(petId);

    }

    @Test
    public void getPetByStatusTest() {
        for (PetEndPoint.Status status : PetEndPoint.Status.values()) {
            petEndpoint
                    .getPetByStatusTest(status);
        }
    }

    @Test
    public void createPetTest() {
        PetModel petModel = new PetModel(
                12033005,
                new CategoryModel(),
                "Tobby",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        petEndpoint
                .createPetTest(petModel)
                .statusCode(200)
                .body("size()",is(6))
                .body("any{it.value == 12033005}", is(true));
    }

    @Test
    public void deletePetTest() {
        petEndpoint
                .deletePetTest(12033005);
    }

/*    @Test
    public void updatePetTest(){
        petModel.setName("Jack");
        petModel.setStatus("PENDING");

        petEndpoint.updatePetTest(petModel)
                .statusCode(200);
//                .body("size()",is(6))
//                .body("any{it.value == 'PENDING'}", is(true))
//                .body("any{it.value == 'Jack'}", is(true));

        petEndpoint
                .getPetByIdTest(petModel.getId())
                .statusCode(200)
                .body("size()",is(6));
    }*/

    /*@Test
    public void getOrderByIdTest(){
int Id = 13;
        storeEndPoint.getOrderByIdTest(Id)
                .statusCode(200)
                .body("size()",is(6));
        //.body("any{it.value == 'PENDING'}", is(true))
        //.body("any{it.value == 'Jack'}", is(true));
    }*/
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




