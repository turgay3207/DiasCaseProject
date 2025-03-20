package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.HepsiBuradaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.*;

public class HepsiBuradaStepDef {

    HepsiBuradaPage hepsiBuradaPage=new HepsiBuradaPage();
    Actions actions=new Actions(Driver.getDriver());
    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String string) throws InterruptedException {
        Driver.getDriver().get(string);
        hepsiBuradaPage.kabulEtButon.click();
      /*  try {
            // Alert'e switch yap ve kapat
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.dismiss(); // Veya alert.accept();
        } catch (Exception e) {
            System.out.println("Alert görünmedi, devam ediliyor.");
        } */
        ReusableMethods.waitFor(5);
    }


    @When("the user goes to Tum Kategoriler -> Elektronik -> Tablet category")
    public void theUserGoesToTumKategorilerElektronikTabletCategory() throws InterruptedException {
        hepsiBuradaPage.elektronikSecenegi.click();
        actions.moveToElement(hepsiBuradaPage.bilgisayarTabletSecenegi).perform();
        hepsiBuradaPage.appleSecenegi.click();
        ReusableMethods.waitFor(5);
    }
    @When("the user filters by brand Apple and screen size inch")
    public void the_user_filters_by_brand_apple_and_screen_size_inch() {
        hepsiBuradaPage.tabletIncBoyutu.click();
    }
    @When("the user selects the most expensive product from the filtered results")
    public void the_user_selects_the_most_expensive_product_from_the_filtered_results() {
            actions.moveToElement(hepsiBuradaPage.urunUzerineGel).click();
            hepsiBuradaPage.urunUzerineGel.click();

    }
    @When("the user clicks the {string} button on the product detail page")
    public void the_user_clicks_the_button_on_the_product_detail_page(String string) {
        ReusableMethods.waitFor(3);
            hepsiBuradaPage.sepeteEkleButonu.click();
            ReusableMethods.waitFor(30);
    }
    @Then("the user verifies that the product is added to the cart")
    public void the_user_verifies_that_the_product_is_added_to_the_cart() {
        assertTrue(hepsiBuradaPage.sepeteEklendiMesaj.isDisplayed());
    }
    @Then("the user verifies that the price in the cart matches the product detail page")
    public void the_user_verifies_that_the_price_in_the_cart_matches_the_product_detail_page() {

    }

}
