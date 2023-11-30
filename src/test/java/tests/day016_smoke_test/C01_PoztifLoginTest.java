package tests.day016_smoke_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WisequarterPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class C01_PoztifLoginTest {
    @Test
    public void test01() {
        //www.wisequarter.com adresine gidin

        Driver.getDriver().get(ConfigReader.getProperty("wq_Url"));
        String birinciSayfaWHD=Driver.getDriver().getWindowHandle();
        WisequarterPage wisequarterPage=new WisequarterPage();
        wisequarterPage.LMSButon.click();
        Set<String> tumWHD=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
             ) {
            if(!each.equals(birinciSayfaWHD)) {
                ikinciSayfaWHD=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);
        // System.out.println(Driver.getDriver().getTitle());

        wisequarterPage.usernameButton.sendKeys(ConfigReader.getProperty("wq_dogru_email"));
        wisequarterPage.passwordButton.sendKeys(ConfigReader.getProperty("wq_dogru_password"));
        wisequarterPage.logInButton.click();
        Assert.assertTrue(wisequarterPage.wellcomeBackYaziElement.isDisplayed());
        Driver.getDriver().quit();

    }
}
