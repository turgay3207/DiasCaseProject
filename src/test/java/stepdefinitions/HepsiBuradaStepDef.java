package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HepsiBuradaPage;
import utilities.Driver;

public class HepsiBuradaStepDef {
    HepsiBuradaPage hepsiBuradaPage=new HepsiBuradaPage();

    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String url) {
        Driver.getDriver().get(url);

    }
    @When("the user goes to {string} category")
    public void the_user_goes_to_category(String string) {

    }
    @When("the user filters by brand {string} and screen size {string}")
    public void the_user_filters_by_brand_and_screen_size(String string, String string2) {

    }
    @When("the user selects the most expensive product from the filtered results")
    public void the_user_selects_the_most_expensive_product_from_the_filtered_results() {

    }
    @When("the user clicks the {string} button on the product detail page")
    public void the_user_clicks_the_button_on_the_product_detail_page(String string) {

    }
    @Then("the user verifies that the product is added to the cart")
    public void the_user_verifies_that_the_product_is_added_to_the_cart() {

    }
    @Then("the user verifies that the price in the cart matches the product detail page")
    public void the_user_verifies_that_the_price_in_the_cart_matches_the_product_detail_page() {

    }

}
