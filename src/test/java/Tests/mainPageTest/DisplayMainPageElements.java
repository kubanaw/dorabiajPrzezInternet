package Tests.mainPageTest;


import Pages.commons.Footer;
import Pages.commons.MainPage;
import Pages.commons.NavbarHeader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;


public class DisplayMainPageElements {

    private WebDriverWait wait;
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().version("81"); // <--- to na starego kompa
        //WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {

        this.driver = new ChromeDriver();
        this.mainPage = new MainPage(driver);
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        mainPage.openMainPage();

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
    public void changeToHeader() {
        this.mainPage.getHeaderElement();
        assertThat(mainPage.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/");
        assertThat(mainPage.getTitle())
                .isEqualTo("Dorabiaj przez Internet");
    }

    @Test
    public void changeToZacznijTutaj() {

        this.mainPage.getZacznijTutaj();
        assertThat(mainPage.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/p/zacznij-tutaj.html");
        assertThat(mainPage.getTitle())
                .isEqualTo("Dorabiaj przez Internet: Zacznij tutaj");
    }
    @Test
    public void changeToGdzieZarabiamy() {

        this.mainPage.getGdzieZarabiamy();
        assertThat(mainPage.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/p/gdzie-dorabiamy.html");
        assertThat(mainPage.getTitle())
                .isEqualTo("Dorabiaj przez Internet: Gdzie zarabiamy?");
    }
    @Test
    public void changeToGdzieOszczedzamy() {

        this.mainPage.getGdzieOszczedzamy();
        assertThat(mainPage.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/p/gdzie-oszczedzamy.html");
        assertThat(mainPage.getTitle())
                .isEqualTo("Dorabiaj przez Internet: Gdzie oszczędzamy?");
    }

    @Test
    public void changeToFAQ() {

        this.mainPage.getFaq();
        assertThat(mainPage.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/p/faq.html");
        assertThat(mainPage.getTitle())
                .isEqualTo("Dorabiaj przez Internet: FAQ");
    }

    @Test
    public void changeToKategorieBloga() {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("#menu1 > ul > li:nth-child(5) > a"));
        actions.moveToElement(menu);

        WebElement submenu = driver.findElement(By.cssSelector("#menu1 > ul > li:nth-child(5) > ul > li:nth-child(1) > a"));
        actions.moveToElement(submenu);
        actions.click().build().perform();
    }

    @Test
    public void changeToPodatkuDarowizna() {

        this.mainPage.getPodatkuDarowizna();
        assertThat(mainPage.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/2016/03/wspomoz-artura-1-podatku-lub-darowizna.html");
        assertThat(mainPage.getTitle())
                .isEqualTo("Wspomóż Artura 1% podatku lub darowizną | Dorabiaj przez Internet");
    }
}
