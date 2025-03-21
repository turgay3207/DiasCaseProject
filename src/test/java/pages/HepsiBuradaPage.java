package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HepsiBuradaPage {
    public HepsiBuradaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    public WebElement kabulEtButon;
    @FindBy(xpath = "//span[contains(text(),'Elektronik')]")
    public WebElement elektronikSecenegi;
    @FindBy(xpath = "//a[normalize-space()='Bilgisayar/Tablet']")
    public WebElement bilgisayarTabletSecenegi;

    @FindBy(xpath = "//a[@class='sf-ChildMenuItems-OIXGN6gTcuAXz_dkh8Yv item-2353']//span[1]")
    public WebElement appleSecenegi;
    @FindBy(xpath = "//span[normalize-space()='13,2 inç']")
    public WebElement tabletIncBoyutu;


    @FindBy(xpath = "//*[@id=\"i27\"]/article/a/div/div[4]/div/div")
    // //*[@id="i27"]/div/a/div[2]/button         //*[@id="i27"]/article/a/div/div[4]/div/div   //*[@id="i27"]/div/a/div[2]/div[4]
    public WebElement urunUzerineGel;

    @FindBy(xpath = "//button[@data-test-id='addToCart']")
    public WebElement sepeteEkleButonu;
    @FindBy(xpath = "/html/body/div[6]/div/div/div[2]/div[2]/a") //  /div/div/div[2]/div[1]
    public WebElement sepeteEklendiMesaj;
    @FindBy(id = "basket_payedPrice")
    public WebElement sepetFiyati;
    @FindBy(id = "shoppingCart")
    public WebElement sepet;

    @FindBy(xpath = "//button[normalize-space()='Sepete git']")
    public WebElement sepeteGit;

    @FindAll({
            @FindBy(xpath = "//div[@data-test-id='price-current-price']")
    })
    public List<WebElement> currentPrice;

    @FindAll({
            @FindBy(xpath = "//div[@data-test-id='final-price-1']")
    })
    public List<WebElement> currentPrice2;


}



