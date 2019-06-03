package petstore.endpoints;

class Config {
    final static String BASE_URI = "https://petstore.swagger.io/v2";

    static int petID = 12032705;
    static int petIdForUpdate = 12033005;



    final static String GET_PET_BY_ID = "pet/{petID}";
    final static String CREATE_PET = "pet";
    final static String UPDATE_PET = "pet";
    final static String DELETE_PET_BY_ID = "pet/{petID}";
    final static String GET_PET_BY_STATUS = "pet/findByStatus";
    final static String GET_INVENTORY_BY_STATUS = "/store/inventory";
    final static String CREATE_ORDER = "/store/order";
    final static String DELETE_ORDER = "/store/order/{orderId}";
    final static String FIND_ORDER_BY_ID = "/store/order/{orderId}";
}