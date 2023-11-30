package tests.day019_crossSiraliCalistirma;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C02_WisequarterCrossCalistirma extends TestBaseCross {
    @Test
    public void test01() {
        //wisequarter adresine git
        driver.get("https://www.wisequarter.com");
        // adrese gittigini test et
        String actualUrl= driver.getCurrentUrl();
        String expectedKelime="wisequarter";
        System.out.println(driver.getTitle());
        Assert.assertTrue(actualUrl.contains(expectedKelime));
    }
}
