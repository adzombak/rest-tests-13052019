package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndPoint;
import petstore.endpoints.StoreEndPoint;
import petstore.models.PetModel;

@RunWith(SerenityRunner.class)
public class PetStoreTest {
    @Steps
    private PetEndPoint petEndpoint;// = new PetEndPoint();
    private StoreEndPoint storeEndPoint = new StoreEndPoint();
    private PetModel petModel;

    @Test
    public void getPetByIdTest() {
        int petId = 12033005;
        petEndpoint
                .getPetByIdTest(petId)
                .statusCode(200);

    }

    @Test
    public void getPetByStatusTest() {
        for (PetEndPoint.Status status : PetEndPoint.Status.values()) {
            petEndpoint
                    .getPetByStatusTest(status)
                    .statusCode(200);
        }
    }

/*    @Test
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
                .body("size()", is(6))
                .body("any{it.value == 12033005}", is(true));
    }

    @Test
    public void deletePetTest() {
        petEndpoint
                .deletePetTest(12033005);
    }*/
}




