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

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().version("81"); // <--- to na starego kompa
        //WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {

        this.driver = new ChromeDriver();
        this.footer = new Footer(driver);
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        footer.openMainPage();

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
    public void changeToZblogowani() {

        this.footer.getZblogowani();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl())
                .isEqualTo("https://zblogowani.pl/blogi_pozostale/dorabiajprzezinternet-blogspot-com");
    }
}
