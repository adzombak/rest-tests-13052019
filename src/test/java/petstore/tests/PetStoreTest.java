package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndPoint;
import petstore.endpoints.StoreEndPoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

@RunWith(SerenityRunner.class)
@Concurrent
public class PetStoreTest {
    @Steps
    private PetEndPoint petEndpoint;// = new PetEndPoint();
    private StoreEndPoint storeEndPoint = new StoreEndPoint();
    private PetModel petModel;

    @Test
    public void getPetByIdTest() {
        int petId = 12031906;
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
    @Ignore
    public void createPetTest() {
        PetModel petModel = new PetModel(
                Integer.,
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
    @Ignore
    public void deletePetTest() {
        petEndpoint
                .deletePetTest(12033005);
    }*/
}



