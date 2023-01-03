package com.bestbuy.bestbuyinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ProductPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ProductSteps {

    @Step("Creating Product with Id : {0}, Name {1}, Type: {2}, Price: {3}, and UPC: {4}")

    public ValidatableResponse createProduct( String name, String type, float price, String upc, int shipping,
                                             String description, String manufacturer, String model, String url, String image)
    {

        ProductPojo productPojo = new ProductPojo();

        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setUpc(upc);
        productPojo.setShipping(shipping);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);


        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .post(EndPoints.CREATE_PRODUCT)
                .then();
    }
    @Step("Getting the product information with product id")

    public ValidatableResponse getProductInfoById(int productid){
        return SerenityRest.given().log().all()
                .pathParam("productID", productid)
                .when()
                .get(EndPoints.GET_PRODUCT_BY_ID)
                .then()
                .statusCode(200);


    }

    @Step("Update product by Product ID using PATCH")

  public void updateProduct(int productid, String name, String type, float price, String upc, int shipping,
                                           String description, String manufacturer, String model, String url, String image)
    {

        ProductPojo productPojo = new ProductPojo();
         productPojo.setName(name);
          productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setUpc(upc);
        productPojo.setShipping(shipping);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("productID",productid)
                .body(productPojo)
                .when()
                .patch(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then();
    }

    @Step("Delete product by product ID")

    public ValidatableResponse deleteProductbyID(int productid){
        return SerenityRest.given().log().all()
                .pathParam("productID", productid)
                .when()
                .delete(EndPoints.DELETE_PRODUCT)
                .then()
                .statusCode(200);

    }

}
