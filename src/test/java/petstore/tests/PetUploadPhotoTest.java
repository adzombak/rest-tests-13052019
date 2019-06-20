package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndPoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import java.io.File;

import static org.hamcrest.core.Is.is;

@RunWith(SerenityRunner.class)
public class PetUploadPhotoTest {
    @Steps
    private PetEndPoint petEndPoint;
    private PetModel petModel;
    private File file;

    @Before
    public void preCondition() {

        petModel = new PetModel(
                12032006,
                new CategoryModel(),
                "Tobby",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        petEndPoint
                .createPetTest(petModel)
                .statusCode(200)
                .body("size()", is(6))
                .body("any{it.value ==" + petModel.getId() + "}", is(true));
    }

    /*@After
    public void postCondition() {

        petEndPoint
                .deletePetTest(petModel.getId())
                .statusCode(200);
    }*/

    @Test
    public void uploadPetPhotoTest() {

        file = new File("/Users/Andrew/IdeaProjects/rest-tests-13052019/src/test/java/petstore/tests/testdata/photo.png");

        petEndPoint.uploadPetPhotoTest(petModel.getId(), file)
                .statusCode(200);

    }
}