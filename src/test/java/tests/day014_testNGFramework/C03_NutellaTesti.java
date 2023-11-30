package tests.day014_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_NutellaTesti {

    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement aramaSonucElementi=Driver.getDriver().findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String actualKelime=aramaSonucElementi.getText();
        String expectedKelime="Nutella";
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        Driver.closeDriver();

    }
}
