package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

        protected final static Logger LOGGER = LogManager.getLogger(BasePage.class);
        protected final static String BASE_URL = "http://www.dorabiajprzezinternet.pl/";
        protected WebDriver driver;
        protected WebDriverWait wait;

        //create random Strings, e-mails and numbers
        protected  String randomString = RandomStringUtils.randomAlphabetic(7, 10);
        protected  String randomEmail = randomString + "@nwytg.pl";
        private int numberOfDigits;

        public BasePage(WebDriver driver) {
                this.driver = driver;
                this.wait = new WebDriverWait(driver, 10);
                PageFactory.initElements(driver, this);
        }

        protected String getRandomNumber (int numberOfDigits) {
                String randomNumber = RandomStringUtils.randomNumeric(numberOfDigits);
                return randomNumber;
        }

        public String getCurrentUrl() {
                String currentURL = driver.getCurrentUrl();
                LOGGER.debug("Current URL: " + currentURL);
                return currentURL;
        }

}
