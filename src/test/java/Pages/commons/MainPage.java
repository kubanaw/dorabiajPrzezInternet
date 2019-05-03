package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy (css = "#Header1_headerimg")
    private WebElement header;
    @FindBy (css = "#menu1 > ul > li:nth-child(1) > a")
    private WebElement zacznijTutaj;
    @FindBy (css = "#menu1 > ul > li:nth-child(2) > a")
    private WebElement gdzieZarabiamy;
    @FindBy (css = "#menu1 > ul > li:nth-child(3) > a")
    private WebElement gdzieOszczedzamy;
    @FindBy (css = "#menu1 > ul > li:nth-child(4) > a")
    private WebElement FAQ;
    @FindBy (css = "#menu1 > ul > li:nth-child(5) > a")
    private WebElement kategorieBloga;
    @FindBy (css = "#menu1 > ul > li:nth-child(6) > a")
    private WebElement podatkuDarowizna;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public void openMainPage() {
        driver.get(BASE_URL);
    }
    //METHODS for elements:
    public void getHeaderElement() {
        header.click();
    }
    public void getZacznijTutaj() {
        zacznijTutaj.click();
    }
    public void getGdzieZarabiamy() {
        gdzieZarabiamy.click();
    }
    public void getGdzieOszczedzamy() {
        gdzieOszczedzamy.click();
    }
    public void getFaq() {
        FAQ.click();
    }
    public void getKategorieBloga() {
        kategorieBloga.click();
    }
    public void getPodatkuDarowizna(){
        podatkuDarowizna.click();
    }
    public String getTitle() {
        String currentTitle = driver.getTitle();
        LOGGER.info("current title: " + currentTitle);
        return currentTitle;
    }
}
