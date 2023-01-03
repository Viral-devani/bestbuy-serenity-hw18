package com.bestbuy.constants;

public class EndPoints {
    /**
     * Products End Points
     */


    public static final String GET_PRODUCT_BY_ID = "/products/{productID}";
    public static final String UPDATE_PRODUCT_BY_ID = "/products/{productID}";
    public static final String DELETE_PRODUCT = "/products/{productID}";
    public static final String CREATE_PRODUCT = "/products";


    /*
    Store End Points
     */
    public static final String GET_ALL_STORE = "/stores";
    public static final String CREATE_STORE = "/stores";
    public static final String GET_STORE_BY_ID = "/stores/{storeID}";
    public static final String UPDATE_STORE_BY_ID = "/stores/{storeID}";
    public static final String DELETE_STORE = "/stores/{storeID}";

}
