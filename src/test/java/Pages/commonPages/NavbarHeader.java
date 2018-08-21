package Pages.commonPages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavbarHeader extends BasePage {
    private WebDriver driver;
    private JavascriptExecutor jse;


    public NavbarHeader(WebDriver driver) {
        this.driver = driver;
        jse = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "navbar-brand")
    WebElement logoButton;
    @FindBy(xpath = "//a[text()='Home']")
    WebElement home;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[2]/a")
    WebElement hotels;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[3]/a")
    WebElement flights;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[4]/a")
    WebElement tours;
    @FindBy(xpath = ".//*[@id=\"collapse\"]/ul[1]/li[5]/a")
    WebElement cars;
    //TODO changed from ".// to "//*[@id=\"collapse\"]/ul[1]/li[6]/a" - cars test works
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[6]/a")
    WebElement visa;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[7]/a")
    WebElement offers;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[8]/a")
    WebElement blog;

    //MY ACCOUNT
    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']//a[@class='dropdown-toggle go-text-right']")
//    @FindBy(id = "li_myaccount")
    WebElement myAccountDropdown;
    @FindBy(xpath = "//*[@id=\"li_myaccount\"]/ul/li[1]/a")
    WebElement loginFromMyAccountDropdown;
    @FindBy(linkText = "Sign Up")
    WebElement signFromMyAccountDropdown;

    @FindBy (linkText = "Logout")
    WebElement logOut;

    //CURRENCY
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul")
    WebElement currency;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[2]/a")
//    WebElement currencyGBP;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[3]/a")
//    WebElement currencySAR;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[4]/a")
//    WebElement currencyEUR;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[5]/a")
//    WebElement currencyPKR;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[6]/a")
//    WebElement currencyKWD;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[7]/a")
//    WebElement currencyJPY;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[8]/a")
//    WebElement currencyINR;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[9]/a")
//    WebElement currencyCNY;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[10]/a")
//    WebElement currencyTRY;

    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a/strong")
    private WebElement currentCurrency;

    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[2]/a")
    private WebElement GBPCurrency;

    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a")
    private WebElement currencyList;

    //LANGUAGE OPTIONS
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/ul/li/ul")
    WebElement language;
//    @FindBy(xpath = "//*[@id=\"ar\"]")
//    WebElement ArabicLanguage;
//    @FindBy(xpath = "//*[@id=\"tr\"]")
//    WebElement TurkishLanguage;
//    @FindBy(xpath = "//*[@id=\"fr\"]")
//    WebElement FrenchLanguage;
//    @FindBy(xpath = "//*[@id=\"es\"]")
//    WebElement SpanishLanguage;
//    @FindBy(xpath = "//*[@id=\"ru\"]")
//    WebElement RussianLanguage;
//    @FindBy(xpath = "//*[@id=\"en\"]")
//    WebElement EnglishLanguage;

    //METHODS for elements:
    public void openMainPage() {
        driver.get("https://www.phptravels.net/");
    }


    public void pickHomeElement() {
        home.click();
    }

    public void pickHotelsElement() {
        hotels.click();
    }

    public void pickFlightsElement() {
        flights.click();
    }

    public void pickToursElement() {
        tours.click();
    }

    public void pickCarsElement() {
        cars.click();
    }

    public void pickVisaElement() {
        visa.click();
    }

    public void pickHOffersElement() {
        offers.click();
    }

    public void pickBlogElement() {
        blog.click();
    }

    // METHODS for accountDropdown
    public void loginToMyAccount() {
        myAccountDropdown.click();
        loginFromMyAccountDropdown.click();

    }

    public void SignInMyAccount() {
        myAccountDropdown.click();
        signFromMyAccountDropdown.click();
    }

//    public NavbarHeader selectAccountDropdownOptions (String text){
//        Select selectAccountOptions = new Select(myAccountDropdown);
//        selectAccountOptions.selectByVisibleText(text);
//        return this;
//    }
    public void logOut (){
       jse.executeScript("arguments[0].click();", myAccountDropdown);
        jse.executeScript("arguments[0].click();", logOut );
    }

    public WebElement getMyAccountDropdown() {
        return myAccountDropdown;
    }

    public WebElement getLogOut() {
        return logOut;
    }

    public void setCurrency(String currency){
        currencyList.click();
        driver.findElement(By.linkText(currency)).click();
    }

    public WebElement getCurrentCurrency() {
        return currentCurrency;
    }


    //METHODS for currency, not sure it works
    public String pickCurrency(String text) {
        Select currencyList = new Select(currency);
        currencyList.selectByValue(text);
//
//        LOGGER.info("Currency chosen" + text);
 LOGGER.debug( "Currency selected: " + currency.getAttribute("value"));
      return currency.getAttribute("value");
     }


    //METHODS for currency
//    public String pickCurrency(String text) {
//        Select currencyList = new Select(currency());
//        currencyList.selectByValue(text);

//        LOGGER.info("Currency chosen" + text);
//        LOGGER.log(Level.INFO, "Currency selected: " + currency.getAttribute("value"));
//        return currency.getAttribute("value");
//    }

//przerwalam tworzenie, metody rozwijania z listy beda dodane
}





