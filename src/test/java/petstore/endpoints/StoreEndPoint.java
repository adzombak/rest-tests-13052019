package petstore.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import petstore.models.OrderModel;

public class StoreEndPoint {
    private RequestSpecification given(){
        return SerenityRest.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json")
                .log().uri();
    }
    @Step
    public ValidatableResponse getInventoryByPetStatus(PetEndPoint.Status status) {
        return given()
                .param("status", status)
                .get(Config.GET_INVENTORY_BY_STATUS)
                .then()
                .log().all();
    }
    @Step
    public ValidatableResponse getOrderByIdTest (int Id) {
        return given()
                .get(Config.FIND_ORDER_BY_ID, Id)
                .then()
                .log().all();
    }
    @Step
    public ValidatableResponse createOrderTest(OrderModel orderModel) {
        return given().body(orderModel)
                .post(Config.CREATE_ORDER)
                .then()
                .log().all();
    }
    @Step
    public ValidatableResponse deleteOrderTest(int Id) {
        return given()
                .delete(Config.DELETE_ORDER, Id)
                .then()
                .log().all();
    }
}
