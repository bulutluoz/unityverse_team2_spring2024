package tests.day03_JunitFramework;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_OrtakKodlariAyriMethodYapma {

    WebDriver driver;

    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void testotomasyonTesti() throws InterruptedException {
        // 1- testotomasyonu anasayfaya gidip, sayfaya gidildigini test edin
        setUp();
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "otomasyon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("test otomasyonu testi PASSED");
        }else System.out.println("test otomasyonu testi FAILED");
        teardown();
    }

    @Test
    public void unityverseTesti() throws InterruptedException {
       setUp();

        driver.get("https://www.unityverseacademy.com");

        String expectedUrlIcerik = "unity";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("unityverse testi PASSED");
        }else System.out.println("unityverse testi FAILED");

        teardown();
    }

    @Test
    public void youtubeTesti() throws InterruptedException {
        setUp();

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("YouTube testi PASSED");
        }else System.out.println("YouTube testi FAILED");

        teardown();
    }
}
