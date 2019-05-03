package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Footer extends BasePage {

    @FindBy(id = "exampleInputEmail1")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[2]/div/div[1]/div/div/div[2]/button")
    private WebElement submitNewsletterButton;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[1]/ul/li[1]/a")
    private WebElement contactLink;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[1]/ul/li[2]/a")
    private WebElement aboutUS;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[1]/ul/li[3]/a")
    private WebElement howToBook;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[1]/ul/li[4]/a")
    private WebElement bookingTips;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[2]/ul/li[1]/a")
    private WebElement ourPartners;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[2]/div/div[1]/div/div/ul/li/a/div")
    private WebElement subscribeMessage;

    @FindBy (xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[2]/ul/li[2]/a")
    private WebElement privacyPolicy;

    @FindBy (xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[2]/ul/li[3]/a")
    private WebElement termsOfUse;

    @FindBy (xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[3]/ul/li[1]/a")
    private WebElement FAQ;

    @FindBy (xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[1]/div[1]/div/div[3]/ul/li[2]/a")
    private WebElement supplierLogin;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[2]/div/div[2]/div[1]/div/ul/li[1]/a/img")
    private WebElement faceBookIcon;

    @FindBy(xpath = "//*[@id=\"footer\"]/aside/div/div/div/div[2]/div/div[2]/div[1]/div/ul/li[2]/a/img")
    private WebElement twitterIcon;

    public Footer(WebDriver driver) {
        super(driver);
    }

    //METHODS:

    public String alreadySubscribedMessage() {
        wait.until(ExpectedConditions.visibilityOf(subscribeMessage));
        LOGGER.debug("tekst z guzika " + subscribeMessage.getText());
        return subscribeMessage.getText();
    }

    public WebElement getContactLink() {
        return contactLink;
    }

    public WebElement getAboutUS() {
        return aboutUS;
    }

    public WebElement getHowToBook() {
        return howToBook;
    }

    public WebElement getBookingTips() {
        return bookingTips;
    }

    public WebElement getOurPartners() {
        return ourPartners;
    }

    public WebElement getPrivacyPolicy() {
        return privacyPolicy;
    }

    public WebElement getTermsOfUse() {
        return termsOfUse;
    }

    public WebElement getFAQ() {
        return FAQ;
    }

    public WebElement getSupplierLogin() {
        return supplierLogin;
    }

    public Footer typeEmailToNewsletter(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        LOGGER.info("Current email: " + email);
        submitNewsletterButton.click();
        return this;
    }

    //method overloading to type random emails
    public Footer typeEmailToNewsletter() {
        emailField.clear();
        emailField.sendKeys(randomEmail);
        LOGGER.trace("Current email: " + randomEmail);
        submitNewsletterButton.click();
        return this;
    }

    public WebElement getFaceBookIcon() {
        return faceBookIcon;
    }

    public WebElement getTwitterIcon() {
        return twitterIcon;
    }

}
