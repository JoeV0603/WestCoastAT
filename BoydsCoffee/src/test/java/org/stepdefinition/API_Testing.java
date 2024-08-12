package org.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import static org.hamcrest.Matchers.*;

public class API_Testing {

	private Response response;
	private String accessToken;
	
	@SuppressWarnings("unused")
	private static final String NODE_ENV = System.getenv("NODE_ENV");

    @Given("I request an OAuth2.0 token")
    public void iRequestAnOAuth2Token() {
    	
    	 String environment = System.getenv("NODE_ENV");
    	    System.out.println("Current environment: " + environment);

    	    if ("test".equals(environment)) {
    	        
    	        String mockResponseBody = "{ \"access_token\": \"mock_access_token\" }";
    	        response = RestAssured.given()
    	            .contentType("application/json")
    	            .when()
    	            .get("/mock-endpoint")
    	            .then()
    	            .statusCode(200)
    	            .body("access_token", equalTo("mock_access_token"))
    	            .extract()
    	            .response();

    	        
    	        System.out.println("Mock Token Response Body: " + mockResponseBody);
    	   
    	    } else {
    	        
    	        response = RestAssured.given()
    	            .baseUri("https://wp.shottqsr.com/wp-json/wl/v1")
    	            .formParam("grant_type", "client_credentials")
    	            .formParam("client_id", "ck_02022a3473d9824ef5f9f5d88dfdf17a9507a9f9")
    	            .formParam("client_secret", "cs_aa2ba6690b052ac84f9f0189a0d3f8c4a1434e13")
    	            .when()
    	            .post("/token");
    	        
    	    }

        String responseBody = response.getBody().asString();
        System.out.println("Token Response Body: " + responseBody);

        accessToken = response.jsonPath().getString("access_token");
        if (accessToken == null || accessToken.isEmpty()) {
            throw new RuntimeException("Failed to obtain access token. Response: " + responseBody);
        }

        System.out.println("Access Token: " + accessToken);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
       
    	if (response == null) {
            throw new RuntimeException("Response object is null. Ensure the request was successful.");
        }
        
    	int actualStatusCode = response.getStatusCode();
        if (actualStatusCode != statusCode) {
            throw new AssertionError("Expected status code " + statusCode + " but was " + actualStatusCode);
        }
    }

    @And("the response should contain a token")
    public void theResponseShouldContainAToken() {
        
    	if (response == null) {
            throw new RuntimeException("Response object is null. Ensure the request was successful.");
        }

        String accessToken = response.jsonPath().getString("access_token");
        if (accessToken == null || accessToken.isEmpty()) {
            throw new AssertionError("Response does not contain an access token");
        }
    }    	

    @Given("I update the shipment details and order status")
    public void iUpdateTheShipmentDetailsAndOrderStatus() {
        		
    	String endpoint = "/update-order";

        @SuppressWarnings("static-access")
		String requestBody = ((RestAssured) ((RestAssured) new JSONObject()
            .put("OrderId", "63hju3vy65942a694d1a3f3hj03"))
            .post("CustomerId", "46"))
            .post("OrderStatus", "Shipped")
            .toString();

        Response response = RestAssured.given()
            .baseUri("https://wp.shottqsr.com/wp-json/wl/v1")
            .header("Authorization", "Bearer " + accessToken)
            .contentType("application/json")
            .body(requestBody)
            .when()
            .post(endpoint);

        if (response == null) {
            throw new RuntimeException("Response object is null. Ensure the request was successful.");
        }

        System.out.println("Update Response Body: " + response.getBody().asString());
        
    }

    @And("the response should confirm the update")
    public void theResponseShouldConfirmTheUpdate() {
        
            if (response == null) {
                throw new RuntimeException("Response object is null. Ensure the request was successful.");
            }

            String responseBody = response.getBody().asString();
            if (!responseBody.contains("success")) {
                throw new AssertionError("Response does not confirm the update: " + responseBody);
            }
        }
    	

    @Given("I add a new product")
    public void iAddANewProduct() {
        response = RestAssured.given()
            
        	.baseUri("https://wp.shottqsr.com/wp-json/wl/v1")
        	.header("Content-Type", "application/json")
            .body("{ \"name\": \"Green Coffee Pack\", \"price\": 119.99, \"categorieId\": \"Cof\" }")
            .when()
            .post("/add_product");
        
        response.then().log().all();
        
    }

    @Then("the response should confirm the product was added")
    public void theResponseShouldConfirmTheProductWasAdded() {
        response.then().body("message", equalTo("Product added"));
    }

    @Given("I update an existing product")
    public void iUpdateAnExistingProduct() {
        response = RestAssured.given()
            .baseUri("https://api.example.com")
            .body("{ \"name\": \"Updated Product\" }")
            .when()
            .put("/product/update");
    }

    @Then("the response should confirm the product was updated")
    public void theResponseShouldConfirmTheProductWasUpdated() {
        response.then().body("message", equalTo("Product updated"));
    }

    @Given("I get all tags from the network")
    public void iGetAllTagsFromTheNetwork() {
        response = RestAssured.given()
            .baseUri("https://api.example.com")
            .when()
            .get("/tags");
    }

    @Then("the response should contain tags")
    public void theResponseShouldContainTags() {
        response.then().body("tags", not(empty()));
    }

    @Given("I get all coupons from the network")
    public void iGetAllCouponsFromTheNetwork() {
        response = RestAssured.given()
            .baseUri("https://api.example.com")
            .when()
            .get("/coupons");
    }

    @Then("the response should contain coupons")
    public void theResponseShouldContainCoupons() {
        response.then().body("coupons", not(empty()));
    }

    @Given("I create a new customer")
    public void iCreateANewCustomer() {
        response = RestAssured.given()
            .baseUri("https://api.example.com")
            .body("{ \"customer\": \"John Doe\" }")
            .when()
            .post("/customer/create");
    }

    @Then("the response should confirm the customer was created")
    public void theResponseShouldConfirmTheCustomerWasCreated() {
        response.then().body("message", equalTo("Customer created"));
    }

    @Given("I update an existing customer")
    public void iUpdateAnExistingCustomer() {
        response = RestAssured.given()
            .baseUri("https://api.example.com")
            .body("{ \"customer\": \"John Smith\" }")
            .when()
            .put("/customer/update");
    }

    @Then("the response should confirm the customer was updated")
    public void theResponseShouldConfirmTheCustomerWasUpdated() {
        response.then().body("message", equalTo("Customer updated"));
    }
	
}
