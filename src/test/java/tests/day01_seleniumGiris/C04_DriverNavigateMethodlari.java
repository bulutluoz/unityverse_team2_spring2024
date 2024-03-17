package tests.day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(2000);

        driver.navigate().to("https://www.walmart.com");

        Thread.sleep(2000);

        // eski sayfadaki testotomasyonu sayfasina donun

        driver.navigate().back();

        Thread.sleep(2000);

        // bir daha walmart'a gidin

        driver.navigate().forward();

        Thread.sleep(2000);
        driver.quit();
    }
}
