package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import pojo.Booking;
import pojo.Bookingdates;
import pojo.Root;
import utilities.ConfigReader;


import static io.restassured.RestAssured.given;
import static baseUrl.HerokuBaseApi.spec;
import static org.junit.Assert.*;
import static utilities.ReusableMethods.createToken;

public class HerokuStepDefinition {

    Response response;
    Root actualData;
    Booking expectedData;
  static   String id;

    @Given("User sends a POST request for authentication")
    public void user_sends_a_post_request_for_authentication() {
        response = createToken(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
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
    public void user_verifs_that_booking_value_contains(String bookingId) {
        assertTrue(response.jsonPath().get("bookingid").toString().contains(bookingId));
    }


    @Given("User sends a GET request for booking with id {string}")
    public void user_sends_a_get_request_for_booking_with_id(String string) {
        spec.pathParams("p1",
                "booking"
                , "p2", id);
        response = given(spec).
                when().
                get("/{p1}/{p2}");
    }

    @Then("User verifs that  firstname is {string}")
    public void user_verifs_that_firstname_is(String name) {
        assertEquals(name, response.jsonPath().get("firstname"));
    }

    @Then("User verifs that  lastname is {string}")
    public void user_verifs_that_lastname_is(String lastname) {
        assertEquals(lastname, response.jsonPath().getString("lastname"));
    }

    @Then("User verifs that  total price is {string}")
    public void user_verifs_that_total_price_is(String totalprice) {
        assertEquals(totalprice, response.jsonPath().getString("totalprice"));
    }

    @Then("User verifs that  deposit paid {string}")
    public void user_verifs_that_deposit_paid(String depositpaid) {
        switch (depositpaid) {
            case "true":
                assertTrue(response.jsonPath().getBoolean("depositpaid"));
                break;
            case "false":
                assertFalse(response.jsonPath().getBoolean("depositpaid"));
                break;

        }

    }

    @Then("User verifs that  checkin  is {string}")
    public void user_verifs_that_checkin_is(String checkin) {
        assertEquals(checkin, response.jsonPath().getString("bookingdates.checkin"));
    }

    @Then("User verifs that  checkout  is {string}")
    public void user_verifs_that_checkout_is(String checkout) {
        assertEquals(checkout, response.jsonPath().getString("bookingdates.checkout"));
    }

    @Given("User sends a POST request for create booking")
    public void user_sends_a_post_request_for_create_booking() {
        Bookingdates bookingdates = new Bookingdates("2025-06-06", "2025-07-07");
        expectedData = new Booking("Turgay",
                "Uludag",
                1500,
                true,
                bookingdates,
                "Breakfast");
        spec.pathParams("p1",
                "booking");
        response = given(spec).
                when().
                body(expectedData).
                post("/{p1}");
        actualData = response.as(Root.class);
        id=response.jsonPath().getString("bookingid");
    }


    @Then("User verifs that  firstname is {string} for creation booking")
    public void user_verifs_that_firstname_is_for_creation_booking(String value) {
        assertEquals(expectedData.firstname, actualData.booking.firstname);
    }

    @Then("User verifs that  lastname is {string} for creation booking")
    public void user_verifs_that_lastname_is_for_creation_booking(String string) {
        assertEquals(expectedData.lastname, actualData.booking.lastname);

    }

    @Then("User verifs that  total price is {string} for creation booking")
    public void user_verifs_that_total_price_is_for_creation_booking(String string) {
        assertEquals(expectedData.totalprice, actualData.booking.totalprice);
    }

    @Then("User verifs that  deposit paid {string} for creation booking")
    public void user_verifs_that_deposit_paid_for_creation_booking(String string) {
        assertEquals(expectedData.depositpaid, actualData.booking.depositpaid);
    }

    @Then("User verifs that  checkin  is {string} for creation booking")
    public void user_verifs_that_checkin_is_for_creation_booking(String string) {
        assertEquals(expectedData.bookingdates.checkin, actualData.booking.bookingdates.checkin);
    }

    @Then("User verifs that  checkout  is {string} for creation booking")
    public void user_verifs_that_checkout_is_for_creation_booking(String string) {
        assertEquals(expectedData.bookingdates.checkout, actualData.booking.bookingdates.checkout);
    }

    @Given("User sends a PUT request for update booking")
    public void user_sends_a_put_request_for_update_booking() {

        String token = "token=" + createToken(ConfigReader.getProperty("username"), ConfigReader.getProperty("password")).
                jsonPath().getString("token").trim();

        Bookingdates bookingdates = new Bookingdates("2025-06-06", "2025-07-07");
        expectedData = new Booking("Updated",
                "Updated",
                1500,
                true,
                bookingdates,
                "Updated");

        spec.pathParams("p1",
                        "booking"
                        , "p2", id).
                header("Cookie", token);

        response = given(spec).
                when().
                body(expectedData).
                put("/{p1}/{p2}");

    }

    @Then("User verifs that  firstname is {string} for update booking")
    public void user_verifs_that_firstname_is_for_update_booking(String string) {
        assertEquals(expectedData.getFirstname(), response.jsonPath().getString("firstname"));
    }

}
