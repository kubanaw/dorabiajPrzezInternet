package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class NavbarHeader extends BasePage {

    @FindBy(className = "navbar-brand")
    private WebElement logoButton;
    @FindBy(xpath = "//a[text()='Home']")
    private WebElement home;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[2]/a")
    private WebElement hotels;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[3]/a")
    private WebElement flights;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[4]/a")
    private WebElement tours;
    @FindBy(xpath = ".//*[@id=\"collapse\"]/ul[1]/li[5]/a")
    private WebElement cars;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[6]/a")
    private WebElement visa;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[7]/a")
    private WebElement offers;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[8]/a")
    private WebElement blog;

    //CURRENCY
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul")
//    private WebElement currency;
    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/li[2]/ul/li[1]/a")
    private WebElement currentCurrency;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/li[2]/a/strong")
    private WebElement currencyList;

    //LANGUAGE OPTIONS
    @FindBy(css = "#menu > div.menu_right > ul > li:nth-child(1) > a")
    private WebElement languageList;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[1]/ul/li[1]/a")
    private WebElement oBlogu;
    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/ul/li[1]/ul/li[2]/a")
    private WebElement my;


    public NavbarHeader(WebDriver driver) {
        super(driver);
    }

    //METHODS for elements:
    public void openMainPage() {
        driver.get(BASE_URL);
    }

    public void pickHomeElement() {
        home.click();
    }

    public void pickHotelsElement() {
        hotels.click();
    }


    public void setCurrency(String currency) {
        currencyList.click();
        driver.findElement(By.linkText(currency)).click();
    }

    public void setLanguage(String language) {
        languageList.click();
        driver.findElement(By.linkText(language)).click();
    }

    public WebElement getCurrentCurrency() {
        return currentCurrency;
    }


    public String getTitle() {
        String currentTitle = driver.getTitle();
        LOGGER.info("current title: " + currentTitle);
        return currentTitle;
    }

}





