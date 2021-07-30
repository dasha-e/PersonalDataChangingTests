import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;


public class Tests extends BaseTest {

    String username = "technopolisbot1";
    String password = "technopolis16";

    Random rnd = new Random(System.currentTimeMillis());
    String usernameRus = "Технополисбот" + rnd.nextInt(10);
    String usernameEng = "Technopolisbot" + rnd.nextInt(10);
    String emptyStr = "";
    String NEW_CITY_1 = "Санкт-Петербург, Россия";
    String NEW_CITY_2 = "Москва, Россия";
    String NEW_CITY_3 = "Город";

    Integer dateCorr = rnd.nextInt(31);
    Integer dateInc = rnd.nextInt(31) + 50;
    Integer mounthCorr = rnd.nextInt(12);
    Integer mounthInc = rnd.nextInt(12) + 50;
    Integer yearCorr = rnd.nextInt(97)+1910;
    Integer yearInc = rnd.nextInt(10);



    @Before
    public void start() {
        driverInit();
        get();
        DefaultPage page = new LoginPage(driver).doLogin(username, password);
        driver.get("https://ok.ru/settings");
    }


    @Test
    public void Test1(){
        SettingsPage page = new SettingsTest(driver).changeNameTest(usernameRus, true);
        page = new SettingsTest(driver).changeNameTest(usernameEng, true);
        new SettingsTest(driver).changeNameTest(emptyStr, false);
    }

    @Test
    public void Test2(){
        SettingsPage page = new SettingsTest(driver).changeSurnameTest(usernameRus, true);
        page = new SettingsTest(driver).changeSurnameTest(usernameEng, true);
        new SettingsTest(driver).changeSurnameTest(emptyStr, false);
    }
    @Test
    public void Test3() {
        SettingsPage page = new SettingsTest(driver).changeCurrentCityTest(NEW_CITY_1, true);
        page = new SettingsTest(driver).changeCurrentCityTest(NEW_CITY_2, true);
        page = new SettingsTest(driver).changeCurrentCityTest(NEW_CITY_3, false);
    }
    @Test
    public void Test4() {
        SettingsPage page = new SettingsTest(driver).changeNativeCityTest(NEW_CITY_1, true);
        page = new SettingsTest(driver).changeNativeCityTest(NEW_CITY_2, true);
        page = new SettingsTest(driver).changeNativeCityTest(NEW_CITY_3, false);
    }
    @Test
    public void Test5(){
        SettingsPage page = new SettingsTest(driver).changeGenderTest();
    }
    @Test
    public void Test6(){
        SettingsPage page = new SettingsTest(driver).changeBirthdayDateTest(dateCorr, mounthCorr, yearCorr, true);
        page = new SettingsTest(driver).changeBirthdayDateTest(dateInc, mounthInc, yearInc, false);
    }


    @After
    public void stop() {
        driverDown();
    }
}
