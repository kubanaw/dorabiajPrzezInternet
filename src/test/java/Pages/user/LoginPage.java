package Pages.user;

import Pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

    //TODO create login options tests

    private final String url = "https://www.phptravels.net/login";
    private JavascriptExecutor jse;

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']//a[@class='dropdown-toggle go-text-right']")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Logout")
    private WebElement logOut;

    @FindBy (linkText = "Account")
    private WebElement account;

    @FindBy(css = "div.panel> div.wow")
    private WebElement loginPanel;

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "remember")
    private WebElement rememberMeCheckBox;

    @FindBy(className = "loginbtn")
    private WebElement loginButton;

    @FindBy(linkText = "Sign Up")
    private WebElement signUpButton;

    @FindBy(linkText = "Forget Password")
    private WebElement forgetPasswordButton;

    @FindBy(id = "resetemail")
    private WebElement resetPasswordField;

    @FindBy(css = "button.btn.btn-primary.resetbtn")
    private WebElement resetButton;

    @FindBy(css = " div.alert.alert-danger")
    private WebElement resetAlertText;

    public LoginPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void loginPageOpen() {
        driver.get(url);
    }

    public String getCurrentUrl() {
        String currentURL = driver.getCurrentUrl();
        LOGGER.debug("Current URL of Login Page: " + currentURL);
        return currentURL;
    }

    public String getUrl() {
        return url;
    }

    public WebElement getLoginPanel() {
        return loginPanel;
    }

    public void fillUserEmailField(String userEmail) {
        userName.clear();
        userName.sendKeys(userEmail);
    }

    public void fillUsersPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void checkRememberMe() {
        if (!rememberMeCheckBox.isSelected())
            rememberMeCheckBox.click();
    }

    public void clickSignUp() {
        signUpButton.click();
    }


    public void fillEmailToPasswordReset(String email) {
        resetPasswordField.clear();
        resetPasswordField.sendKeys(email);

    }

    public void resetPassword() {
        forgetPasswordButton.click();
    }

    public String getResetAlertMessage() {

        String alertMessage = resetAlertText.getText();
        LOGGER.debug("Current reset alert: " + alertMessage);
        return alertMessage;
    }


    public void loginDemoUser() {

        LOGGER.info("Login DemoUser start.");
        fillUserEmailField("user@phptravels.com");
        fillUsersPassword("demouser");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
            LOGGER.info("Login DemoUser success!");
        } catch (TimeoutException toe) {
            LOGGER.info("Login button is not clickable " + toe);

        }
    }

    public void logOut() {

        jse.executeScript("arguments[0].click();", myAccountDropdown);
        jse.executeScript("arguments[0].click();", logOut);
        LOGGER.info("Logout successful!");
    }

    public void backToUserAccount (){
        jse.executeScript("arguments[0].click();", myAccountDropdown);
        jse.executeScript("arguments[0].click();", account);
        LOGGER.info("Back to User's Account");

    }


}
