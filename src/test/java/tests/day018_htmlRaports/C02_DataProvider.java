package tests.day018_htmlRaports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] aranacakKelime() {
        Object[][] aranacakKelimelerDizisi={{"dell"},{"jbl"},{"philips"},{"java"}};
        return  aranacakKelimelerDizisi;
    }

    @Test(dataProvider ="aranacakKelime" )
    public void aranacakKelimeler(String aranacakKelime) {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);
        String actualSonucElementi=amazonPage.aramaSonucElementi.getText();
        String expectedKelime=aranacakKelime;
        Assert.assertTrue(actualSonucElementi.contains(expectedKelime));

    }
}
