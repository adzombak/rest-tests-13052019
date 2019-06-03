package petstore.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import petstore.endpoints.StoreEndPoint;
import petstore.models.OrderModel;

import static org.hamcrest.core.Is.is;

public class PetOrderTest {
    private StoreEndPoint storeEndPoint = new StoreEndPoint();
    private OrderModel orderModel;


    @Before
    public void preCondition(){
        orderModel = new OrderModel(
                13,
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
                .body("id", is(orderModel.getId()));

    }

    @After
    public void posCondition() {
        storeEndPoint
                .deleteOrderTest(orderModel.getId())
                .statusCode(200);
    }


    @Test
    public void getOrderByIdTest(){
        storeEndPoint.getOrderByIdTest(orderModel.getId())
                .statusCode(200)
                .body("size()",is(6))
                .body("status", is("placed"));
    }
}




//    @Test
//    public void getOrderByPetIdTest(){
//        int petId = orderModel.getPetId();
////        storeEndPoint.getOrderByIdTest(orderModel.getId())
////                .statusCode(200)
////                .body("size()",is(6))
////                .body("status", is("placed"));
//        storeEndPoint.getOrderByPetIdTest(petId)
//                .statusCode(200);
//    }

//    @After
//    public void posCondition() {
//        storeEndPoint
//                .deleteOrderTest(orderModel.getId())
//                .statusCode(200);
////        storeEndPoint.getOrderByIdTest(orderModel.getId())
////                .statusCode(404)
////                .body("any{it.value == 'Pet not found'}", is(true));
//    }