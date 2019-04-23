package Tests.navbarTest;

import Pages.commons.NavbarHeader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

public class DisplayNavBar {


    private WebDriver driver;
    private WebDriverWait wait;
    private NavbarHeader navbarHeader;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().version("73");
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 5);
        this.navbarHeader = new NavbarHeader(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        navbarHeader.openMainPage();
    }

    @After
    public void closeBrowser() {
        this.driver.quit();
    }

    @Test
    public void changeToAboutUs() {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("#menu > div.menu_right > ul > li:nth-child(1) > a"));
        actions.moveToElement(menu);

        WebElement submenu = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/ul/li[1]/ul/li[1]/a"));
        actions.moveToElement(submenu);
        actions.click().build().perform();

    }

    @Test
    public void changeToMy(){
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("#menu > div.menu_right > ul > li:nth-child(1) > a"));
        actions.moveToElement(menu);

        WebElement submenu = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/ul/li[1]/ul/li[2]/a"));
        actions.moveToElement(submenu);
        actions.click().build().perform();
    }

    @Test
    public void changeToOpinie() {

        this.navbarHeader.getOpinieElement();
        assertThat(navbarHeader.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/p/opinie.html");
        assertThat(navbarHeader.getTitle())
                .isEqualTo("Dorabiaj przez Internet: Opinie | Referencje");
    }

    @Test
    public void changeToKontakt() {

        this.navbarHeader.getKontaktElement();
        assertThat(navbarHeader.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/p/kontakt-zarabianie-w-domu-przez-internet.html");
        assertThat(navbarHeader.getTitle())
                .isEqualTo("Dorabiaj przez Internet: Kontakt");
    }

}
