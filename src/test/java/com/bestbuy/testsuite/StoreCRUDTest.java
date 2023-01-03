package com.bestbuy.testsuite;

import com.bestbuy.bestbuyinfo.StoreSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StoreCRUDTest extends TestBase {
    static String name = "VDname" + TestUtils.getRandomValue();
    static String type = "VDtype" + TestUtils.getRandomValue();
    static String address = "London";
    static String address2 = "Har";
    static String city = "London1";
    static String state = "Middlesex";
    static String zip = "123" + TestUtils.getRandomValue();
    static int lat = 123;
    static int lng = 345;
    static String hours = "123";

    static int newstoreid;

    @Steps
    StoreSteps storeSteps;



    @Title("Get All Stores Information")

    @Test
    public void test01_getStoreInfo() {
        ValidatableResponse AllStoreInfo = storeSteps.getAllStores().log().all();

    }

    @Title("Create New Store")
    @Test
    public void test02_createStore(){
        ValidatableResponse response = storeSteps.createStore(name,type,address,address2,city,state,zip,lat,lng,hours);
        response.log().all().statusCode(201);
        newstoreid = response.extract().path("id");
        System.out.println("NEWLY CREATED STORE ID IS:" +newstoreid);
    }

    @Title("Retrieve newly added Store to the application")
    @Test
    public void test03_verifyNewStore(){
       ValidatableResponse response = storeSteps.getStoreInfoById(newstoreid);
        response.log().all().statusCode(200);
    }

    @Title("Update Store Detail")
    @Test
    public void test04_updateNewStore(){
        name = "VD" + TestUtils.getRandomString();
        type = "VDtype" + TestUtils.getRandomValue();
        ValidatableResponse response = storeSteps.updateStore(newstoreid,name,type,address,address2,city,state,zip,lat,lng,hours);
        response.log().all().statusCode(200);
    }

    @Title("Delete Newly Create Store")
    @Test
    public void test05_deleteStore(){
        ValidatableResponse response = storeSteps.deleteStorebyID(newstoreid);
        response.log().all().statusCode(200);
    }


}


