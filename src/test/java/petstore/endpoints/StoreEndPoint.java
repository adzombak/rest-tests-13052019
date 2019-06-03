package petstore.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import petstore.models.OrderModel;
import petstore.models.PetModel;

public class StoreEndPoint {
    private RequestSpecification given(){
        return RestAssured.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json")
                .log().uri();
    }

    public ValidatableResponse getInventoryByPetStatus(PetEndPoint.Status status) {
        return given()
                .param("status", status)
                .get(Config.GET_INVENTORY_BY_STATUS)
                .then()
                .log().all();
    }

    public ValidatableResponse getOrderByIdTest (int Id) {
        return given()
                .get(Config.FIND_ORDER_BY_ID, Id)
                .then()
                .log().all();
    }

    public ValidatableResponse getOrderByPetIdTest (int petId) {
        return given()
                .get(Config.FIND_ORDER_BY_ID, petId)
                .then()
                .log().all();
    }

    public ValidatableResponse createOrderTest(OrderModel orderModel) {
        return given().body(orderModel)
                .post(Config.CREATE_ORDER)
                .then()
                .log().all();
    }

    public ValidatableResponse deleteOrderTest(int Id) {
        return given()
                .delete(Config.DELETE_ORDER, Id)
                .then()
                .log().all();
    }
}
