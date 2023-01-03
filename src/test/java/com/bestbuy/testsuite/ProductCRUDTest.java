package com.bestbuy.testsuite;

import com.bestbuy.bestbuyinfo.ProductSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProductCRUDTest extends TestBase {
        static String name= "VIR" + TestUtils.getRandomString();
        static String type="Chargable" + TestUtils.getRandomValue();
        static  float price=60.3F;
        static String shipping="8";
        static int upc=  045;
        static String description="Compatible with select electronic devices";
        static String manufacture="Duracell";
        static String model ="MN2400B4Z";
        static String url="http://www.bestbuy.com";
        static String image="http://img.bbystatic.com";
        static int productId;
        static int putid;
        static int deleteid;
        static int newproductid;
    @Steps
    ProductSteps productSteps;

    @Title("This will create new product")
    @Test
    public void test01_createProduct(){
        ValidatableResponse response=productSteps.createProduct(name,type,price,shipping,upc,description,manufacture,model,url,image);
        response.log().all().statusCode(201);
        newproductid = response.extract().path("id");
        System.out.println("NEWLY CREATED STORE ID IS:" +newproductid);

    }
    @Title("Get Product detail by ID")
    @Test
    public void test02_getProductInfo() {
        ValidatableResponse productMap = productSteps.getProductInfoById(newproductid);
        productMap.log().all();
    }

    @Title("Update Product name by ID")
    @Test
    public void test03_updateProduct() {
        name= "VIRAA" + TestUtils.getRandomValue();
        type="Chargableeee" + TestUtils.getRandomValue();
        productSteps.updateProduct(newproductid,name,type,price,shipping,upc,description,manufacture,model,url,image);

    }

    @Title("Delete Product name by ID")
    @Test
    public void test04_deleteProduct() {
        productSteps.deleteProductbyID(newproductid);

    }
}