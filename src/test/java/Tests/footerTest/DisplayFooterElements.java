package Tests.footerTest;


import Pages.commons.Footer;
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


public class DisplayFooterElements {

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

        //scrollowanie na dół strony za pomocą skryptu js, żeby uwidocznić element footera:
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");

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


    @Test
    public void addEmailToNewsletterList() {

        this.footer.typeEmailToNewsletter();
        assertThat(footer.alreadySubscribedMessage())
                .isEqualToIgnoringCase("Subscribed Successfully");
    }


}
