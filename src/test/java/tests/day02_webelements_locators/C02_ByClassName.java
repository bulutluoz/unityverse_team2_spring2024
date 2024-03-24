package tests.day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu ana sayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // arama kutusunun altinda yazili olan kategory'lerde
        // Shoes kategory'si oldugunu test edin

        List<WebElement> kategoriElementleriList  = driver.findElements(By.className("has-sub"));

        // liste webElementlerden olustugu icin
        // icerisinde Shoes olup olmadigini direk aratamayiz
        // bir for loop ile tum elementleri gozden gecirip
        // elementin yazisinin Shoes oldugunu test etmeliyiz

        boolean shoesVarMi = false;

        for (WebElement each : kategoriElementleriList
             ) {
            if (each.getText().equals("Shoes")){
                shoesVarMi = true;
                break;
            }

        }

        if (shoesVarMi) {
            System.out.println("Shoes kategori testi PASSED");
        }else System.out.println("Shoes kategori testi FAILED");


        Thread.sleep(3000);
        driver.quit();
    }
}
