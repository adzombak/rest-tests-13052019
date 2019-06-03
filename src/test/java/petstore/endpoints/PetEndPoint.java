package petstore.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import petstore.models.PetModel;



public class PetEndPoint {
    //Logger logger = Logger.getLogger(this.getClass().getName());
    Logger logger = LoggerFactory.getLogger(PetEndPoint.class);

    private RequestSpecification given() {
SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
        return SerenityRest.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json");
                //.log().uri();
    }

    @Step
    public ValidatableResponse getPetByIdTest (int petId) {
        return given()
                .get(Config.GET_PET_BY_ID, petId)
                .then();
                //.log().all();
        }


    public enum Status {
        AVAILABLE,
        PENDING,
        SOLD
    }
    @Step
    public ValidatableResponse getPetByStatusTest(Status status) {
        return given()
                .param("status", status)
                .get(Config.GET_PET_BY_STATUS)
                .then();
        //.log().all();
    }

    @Step
    public ValidatableResponse createPetTest(PetModel petModel) {
        logger.info("Executing 'createPetTest'");
        return given().body(petModel)
                .post(Config.CREATE_PET)
                .then()
                .log().all();
    }

    @Step
    public ValidatableResponse deletePetTest(int petId) {
        return given().delete(Config.DELETE_PET_BY_ID, petId)
                .then();
        //.log().all();
    }


    @Step
    public ValidatableResponse updatePetTest(PetModel petModel) {
        return given().body(petModel)
               .put(Config.UPDATE_PET)
                .then();
        //.log().all();
    }
}
