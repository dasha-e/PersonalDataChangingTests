import org.openqa.selenium.WebDriver;

public class SettingsTest {

    WebDriver driver;

    SettingsTest(WebDriver driver) {
        this.driver = driver;
    }

    public SettingsPage changeCurrentCityTest(String NewCity, boolean correctness){
        SettingsPage pp = new SettingsPage(driver);
        pp.openChangingPersonalDataSpace();
        pp.changeCurrentCity(NewCity);
        pp.saveChanges();

        pp.openChangingPersonalDataSpace();
        if(correctness) pp.checkCorrectCurrentCity(NewCity);
        else pp.checkIncorrectCurrentCity(NewCity);
        return pp;
    }
    public SettingsPage changeNativeCityTest(String NewCity, boolean correctness){
        SettingsPage pp = new SettingsPage(driver);
        pp.openChangingPersonalDataSpace();
        pp.changeNativeCity(NewCity);
        pp.saveChanges();
        if(!correctness) pp.closeChangingPersonalDataSpace();
        pp.openChangingPersonalDataSpace();
        if(correctness) pp.checkCorrectNativeCity(NewCity);
        else pp.checkIncorrectNativeCity(NewCity);
        return pp;
    }

    public SettingsPage changeNameTest(String NewName, boolean correctness){
        SettingsPage pp = new SettingsPage(driver);
        pp.openChangingPersonalDataSpace();
        pp.changeName(NewName);
        pp.saveChanges();
        boolean sucsess = !(pp.errorNotify());
        pp.openChangingPersonalDataSpace();
        if(sucsess & correctness) pp.checkCorrectName(NewName);
        else pp.checkIncorrectName(NewName);
        return pp;
    }
    public SettingsPage changeSurnameTest(String NewSurname, boolean correctness){
        SettingsPage pp = new SettingsPage(driver);
        pp.openChangingPersonalDataSpace();
        pp.changeSurname(NewSurname);
        pp.saveChanges();
        boolean sucsess = !(pp.errorNotify());
        pp.openChangingPersonalDataSpace();
        if(sucsess & correctness) pp.checkCorrectSurname(NewSurname);
        else pp.checkIncorrectSurname(NewSurname);
        return pp;
    }
    public SettingsPage changeBirthdayDateTest(Integer date, Integer mounth, Integer year,boolean Correctness){
        SettingsPage pp = new SettingsPage(driver);
        pp.openChangingPersonalDataSpace();
        pp.changeBirthdayDate(date);
        pp.changeBirthdayMounth(mounth);
        pp.changeBirthdayYear(year);
        pp.saveChanges();
        pp.openChangingPersonalDataSpace();
        if(Correctness){
            pp.checkCorrectBirthdayDate(date);
            pp.checkCorrectBirthdayMounth(mounth);
            pp.checkCorrectBirthdayYear(year);
        }
        else{
            pp.checkIncorrectBirthdayDate(date);
            pp.checkIncorrectBirthdayMounth(mounth);
            pp.checkIncorrectBirthdayYear(year);
        }
        return pp;
    }
    public SettingsPage changeGenderTest(){
        SettingsPage pp = new SettingsPage(driver);
        pp.openChangingPersonalDataSpace();
        String LOCATOR = pp.changeGender();
        pp.saveChanges();
        pp.openChangingPersonalDataSpace();
        pp.checkGenderChanged(LOCATOR);
        return pp;
    }
}
