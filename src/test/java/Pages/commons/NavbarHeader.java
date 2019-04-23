package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class NavbarHeader extends BasePage {

    @FindBy(css = "#menu > div.menu_right > ul > li:nth-child(1) > a")
    private WebElement languageList;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[1]/ul/li[1]/a")
    private WebElement oBlogu;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[1]/ul/li[2]/a")
    private WebElement my;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[2]/a")
    private WebElement opinie;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[3]/a")
    private WebElement kontakt;

    public NavbarHeader(WebDriver driver) {
        super(driver);
    }

    //METHODS for elements:
    public void openMainPage() {
        driver.get(BASE_URL);
    }

    public void getOpinieElement() {
        opinie.click();
    }

    public void getKontaktElement() {
        kontakt.click();
    }

    public String getTitle() {
        String currentTitle = driver.getTitle();
        LOGGER.info("current title: " + currentTitle);
        return currentTitle;
    }
}





