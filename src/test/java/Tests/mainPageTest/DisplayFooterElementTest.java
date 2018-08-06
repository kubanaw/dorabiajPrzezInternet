package Tests.mainPageTest;

import Pages.commonPages.Footer;
import Pages.homePage.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DisplayFooterElementTest {
    //ilona tutaj pisze
    private WebDriver driver;
    private Footer footer;
    private HomePage homePage;

    @BeforeClass
    public static void ustawSciezke() {
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.footer = PageFactory.initElements(this.driver, Footer.class);
    }

    @After
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(14,TimeUnit.SECONDS);
        driver.quit();

    }

    //zapis na newsletter
    @Test
    public void addEmailToNewsletterList() {
        this.driver.get("https://www.phptravels.net/");
        this.footer.getEmailField().sendKeys("abactestqwerty3210@gmail.com");
        this.footer.getSubmitNewsletterButton().click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/ul/li/a/div")).getText();
        System.out.println(subscribedSuccessfullyAlert);
        assertEquals("SUBSCRIBED SUCCESSFULLY", subscribedSuccessfullyAlert);
//        String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/ul/li/a/div")).getText();
//        System.out.println(subscribedSuccessfullyAlert);
//        assertEquals("ALREADY SUBSCRIBED", subscribedSuccessfullyAlert);



    }

}
