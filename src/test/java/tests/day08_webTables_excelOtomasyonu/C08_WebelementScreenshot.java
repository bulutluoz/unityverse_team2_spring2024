package tests.day08_webTables_excelOtomasyonu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C08_WebelementScreenshot extends TestBase {

    @Test
    public void test01(){
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='product-count-text']"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
        ReusableMethods.bekle(1);

        // arama sonucunda urun bulunduguna dair
        // bulunan urun sayisi yazisinin screenshot'ini alin

        ReusableMethods.webelementScreenshot(aramaSonucElementi,"aramaTesti");
    }
}
