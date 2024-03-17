package tests.day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_FacebookTesti {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://www.facebook.com");
        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("facebook Title testi PASSED");
        }else{
            System.out.println("facebook Title testi FAILED");
            System.out.println("Actual title : " + actualTitle);
        }

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.

        String expectedUrlIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("facebook Url testi PASSED");
        }else {
            System.out.println("facebook Url testi FAILED");
            System.out.println("actual url : " + actualUrl);
        }

        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");
        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.

        String expectedTitleIcerik = "Walmart.com";
        actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Walmart title testi PASSED");
        } else {
            System.out.println("Walmart title testi FAILED");
        }

        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        // Sayfayi yenileyin
        driver.navigate().refresh();
        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //Browser’i  kapatin
        driver.quit();
    }
}
