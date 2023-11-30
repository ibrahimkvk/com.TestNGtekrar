package tests.day016_smoke_test;

import org.testng.annotations.Test;
import pages.WisequarterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SwicthingWindow {
    @Test
    public void test01() {
        // "https://www.wisequarter.com" adresine gidin
        // LMS tusuna basin
        // yeni sayfaya gecisi Switcing metodunu kullanarak yapin ve giris islemlerini gerceklestirin
        Driver.getDriver().get(ConfigReader.getProperty("wq_Url"));
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();


        //asagidaki method gecilen sayfanin title yazdiktan sonra kolay yoldan  o
        // safyaya gecirten method yani ilk sayfanin WHD al kaydet / ikinci sayfaya
        // gecince bir set olustur bu sete tum WHD lerini gonder sonra for loop kullan ve
        // buradan ikinci sayfanin WHD bul sonra switch kullan gec bu islemleri yapmaya gerek yok

        ReusableMethods.switchToWindow("Wisequarter LMS: Log in to the site");

        wisequarterPage.usernameButton.sendKeys(ConfigReader.getProperty("wq_dogru_email"));
        wisequarterPage.passwordButton.sendKeys(ConfigReader.getProperty("wq_dogru_password"));
        wisequarterPage.logInButton.click();
        Driver.closeDriver();
    }
}
