package tests.day015_softassert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;

public class C01_Softassert {
    @Test(groups = {"minireg1,minireg2"})
    public void test01() {
        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        // amazon anasayfaya gittiginizi dogrulayin
        SoftAssert softAssert=new SoftAssert();
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedKelime="amazon";
        softAssert.assertTrue(actualUrl.contains(expectedKelime));

        // Nutella aratin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarinin nutella icerdigini dogrulayin

        String aramaSonucYazisi=amazonPage.aramaSonucElementi.getText();

        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"));

        // Java aratin
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java" +Keys.ENTER);
        System.out.println(amazonPage.aramaSonucElementi.getText());

        // arama sonuclarinin 1000'den fazla oldugunu dogrulayin
        String [] sonucYaziArr=aramaSonucYazisi.split(" ");
        System.out.println(Arrays.toString(sonucYaziArr));
        String sonucYazisiStr=sonucYaziArr[3];
        sonucYazisiStr= sonucYazisiStr.replaceAll("\\W","");
        System.out.println(sonucYazisiStr);
        int sonucYaziInt=Integer.parseInt(sonucYazisiStr);
        softAssert.assertTrue(sonucYaziInt>1000);

        ReusableMethods.bekle(5);

        softAssert.assertAll();
        Driver.closeDriver();

    }
}
