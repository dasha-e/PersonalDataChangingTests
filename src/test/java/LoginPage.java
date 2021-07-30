import org.openqa.selenium.WebDriver;

public class LoginPage extends DefaultPage{

    WebDriver driver;
    private final String LOGIN_LOCATOR = ".//input[@id='field_email']";
    private final String PASSWORD_LOCATOR = ".//input[@id='field_password']";
    private final String SIGN_IN_LOCATOR = ".//input[@class = 'button-pro __wide']";

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public DefaultPage doLogin(String username, String password) {
        changeField(driver, LOGIN_LOCATOR, username);
        changeField(driver, PASSWORD_LOCATOR, password);
        clickOnElement(driver, SIGN_IN_LOCATOR);
        return new DefaultPage();
    }

}

