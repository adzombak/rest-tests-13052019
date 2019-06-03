package petstore.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import petstore.endpoints.PetEndPoint;
import petstore.endpoints.StoreEndPoint;
import petstore.models.OrderModel;

import static org.hamcrest.core.Is.is;

public class PetOrderTest {
    private StoreEndPoint storeEndPoint = new StoreEndPoint();
    private PetEndPoint petEndpoint = new PetEndPoint();
    private OrderModel orderModel;


    @Before
    public void createOrderTest(){
        orderModel = new OrderModel(
                12033005,
                12033005,
                2,
                "2019-06-03T04:56:15.934+0000",
                "placed",
                false
        );

        storeEndPoint
                .createOrderTest(orderModel)
                .statusCode(200)
                .body("size()",is(6))
                .body("any{it.value == 12033005}", is(true));

    }

    @After
    public void posCondition() {
        storeEndPoint
                .deleteOrderTest(orderModel.getId())
                .statusCode(200);
//        storeEndPoint.getOrderByIdTest(orderModel.getId())
//                .statusCode(404)
//                .body("any{it.value == 'Pet not found'}", is(true));
    }


    @Test
    public void getOrderByPetIdTest(){

        storeEndPoint.getOrderByIdTest(orderModel.getId())
                .statusCode(200)
                .body("size()",is(6))
                .body("any{it.value == 'placed'}", is(true));
        storeEndPoint.getOrderByPetIdTest(orderModel.getPetId())
                .statusCode(200);
    }
}
