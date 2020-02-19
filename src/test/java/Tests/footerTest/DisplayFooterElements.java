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
        //WebDriverManager.chromedriver().version("79"); // <--- to na starego kompa
        WebDriverManager.chromedriver().setup();
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
    public void changeToPolubTeStrone(){

        this.footer.getPolubTeStrone();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl())
                .isEqualTo("https://www.facebook.com/v2.6/plugins/error/confirm/page?iframe_referer=http%3A%2F%2Fwww.dorabiajprzezinternet.pl%2F&kid_directed_site=false&secure=true&plugin=page&return_params=%7B%22adapt_container_width%22%3A%22true%22%2C%22app_id%22%3A%22%22%2C%22channel%22%3A%22https%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2Fd_vbiawPdxB.js%3Fversion%3D44%23cb%3Df1b58eff2cd917%26domain%3Dwww.dorabiajprzezinternet.pl%26origin%3Dhttp%253A%252F%252Fwww.dorabiajprzezinternet.pl%252Ff11466cfb0008ec%26relation%3Dparent.parent%22%2C%22container_width%22%3A%22384%22%2C%22height%22%3A%2270%22%2C%22hide_cover%22%3A%22false%22%2C%22href%22%3A%22https%3A%2F%2Fwww.facebook.com%2Fdorabiajprzezinternet%2F%3Ffref%3Dts%2F%22%2C%22locale%22%3A%22pl_PL%22%2C%22sdk%22%3A%22joey%22%2C%22show_facepile%22%3A%22true%22%2C%22small_header%22%3A%22false%22%2C%22tabs%22%3A%22timeline%22%2C%22ret%22%3A%22sentry%22%2C%22act%22%3Anull%7D");
    }

    @Test
    public void changeToSkontaktujSieZNami(){

        this.footer.getSkontaktujSieZNami();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl())
                .isEqualTo("http://www.dorabiajprzezinternet.pl/");
    }
//dupa
    @Test
    public void changeToZblogowani() {

        this.footer.getZblogowani();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl())
                .isEqualTo("https://zblogowani.pl/blogi_pozostale/dorabiajprzezinternet-blogspot-com");
    }

    @Test
    public void changeToInstagram() {

        this.footer.getInstagram();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl())
                .isEqualTo("https://www.instagram.com/p/BvcG61rAbVV/");
    }

}
