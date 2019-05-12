package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Footer extends BasePage {

    @FindBy(xpath = "//*[@id=\"u_0_2\"]/a[1]")
    private WebElement polubTeStrone;

    @FindBy(xpath = "//*[@id=\"u_0_3\"]/button")
    private WebElement skontaktujSieZNami;

    @FindBy(xpath = "//*[@id=\"HTML9\"]/div[1]/p/a/img")
    private WebElement zblogowani;

    @FindBy(xpath = "/html/body/ul/li[3]/a/figure/div[1]/img")
    private WebElement instagram;

    public Footer(WebDriver driver) {
        super(driver);
    }

    //METHODS:
    public void openMainPage() {
        driver.get(BASE_URL);
    }

    public void getPolubTeStrone () {
        polubTeStrone.click();
    }

    public void getSkontaktujSieZNami () {
        skontaktujSieZNami.click();
    }
    public void getZblogowani () {
        zblogowani.click();
    }

    public void getInstagram () {
        instagram.click();
    }

}
