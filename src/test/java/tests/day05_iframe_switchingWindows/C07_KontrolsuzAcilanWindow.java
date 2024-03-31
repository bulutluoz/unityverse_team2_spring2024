package tests.day05_iframe_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C07_KontrolsuzAcilanWindow extends TestBase {

    /*
        Coklu window kullaniminda bilmemiz gerekenler
        1- driver bir window actiginda, tiklanan linklerin veya
           yazilan yeni url'lerin ayni window'da acilmasini bekler
        2- Eger yeni bir tab/window olusturmak ve o tab/window'a gecmek istersek
           driver.switchTo().newWindow() kullaniriz
           bu komutla acacagimiz yeni windowlara, driver otomatik olarak gecer
           bizim ekstra bir islem yapmamiza gerek kalmaz
        3- Eger bir test calisirken, birden fazla window aciliyorsa
           ve testin ilerleyen kisimlarinda onceden acilan window'lara donmemiz gerekiyorsa
           acilan window'larin windowHandle degerlerini kaydederiz
           gecmek istedigimiz window'un  windowHandle degerini biliyorsak
           driver.switchTo(istenen Window'un whd) ile gecis yapabiliriz
        4- Bazen test sirasinda tiklanan bir link
           biz  driver.switchTo().newWindow() DEMEDEN yeni bir window acabilir

           bu durumda driver otomatik olarak yeni window'a gecmez
           bizim java kullanarak yeni window'un windowHandle degerini bulmamiz
           ve driver'i o window'a gecirmemiz gerekir
     */

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        String ilkWindowWhd = driver.getWindowHandle();

        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframe);

        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assert.assertTrue(electronicsYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        WebElement dellBilgElementi = driver.findElement(By.id("dell-core"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellBilgElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.

        System.out.println("Click'den once driver'in oldugu window : "+ driver.getWindowHandle());
        // B4BABEE7DC4B438CCE36F662CE06C0E0

        dellBilgElementi.click();

        System.out.println("driver'in actigi tum window'lari whd'leri : "+driver.getWindowHandles());
        // [B4BABEE7DC4B438CCE36F662CE06C0E0, E67494F7D61A1BA48D0AA8A198E4B58F]

        /*
            burada getWindowHandles() method'u bize 1.window ve 2.window'un WHD'lerini verir

            biz bir loop ile bu iki WHD'ne gecis yapalim

            gectigimiz window'un url'i
            gecmek istedigimiz window'un url'ine esit oldugunda duralim

         */

        String gecmekIstedigimizWindowUrl = "https://testotomasyonu.com/product/58";

        Set<String> tumSayfaWHDleri = driver.getWindowHandles();


        for (String  eachWHD : tumSayfaWHDleri
             ) {

            driver.switchTo().window(eachWHD);
            String gecilenWindowUrl = driver.getCurrentUrl();
            System.out.println(gecilenWindowUrl);

            if (gecmekIstedigimizWindowUrl.equals(gecilenWindowUrl)){
                break;
            }

        }


        String  expectedUrunFiyati = "$399.00";
        WebElement urunFiyatElementi  = driver.findElement(By.id("priceproduct"));
        String actualUrunFiyati = urunFiyatElementi.getText();

        Assert.assertEquals(expectedUrunFiyati,actualUrunFiyati);


        //5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin

        // artik 2.window'a gectigimiz icin
        // ilk window'a donebilmek istiyorsak
        // ilk sayfa window handle degerini kullanmaliyiz

        driver.switchTo().window(ilkWindowWhd);

        // fahion yazisi iframe icinde oldugundan, once iframe'e gecelim

        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//*[text()='Fashion']"));

        Assert.assertTrue(fashionYaziElementi.isDisplayed());

        //6- Sayfayi kapatin
        ReusableMethods.bekle(2);
    }
}















