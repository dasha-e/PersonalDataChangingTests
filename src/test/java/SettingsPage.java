import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends DefaultPage {

    WebDriver driver;

    private final String FORM_LOCATOR = ".//form[contains(@action, 'settings')]";
    private final String CLOSE_ICO_LOCATOR = ".//a[contains(@class, 'close_ico')]";
    private final String NOTIFY_PANEL_LOCATOR = ".//div[@id='notifyPanel_msg']";
    private final String NOTIFY_PANEL_CLOSE_BUTTON = ".//input[contains(@id, 'close')]";

    private final String CURRENT_CITY_LOCATOR = ".//input[@id='field_citySugg_SearchInput']"; //
    private final String CURRENT_CITY_INPUT_LOCATOR = ".//div[@id='citySugg_InputContainer']";

    private final String NATIVE_CITY_INPUT_LOCATOR = ".//div[@id='cityBSugg_InputContainer']";
    private final String NATIVE_CITY_LOCATOR = ".//input[@id='field_cityBSugg_SearchInput']";
    private final String CITY_VALUE = " and @value=";

    private final String PERSONAL_DATA_EDIT = ".//div[text()='Личные данные']";
    private final String CONFIRM_BUTTON = ".//input[contains(@class, 'yes')]";

    private final String MEN_LOCATOR = ".//input[@value=1]";
    private final String WOMEN_LOCATOR = ".//input[@value=2]";
    private final String GENDER_SELECTED = " and @checked='checked'";

    private final String BIRTHDAY_DATE = ".//select[@name='fr.bday']";
    private final String BIRTHDAY_MOUNTH = ".//select[@name='fr.bmonth']";
    private final String BIRTHDAY_YEAR = ".//select[@name='fr.byear']";
    private final String BIRTHDAY_OPT = "//option[@value=";
    private final String BIRTHDAY_SELECTED = " and @selected='selected'";

    private final String NAME_FIELD_LOCATOR = ".//input[contains(@id, '_name')]";
    private final String SURNAME_FIELD_LOCATOR = ".//input[contains(@id, '_surname')]";
    private final String NAME_FIELD_VALUE = " and @value=";

    public String substructLocator(String LOCATOR){
        return LOCATOR.substring(0, LOCATOR.length()-1);
    }

    SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openChangingPersonalDataSpace(){
        clickOnElement(driver, PERSONAL_DATA_EDIT);
    }
    public SettingsPage saveChanges(){
        clickOnElement(driver, CONFIRM_BUTTON);
        return new SettingsPage(driver);
    }
    public SettingsPage closeChangingPersonalDataSpace(){
        clickOnElement(driver, CLOSE_ICO_LOCATOR);
        return new SettingsPage(driver);
    }
    public boolean errorNotify(){
        boolean flag = isElementHere(driver, NOTIFY_PANEL_LOCATOR);
        if(flag) clickOnElement(driver, NOTIFY_PANEL_CLOSE_BUTTON);
        return flag;
    }

    public void changeName(String newValue){
        changeField(driver, NAME_FIELD_LOCATOR, newValue);
    }
    public void changeSurname(String newValue){
        changeField(driver, SURNAME_FIELD_LOCATOR, newValue);
    }

    private void changeCity(String newCity, String CITY_LOCATOR, String CITY_INPUT_LOCATOR){
        changeField(driver, CITY_LOCATOR, newCity);
        driver.findElement(By.xpath(CITY_INPUT_LOCATOR)).click();
        driver.findElement(By.xpath(FORM_LOCATOR)).click();

    }

    public void changeCurrentCity(String newCity){
        changeCity(newCity, CURRENT_CITY_LOCATOR, CURRENT_CITY_INPUT_LOCATOR);
    }

    public void changeNativeCity(String newCity){
        changeCity(newCity, NATIVE_CITY_LOCATOR, NATIVE_CITY_INPUT_LOCATOR);
    }

    public String changeGender(){
        if(isElementHere(driver, substructLocator(MEN_LOCATOR) + GENDER_SELECTED + "]")){
            clickOnElement(driver, WOMEN_LOCATOR);
            return WOMEN_LOCATOR;
        }
        else {
            clickOnElement(driver, MEN_LOCATOR);
            return MEN_LOCATOR;
        }
    }

    public void checkGenderChanged(String GEN_LOCATOR){
        Assert.assertTrue("Gender: incorrect", isElementHere(driver, substructLocator(GEN_LOCATOR) + GENDER_SELECTED + "]"));
        System.out.println("Gender: correct");
    }
    private void changeBirthdayField(String SPACE, Integer option){
        clickOnElement(driver, SPACE);
        clickOnElement(driver, SPACE + BIRTHDAY_OPT + option +"]");
    }

    public void changeBirthdayDate(Integer date){
        changeBirthdayField(BIRTHDAY_DATE, date);
    }
    public void changeBirthdayMounth(Integer mounth){
        changeBirthdayField(BIRTHDAY_MOUNTH, mounth);
    }
    public void changeBirthdayYear(Integer year){
        changeBirthdayField(BIRTHDAY_YEAR, year);
    }

    private void checkFieldChanged(WebDriver driver, String XPATH, String message) {
        Assert.assertTrue(message + "incorrect", isElementHere(driver, XPATH));
        System.out.println(message + "correct");
    }

    private void checkFieldNotChanged(WebDriver driver, String XPATH, String message) {
        Assert.assertFalse(message + "incorrect", isElementHere(driver, XPATH));
        System.out.println(message + "correct");
    }

    public void checkCorrectBirthdayDate(Integer date){
        System.out.println(BIRTHDAY_DATE + BIRTHDAY_OPT + date + BIRTHDAY_SELECTED + "]");
        System.out.println(isElementHere(driver, BIRTHDAY_DATE + BIRTHDAY_OPT + date + BIRTHDAY_SELECTED + "]"));
        checkFieldChanged(driver, BIRTHDAY_DATE + BIRTHDAY_OPT + date + BIRTHDAY_SELECTED + "]", "Date of birth: ");
    }
    public void checkIncorrectBirthdayDate(Integer date){
        checkFieldNotChanged(driver, BIRTHDAY_DATE + BIRTHDAY_OPT + date + BIRTHDAY_SELECTED + "]", "Date of birth: ");
    }

    public void checkCorrectBirthdayMounth(Integer mounth){
        checkFieldChanged(driver, BIRTHDAY_MOUNTH + BIRTHDAY_OPT + mounth + BIRTHDAY_SELECTED + "]", "Mounth of birth: ");
    }
    public void checkIncorrectBirthdayMounth(Integer mounth){
        checkFieldNotChanged(driver, BIRTHDAY_MOUNTH + BIRTHDAY_OPT + mounth + BIRTHDAY_SELECTED + "]", "Mounth of birth: ");
    }

    public void checkCorrectBirthdayYear(Integer year){
        checkFieldChanged(driver, BIRTHDAY_YEAR + BIRTHDAY_OPT + year + BIRTHDAY_SELECTED + "]", "Year of birth: ");
    }
    public void checkIncorrectBirthdayYear(Integer year){
        checkFieldNotChanged(driver, BIRTHDAY_YEAR + BIRTHDAY_OPT + year + BIRTHDAY_SELECTED + "]", "Year of birth: ");
    }

    public void checkCorrectName(String name){
        checkFieldChanged(driver, NAME_FIELD_LOCATOR + NAME_FIELD_VALUE + "'" + name + "'" + "]", "Name: ");
    }
    public void checkIncorrectName(String name){
        checkFieldNotChanged(driver, NAME_FIELD_LOCATOR + NAME_FIELD_VALUE + "'" + name + "'" + "]", "Name: ");
    }

    public void checkCorrectSurname(String surname){
        checkFieldChanged(driver, SURNAME_FIELD_LOCATOR + NAME_FIELD_VALUE + "'" + surname + "'" + "]", "Surname: ");
    }
    public void checkIncorrectSurname(String surname){
        checkFieldNotChanged(driver, SURNAME_FIELD_LOCATOR + NAME_FIELD_VALUE + "'" + surname + "'" + "]", "Surname: ");
    }

    public void checkCorrectNativeCity(String city){
        checkFieldChanged(driver, substructLocator(NATIVE_CITY_LOCATOR) + CITY_VALUE + "'" + city + "'" + "]", "Native City: " );
    }
    public void checkIncorrectNativeCity(String city){
        checkFieldNotChanged(driver, substructLocator(NATIVE_CITY_LOCATOR) + CITY_VALUE + "'" + city + "'" + "]", "Native City: " );
    }

    public void checkCorrectCurrentCity(String city){
        checkFieldChanged(driver, substructLocator(CURRENT_CITY_LOCATOR) + CITY_VALUE +"'" + city + "'" + "]", "Current City: " );
    }
    public void checkIncorrectCurrentCity(String city){
        checkFieldNotChanged(driver, substructLocator(CURRENT_CITY_LOCATOR) + CITY_VALUE + "'" + city + "'" + ")]", "Current City: " );
    }
}
