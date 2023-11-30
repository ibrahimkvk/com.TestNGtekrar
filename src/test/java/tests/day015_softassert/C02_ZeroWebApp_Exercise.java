package tests.day015_softassert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C02_ZeroWebApp_Exercise {
    @Test(groups = {"minireg1","minireg2"})
    public void test01() {
        // Yeni bir Class Olusturun : C03_SoftAssert

        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage=new ZeroWebAppPage();
        zeroWebAppPage.sigInButonu.click();

        //3. Login kutusuna “username” yazin
        zeroWebAppPage.userButonu.sendKeys("username");

        //4. Password kutusuna “password” yazin
        zeroWebAppPage.userPassword.sendKeys("password");

        //5. Sign in tusuna basin
        zeroWebAppPage.submitButonu.click();

        Driver.getDriver().navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        zeroWebAppPage.onlineBankingButonu.click();
        zeroWebAppPage.payBillLinkButtonu.click();

        //7. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.pfcButonu.click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroWebAppPage.pcCurrencyButonu);
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualKelime=select.getFirstSelectedOption().getText();
        String expectedkelime="Eurozone (euro)";
        softAssert.assertEquals(actualKelime,expectedkelime);

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> optionElemanListesi=select.getOptions();
        List<String> optionElemanListesiStr=new ArrayList<>();
        for (WebElement each:optionElemanListesi
             ) {
            optionElemanListesiStr.add(each.getText());
        }
        String [] arr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)", "Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedOptionListesi= Arrays.asList(arr);
        Collections.sort(optionElemanListesiStr);
        Collections.sort(expectedOptionListesi);
        softAssert.assertEquals(optionElemanListesiStr,expectedOptionListesi);

        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        
        ReusableMethods.bekle(5);
        Driver.closeDriver();
    }
}
