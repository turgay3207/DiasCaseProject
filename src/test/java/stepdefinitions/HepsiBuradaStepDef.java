package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.HepsiBuradaPage;
import utilities.Driver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.*;

public class HepsiBuradaStepDef {

    HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();
    Actions actions = new Actions(Driver.getDriver());
    String ilkSayfa;
    String ikinciSayfa;
    double maxPrice;
    String expectedPrice;

    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String string) {
        Driver.getDriver().get(string);
        waitAndClick(hepsiBuradaPage.kabulEtButon);

    }


    @When("the user goes to Tum Kategoriler -> Elektronik -> Tablet category")
    public void theUserGoesToTumKategorilerElektronikTabletCategory() {

        actions.moveToElement(hepsiBuradaPage.elektronikSecenegi).perform();

        actions.moveToElement(hepsiBuradaPage.bilgisayarTabletSecenegi).perform();

        waitAndClick(hepsiBuradaPage.appleSecenegi);


    }

    @When("the user filters by brand Apple and screen size inch")
    public void the_user_filters_by_brand_apple_and_screen_size_inch() {
        waitAndClick(hepsiBuradaPage.tabletIncBoyutu);
    }

    @When("the user selects the most expensive product from the filtered results")
    public void the_user_selects_the_most_expensive_product_from_the_filtered_results() {
        ilkSayfa = Driver.getDriver().getWindowHandle();

        List<WebElement> we = null;

        try {
            we = hepsiBuradaPage.currentPrice;

            if (we == null || we.isEmpty()) {
                we = hepsiBuradaPage.currentPrice2;

            }
        } catch (Exception e) {
            we = hepsiBuradaPage.currentPrice2;
        }


        List<Double> prices = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            String priceText = we.get(i).getText().replace(" TL", "").replace(".", "").replace(",", ".");
            double price = Double.valueOf(priceText);
            prices.add(price);
        }


        maxPrice = Collections.max(prices);
        int maxPricesInd = prices.indexOf(maxPrice);
        waitAndClick(we.get(maxPricesInd));
        expectedPrice = we.get(maxPricesInd).getText();

    }

    @When("the user clicks the {string} button on the product detail page")
    public void the_user_clicks_the_button_on_the_product_detail_page(String string) {
        Set<String> handeles = Driver.getDriver().getWindowHandles();
        for (String handle : handeles) {
            if (!handle.equals(ilkSayfa)) {
                ikinciSayfa = handle;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfa);
        waitAndClick(hepsiBuradaPage.sepeteEkleButonu);


    }

    @Then("the user verifies that the product is added to the cart")
    public void the_user_verifies_that_the_product_is_added_to_the_cart() {
        try {
            waitAndClick(hepsiBuradaPage.sepeteGit);
        } catch (Exception e) {
            waitAndClick(hepsiBuradaPage.sepet);
        }

    }

    @Then("the user verifies that the price in the cart matches the product detail page")
    public void the_user_verifies_that_the_price_in_the_cart_matches_the_product_detail_page() {

        assertEquals(expectedPrice.replace(" TL", ""), hepsiBuradaPage.sepetFiyati.getText());
    }

}
