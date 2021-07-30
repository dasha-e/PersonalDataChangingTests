import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    BaseTest() {

    }

    public void driverInit() {
        System.setProperty("webdriver.chrome.driver", "C:/configs/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    public void get() {
        driver.manage().window();
        driver.get("https://ok.ru/");
    }

    public void driverDown() {
        driver.quit();
    }
}

