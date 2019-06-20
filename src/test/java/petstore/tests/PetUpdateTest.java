/*
package petstore.tests;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.*;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndPoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import static org.hamcrest.core.Is.is;

@RunWith(SerenityRunner.class)
@Concurrent
@Ignore
public class PetUpdateTest {
    @Steps
    private PetEndPoint petEndpoint = new PetEndPoint();
    private PetModel petModel;

    @Before
    public void preCondition() {
        petModel = new PetModel(
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


    @After
    public void posCondition() {
        petEndpoint
                .deletePetTest(petModel.getId())
                .statusCode(200);
        petEndpoint.getPetByIdTest(petModel.getId())
                .statusCode(404)
                .body("any{it.value == 'Pet not found'}", is(true));
    }

    @Test
    public void updatePetTest(){
        petModel.setName("Jack");
        petModel.setStatus("PENDING");

        petEndpoint.updatePetTest(petModel)
                .statusCode(200)
                .body("size()",is(6))
                .body("any{it.value == 'PENDING'}", is(true))
                .body("any{it.value == 'Jack'}", is(true));

        petEndpoint
                .getPetByIdTest(petModel.getId())
                .statusCode(200)
                .body("size()",is(6));
    }
}
*/
