package tests.day018_htmlRaports;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.WisequarterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class C03_DataProviderIleNegatifLoginTesti {

    @DataProvider
    public static Object[][] negatifloginTesti() {
        Object[][] negatifLoginTesti=
                {{"abc@gmail.com","12345"},{"abcd@gmail.com","123456"},
                 {"abcde@gmail.com","67943"},{"ab@gmail.com","123"},
                 {"klmn@gmail.com","2345"}};
        return negatifLoginTesti;
    }

    @Test(dataProvider = "negatifloginTesti")

    public void negatifLoginTesti(String email,String password) {

        Driver.getDriver().get(ConfigReader.getProperty("wq_Url"));
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();
        ReusableMethods.switchToWindow("Wisequarter LMS: Log in to the site");
        wisequarterPage.usernameButton.sendKeys(email);
        wisequarterPage.passwordButton.sendKeys(password);
        wisequarterPage.logInButton.click();
        Driver.closeDriver();
    }
}
