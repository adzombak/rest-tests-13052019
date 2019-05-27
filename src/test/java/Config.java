class Config {
    final static String BASE_URI = "https://petstore.swagger.io/v2";

    final static String GET_PET_BY_ID = "pet/{petID}";
    final static String DELETE_PET_BY_ID = "pet/{petID}";
    final static String GET_PET_BY_STATUS = "pet/findByStatus";

    protected enum Statuses{
        AVAILABLE,
        PENDING,
        SOLD
    }

    static String petID = "12032705";

    static int successfullStatusCode = 200;

}