package tests.webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebdriverKullanimi {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
            Webdriver objesi web sayfalarini otomasyonla calistirmak icin
            bizim elimiz, gozumuz, klavyemiz ve mouse'muz gibidir

            Ancak direk driver objesi ile yapabilecegimiz islem sayisi azdir

            Web sayfasindaki webelementleri driver'a tanimlayabilmemiz
            ve webelemntlerin yerini driver'a tarif etmemiz icin
            Locator'lar kullaniriz.

            Locator'lar Selenium tarafindan olusturulmustur ve 8 adettir

            bunlardan ilk 6 tanesi HTML kodunun belirlenmis sartlari saglamasi
            durumunda kullanilabilir. Son iki tanesi olan
            XPath ve CssSelector ise, her turlu Webelemnti locate edebilmek icin olusturulmustur.

            Locator'i mutlaka websayfasini inceleyerek olusturmaliyiz
            sececegim web elementin locate'i UNIQUE olmalidir

            kullanmak istedigimiz webelemente ait unique locator'i buldugumuzda
            findElement() kullanarak bu webelementi driver'a tanitmis oluruz.
         */

        driver.get("https://www.testotomasyonu.com");
        // arama kutusuna phone yazip arama yapin

        WebElement aramaKutusu  = driver.findElement(By.id("global-search"));

        // arama kutusuna phone yazin ve aratin

        aramaKutusu.sendKeys("phone");
        Thread.sleep(3000);
        aramaKutusu.submit();

        // arama sonucunda bulunan urun sayisini gosteren sonuc yazisini yazdirin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        System.out.println(aramaSonucElementi.getText()); // 4 Products Found

        // arama sonucunda urun bulunabildigini test edin

        String aramaSonucYazisi = aramaSonucElementi.getText(); // 4 Products Found
        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // 4

        int sonucSayisi = Integer.parseInt(aramaSonucYazisi);

        if (sonucSayisi > 0){
            System.out.println("Arama sonuc testi PASSED");
        }else System.out.println("Arama sonuc testi FAILED");


        Thread.sleep(3000);
        driver.quit();
    }
}
