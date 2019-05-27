package petstore;

class Config {
    final static String BASE_URI = "https://petstore.swagger.io/v2";

    static String petID = "12032705";

//    String getPetID = "12032705";
//    String deletePetID = "12032705";

    final static String GET_PET_BY_ID = "pet/{petID}";
    final static String CREATE_PET = "pet";
    final static String DELETE_PET_BY_ID = "pet/{petID}";
    final static String GET_PET_BY_STATUS = "pet/findByStatus";

    protected enum Statuses{
        AVAILABLE,
        PENDING,
        SOLD
    }

}