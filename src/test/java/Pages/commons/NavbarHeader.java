package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class NavbarHeader extends BasePage {

    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[2]/a")
    private WebElement opinie;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[3]/a")
    private WebElement kontakt;
    @FindBy (css = "#menu > div.menu_left > a:nth-child(1) > i")
    private WebElement instagram;
    @FindBy (css = "#menu > div.menu_left > a:nth-child(2) > i")
    private WebElement facebook;
    @FindBy (css = "#menu > div.menu_left > a:nth-child(3) > i")
    private WebElement printerest;
    @FindBy (css = "#menu > div.menu_left > a:nth-child(4) > i")
    private WebElement youtube;

    public NavbarHeader(WebDriver driver) {
        super(driver);
    }
  //  METHODS for elements:
    public void openMainPage() {
        driver.get(BASE_URL);
    }

    public void getOpinieElement() {
        opinie.click();
    }

    public void getKontaktElement() {
        kontakt.click();
    }

    public void getInstagramIcon() {
        instagram.click();
    }

    public void getFacebookIcon() {
        facebook.click();
    }

    public void getPrinterestIcon() {
        printerest.click();
    }

    public void getYoutubeIcon() {
        youtube.click();
    }

}





