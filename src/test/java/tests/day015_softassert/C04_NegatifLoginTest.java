package tests.day015_softassert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WisequarterPage;
import utilities.Driver;

import java.util.Set;

public class C04_NegatifLoginTest {
    // 3ayri test metodu olusturun
    // 1. test te dogru email-yanlis sifre
    // 2. test te yanlis email-dogru sifre
    // 3. test te yanlis sifre-yanlis email ile giris yapilamdigini test edin


    @Test(groups = {"minireg1","minireg2","smoke"})
    public void dogruEmailYanlisPassword() {
        // "https://wisequarter.com" adresine gidin
        Driver.getDriver().get("https://www.wisequarter.com");

        //  LMS se tiklayin
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();
        String birinciSayfaWHD=Driver.getDriver().getWindowHandle();

        // dogru email ve dogru sifre  ile giris yapabildiginizi test edin
        Set<String> tumWHD=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
        ) {
            if(!each.equals(birinciSayfaWHD)) {
                ikinciSayfaWHD=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);

        wisequarterPage.usernameButton.sendKeys("ikavakli37@hotmail.com");
        wisequarterPage.passwordButton.sendKeys("hedef2023.");
        wisequarterPage.logInButton.click();
        Assert.assertTrue(wisequarterPage.gecersizYaziElemeti.isDisplayed());
        Driver.closeDriver();

    }


    @Test(groups = "minireg1")
    public void YanlisEmailDogruPassword() {
        // "https://wisequarter.com" adresine gidin
        Driver.getDriver().get("https://www.wisequarter.com");

        //  LMS se tiklayin
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();
        String birinciSayfaWHD=Driver.getDriver().getWindowHandle();

        // dogru email ve dogru sifre  ile giris yapabildiginizi test edin
        Set<String> tumWHD=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
        ) {
            if(!each.equals(birinciSayfaWHD)) {
                ikinciSayfaWHD=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);

        wisequarterPage.usernameButton.sendKeys("ikavakli37@gmail.com");
        wisequarterPage.passwordButton.sendKeys("Hedef2023.");
        wisequarterPage.logInButton.click();
        Assert.assertTrue(wisequarterPage.gecersizYaziElemeti.isDisplayed());
        Driver.closeDriver();


    }


    @Test(groups = {"minireg1","smoke"})
    public void yanlisEmailYanlisPassword() {
        // "https://wisequarter.com" adresine gidin
        Driver.getDriver().get("https://www.wisequarter.com");

        //  LMS se tiklayin
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();
        String birinciSayfaWHD=Driver.getDriver().getWindowHandle();

        // dogru email ve dogru sifre  ile giris yapabildiginizi test edin
        Set<String> tumWHD=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
        ) {
            if(!each.equals(birinciSayfaWHD)) {
                ikinciSayfaWHD=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);

        wisequarterPage.usernameButton.sendKeys("ikavakli37@gmail.com");
        wisequarterPage.passwordButton.sendKeys("hedef2023.");
        wisequarterPage.logInButton.click();
        Assert.assertTrue(wisequarterPage.gecersizYaziElemeti.isDisplayed());
        Driver.closeDriver();
    }

}
