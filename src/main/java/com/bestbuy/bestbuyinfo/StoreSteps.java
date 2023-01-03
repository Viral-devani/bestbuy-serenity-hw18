package com.bestbuy.bestbuyinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StoreSteps {

    @Step("Getting all stores information")

    public ValidatableResponse getAllStores() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STORE)
                .then()
                .statusCode(200);
    }

    @Step("Creating New Store")

    public ValidatableResponse createStore(String name, String type, String address, String address2, String city, String state,
                                            String zip, int lat, int lng, String hours)
    {
        StorePojo storePojo= new StorePojo();
        storePojo=StorePojo.getStorePojo(name,type,address,address2,city,state,zip,lat,lng,hours);


//        StorePojo storePojo = new StorePojo();
//
//        storePojo.setName(name);
//        storePojo.setType(type);
//        storePojo.setAddress(address);
//        storePojo.setAddress2(address2);
//        storePojo.setCity(city);
//        storePojo.setState(state);
//        storePojo.setZip(zip);
//        storePojo.setLat(lat);
//        storePojo.setLng(lng);
//        storePojo.setHours(hours);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post(EndPoints.CREATE_STORE)
                .then();
    }

    @Step("Getting the store information with id")

    public ValidatableResponse getStoreInfoById(int storeid){
        return SerenityRest.given().log().all()
                .pathParam("storeID",storeid)
                .when()
                .get(EndPoints.GET_STORE_BY_ID)
                .then();

    }


    @Step("Updating Store")

    public ValidatableResponse updateStore(int storeid, String name, String type, String address, String address2, String city, String state,
                                           String zip, int lat, int lng, String hours)
    {
        StorePojo storePojo= new StorePojo();
        storePojo=StorePojo.getStorePojo(name,type,address,address2,city,state,zip,lat,lng,hours);


//        StorePojo storePojo = new StorePojo();
//
//        storePojo.setName(name);
//        storePojo.setType(type);
//        storePojo.setAddress(address);
//        storePojo.setAddress2(address2);
//        storePojo.setCity(city);
//        storePojo.setState(state);
//        storePojo.setZip(zip);
//        storePojo.setLat(lat);
//        storePojo.setLng(lng);
//        storePojo.setHours(hours);

        return SerenityRest.given().log().all()
                .pathParam("storeID",storeid)
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .patch(EndPoints.UPDATE_STORE_BY_ID)
                .then();
    }

    @Step("Delete store by store ID")

    public ValidatableResponse deleteStorebyID(int storeid){
        return SerenityRest.given().log().all()
                .pathParam("storeID", storeid)
                .when()
                .delete(EndPoints.DELETE_STORE)
                .then()
                .statusCode(200);

    }



}

