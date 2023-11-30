package tests.day015_softassert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WisequarterPage;
import utilities.Driver;

import java.util.Set;

public class C03_PozitifLoginTest {
    @Test
    public void test01() {
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
        wisequarterPage.passwordButton.sendKeys("Hedef2023.");
        wisequarterPage.logInButton.click();
        Assert.assertTrue(wisequarterPage.wellcomeBackYaziElement.isDisplayed());


    }

}
