package tests.day05_iframe_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C09_WindowDegistirme extends TestBase {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        // dell bilgisayar iFrame icinde oldugundan once iFrame gecis yapalim
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframe);

        WebElement dellBilgElementi = driver.findElement(By.id("dell-core"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellBilgElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.

        dellBilgElementi.click();

        // yeni window acildigindan, o window'a gecis yapmaliyiz

        ReusableMethods.windowDegistir(driver,"https://testotomasyonu.com/product/58");

        String  expectedUrunFiyati = "$399.00";
        WebElement urunFiyatElementi  = driver.findElement(By.id("priceproduct"));
        String actualUrunFiyati = urunFiyatElementi.getText();

        Assert.assertEquals(expectedUrunFiyati,actualUrunFiyati);


        //5- Ilk sayfaya donun ve Sale Up To 50% yazisinin gorunur olduğunu test edin

        ReusableMethods.windowDegistir(driver,"https://testotomasyonu.com/discount");

        WebElement saleUpElementi = driver.findElement(By.xpath("//h2[text()='Sale Up To 50%']"));

        Assert.assertTrue(saleUpElementi.isDisplayed());

        //6- Sayfayi kapatin

        ReusableMethods.bekle(3);
    }
}
