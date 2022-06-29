import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefaultPage {
    public void clickOnElement(WebDriver driver, String XPATH){
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(By.xpath(XPATH)).click();
                break;
            } catch(Exception e) {
            }
            attempts++;
        }
    }

    public boolean isElementHere(WebDriver driver, String XPATH){
        try{
            driver.findElement(By.xpath(XPATH));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void changeField(WebDriver driver, String FIELD_LOCATOR, String newValue) {
        driver.findElement(By.xpath(FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(FIELD_LOCATOR)).sendKeys(newValue);
    }
}
