package tests.day019_crossSiraliCalistirma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C01_AmazonCrossCalistirmaTesti extends TestBaseCross {
    @Test
    public void test01() {
        // amazona git
        driver.get("https://www.amazon.com");
        // arama kutusuna nutella yaz ve arat
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella" + Keys.ENTER);
        // arama sonuclarin nutella icerdigini test et
        WebElement sonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucElementi=sonucElementi.getText();
        String expectedKelime="Nutella";
        Assert.assertTrue(actualSonucElementi.contains(expectedKelime));
    }
    
}
