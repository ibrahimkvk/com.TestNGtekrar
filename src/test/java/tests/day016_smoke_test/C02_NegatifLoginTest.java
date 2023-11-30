package tests.day016_smoke_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WisequarterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Set;

public class C02_NegatifLoginTest extends TestBaseRapor {
    // 3ayri test metodu olusturun
    // 1. test te dogru email-yanlis sifre
    // 2. test te yanlis email-dogru sifre
    // 3. test te yanlis sifre-yanlis email ile giris yapilamdigini test edin



    @Test
    public void dogruEmailYanlisPassword() {
        extentTest=extentReports.createTest("wisequarter login testi","wq dogru email yanlis password ile girilemedigi testi");

        Driver.getDriver().get(ConfigReader.getProperty("wq_Url"));
        extentTest.info("wisequarter adrsine gidildi");

        String birinciSayfaWHD=Driver.getDriver().getWindowHandle();
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();
        extentTest.info("LMS butonuna tiklandi");

        Set<String> tumWHD=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
             ) {
            if(!each.equals(birinciSayfaWHD)) {
                ikinciSayfaWHD=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);
        wisequarterPage.usernameButton.sendKeys(ConfigReader.getProperty("wq_dogru_email"));
        extentTest.info("username  butonuna dogru email girildi");

        wisequarterPage.passwordButton.sendKeys(ConfigReader.getProperty("wq_yanlis_password"));
        extentTest.info("password butonuna yanlis password girildi");

        wisequarterPage.logInButton.click();
        extentTest.info("login butonuna basildi");

        Assert.assertTrue(wisequarterPage.gecersizYaziElemeti.isDisplayed());
        extentTest.info("dogru email fakat yanlis password ile login olmadigi test edildi");
        Driver.closeDriver();
    }

    @Test (groups = "minireg1")
    public void yanlisEmailDogruPassword() {
        extentTest=extentReports.createTest("wisequarter login test","wq yanlis email dogru password ile login olmadiginin testi");

        Driver.getDriver().get(ConfigReader.getProperty("wq_Url"));
        extentTest.info("wisequarter adresine gidildi");

        String birinciSayfaWHD=Driver.getDriver().getWindowHandle();
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();
        extentTest.info("LMS butonuna tiklandi");

        Set<String> tumWHD=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
        ) {
            if(!each.equals(birinciSayfaWHD)) {
                ikinciSayfaWHD=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);
        wisequarterPage.usernameButton.sendKeys(ConfigReader.getProperty("wq_yanlis_email"));
        extentTest.info("username butonuna yanlis email girildi");

        wisequarterPage.passwordButton.sendKeys(ConfigReader.getProperty("wq_dogru_password"));
        extentTest.info("password butonuna dogru email girildi");

        wisequarterPage.logInButton.click();
        extentTest.info("login butonuna tiklandi");

        Assert.assertTrue(wisequarterPage.gecersizYaziElemeti.isDisplayed());
        extentTest.info("wiseqaurter sitesine yanlis email dogru password ile girilemedigi test edildi");

        Driver.closeDriver();
    }

    @Test(groups = {"minireg2","smoke"})
    public void yanlisEmailYanlisPassword() {
        extentTest=extentReports.createTest("wiseqaurter login testi","wiseqaurter adresine yanlis email ve yanlis password ile girilemedigi testi");

        Driver.getDriver().get(ConfigReader.getProperty("wq_Url"));
        extentTest.info("wisequarter adresine gidildi");

        String birinciSayfaWHD=Driver.getDriver().getWindowHandle();
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();
        extentTest.info("LMS butonuna tiklandi");

        Set<String> tumWHD=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
        ) {
            if(!each.equals(birinciSayfaWHD)) {
                ikinciSayfaWHD=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);
        wisequarterPage.usernameButton.sendKeys(ConfigReader.getProperty("wq_yanlis_email"));
        extentTest.info("username butonuna yanlis email girildi");

        wisequarterPage.passwordButton.sendKeys(ConfigReader.getProperty("wq_yanlis_password"));
        extentTest.info("password butonuna yanlis password girildi");

        wisequarterPage.logInButton.click();
        extentTest.info("login butonuna basildi");

        Assert.assertTrue(wisequarterPage.gecersizYaziElemeti.isDisplayed());
        extentTest.info("wiseqaurter adresine yanlis email ve yanlis passowrd ile girilemedigi test edildi");
        Driver.closeDriver();
    }
}
