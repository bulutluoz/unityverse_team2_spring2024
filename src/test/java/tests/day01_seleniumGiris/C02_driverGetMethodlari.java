package tests.day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_driverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/

        System.out.println(driver.getWindowHandle());
        // 70D734CFCE622F54221448B49A2FFBD4
        // B4C52493E577C3540B2E78F71C5CAA09

        System.out.println(driver.getWindowHandles());
        // [B4C52493E577C3540B2E78F71C5CAA09]

        System.out.println(driver.getPageSource());


        Thread.sleep(3000);
        driver.quit();
    }
}
