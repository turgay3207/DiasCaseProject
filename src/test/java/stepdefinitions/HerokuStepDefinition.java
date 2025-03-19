package stepdefinitions;

import baseUrl.HerokuBaseApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static baseUrl.HerokuBaseApi.spec;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.createToken;

public class HerokuStepDefinition  {

    Response response;

    @Given("User sends a POST request for authentication")
    public void user_sends_a_post_request_for_authentication() {

        response = createToken(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        response.prettyPrint();
    }

    @Then("User verifs that  status code is {int}")
    public void user_verifs_that_status_code_is(Integer statusCode) {
        response.then().statusCode(statusCode);


    }

    @Then("User verifs that token value is not empty")
    public void user_verifs_that_token_value_is_not_empty() {
        assertFalse(response.jsonPath().get("token").toString().isEmpty());


    }


    @Given("User sends a GET request for booking")
    public void user_sends_a_get_request_for_booking() {

        spec.pathParam("p1",
                "booking");
        response = given(spec).
                when().
                get("/{p1}");


    }

    @Then("User verifs that booking value contains {string}")
    public void user_verifs_that_booking_value_contains(String  bookingId) {
     assertTrue(response.jsonPath().get("bookingid").toString().contains(bookingId));

    }


}
