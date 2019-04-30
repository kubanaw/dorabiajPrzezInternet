package Tests.mainPageTest;


import Pages.commons.Footer;
import Pages.commons.MainPage;
import Pages.commons.NavbarHeader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;


public class DisplayMainPageElements{

    private WebDriverWait wait;
    private WebDriver driver;
    private Footer footer;
    private NavbarHeader navbarHeader;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().version("73");
        //WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {

        this.driver = new ChromeDriver();
        this.footer = new Footer(driver);
        this.navbarHeader = new NavbarHeader(driver);
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        navbarHeader.openMainPage();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        if (driver != null)
        driver.quit();
    }
}
