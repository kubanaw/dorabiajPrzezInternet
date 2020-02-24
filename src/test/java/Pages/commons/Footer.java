package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Footer extends BasePage {

    @FindBy(xpath = "//*[@id=\"HTML9\"]/div[1]/p/a/img")
    private WebElement zblogowani;

    public Footer(WebDriver driver) {
        super(driver);
    }
    //METHODS:
    public void openMainPage() {
        driver.get(BASE_URL);
    }
    public void getZblogowani () {
        zblogowani.click();
    }
}
