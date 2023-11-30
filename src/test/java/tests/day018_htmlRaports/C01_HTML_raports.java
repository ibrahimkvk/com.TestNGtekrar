package tests.day018_htmlRaports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_raports extends TestBaseRapor {
    @Test
    public void test01()  {

        extentTest=extentReports.createTest("Nutella Testi","Kullanici amazonda nutella aratabilmeli");
        // amazon a gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon anasayfaya gidildi");
 
        // nutella aratalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("arama kutusunda nutella yazilip aratildi");

        // sonuclarin nutella icerdegini test edelim
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        String expectedKelime="Nutella";
        extentTest.info("arama sonuclari kaydedildi");


        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        extentTest.info("arama sonuclarinin nutella icerdigi test edildi");


    }
}
