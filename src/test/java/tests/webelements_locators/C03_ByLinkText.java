package tests.webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText {

    public static void main(String[] args) {

        // ilgili ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // arama kutusunun altindaki kategorilerden Shoes kategory'sini tiklayin

        driver.findElement(By.partialLinkText("oes")) // By.linkText("Shoes")
              .click();

        // acilan sayfada urun bulundugunu test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String aramaSonucYazisi = aramaSonucElementi.getText(); // 6 Products Found
        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // 6

        int sonucSayisi = Integer.parseInt(aramaSonucYazisi);

        if (sonucSayisi > 0){
            System.out.println("Arama sonuc testi PASSED");
        }else System.out.println("Arama sonuc testi FAILED");

        // sayfayi kapatin

        driver.quit();
    }
}
