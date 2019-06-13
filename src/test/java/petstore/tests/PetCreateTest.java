package petstore.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndPoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/java/petstore/tests/testdata/pets-spec.csv")
public class PetCreateTest {

    private String petName;
    private int petId;
    private int statusCode;
    @Steps
    private PetEndPoint petEndPoint;
    private PetModel petModel;

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetID(int petId) {
        this.petId = petId;
    }

    public void setPetStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Qualifier
    public String qualifier() {
        return petName + "=>" + petId + "=>" + statusCode;
    }

    @After
    public void postCondition() {
        petEndPoint
                .deletePetTest(petId)
                .statusCode(200);
    }

    @Test
    public void createPetTest() {
        petModel = new PetModel(
                this.petId,
                new CategoryModel(),
                this.petName,
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        petEndPoint.createPetTest(petModel)
                .statusCode(this.statusCode);
    }
}
/*



@RunWith(SerenityParameterizedRunner.class)
public class PetCreateTest {
    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"Jack", 12031006, 200},
                {"Johnny" , 12031106, 200},
                {"Rex", 12031206, 200}
        });
    }

    private final String petName;
    private final int petId;
    private final int statusCode;

    public PetCreateTest(String petName, int petId, int statusCode) {
        this.petName = petName;
        this.petId = petId;
        this.statusCode = statusCode;
    }

    @After
    public void postCondition(){
        petEndPoint
                .deletePetTest(petId)
                .statusCode(200);
    }

    @Steps
    private PetEndPoint petEndPoint;
    private PetModel petModel;

    @Test
    public void createPetTest() {
        petModel = new PetModel(
                this.petId,
                new CategoryModel(),
                this.petName,
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        petEndPoint.createPetTest(petModel)
                .statusCode(this.statusCode);
    }
}
*/
