package tests.day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTestOtomasyonu {

    public static void main(String[] args) throws InterruptedException {

        // https://www.testotomasyonu.com adresine gidin
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testotomasyonu.com");
        // sayfa basliginin "Test Otomasyonu - Test Otomasyonu" oldugunu test edin

        String expectedTitle = "Test Otomasyonu - Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
        }

        // sayfa url'inin testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi FAILED");
        }


        // sayfa kaynak kodlarinda "otomasyon" kelimesinin gectigini test edin

        String expectedSayfaKaynakIcerigi = "otomasyon";
        String actualSayfaKaynagi = driver.getPageSource();

        if (actualSayfaKaynagi.contains(expectedSayfaKaynakIcerigi)){
            System.out.println("Sayfa kaynagi testi PASSED");
        }else{
            System.out.println("Sayfa kaynagi testi FAILED");
        }

        // sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();


    }
}
