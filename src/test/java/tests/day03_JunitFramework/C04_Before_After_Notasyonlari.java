package tests.day03_JunitFramework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Before_After_Notasyonlari {

    /*
        Eger her test method'un once MUTLAKA calismasi gereken bir method varsa
        o method'u @Before notasyonu ile isaretleyebiliriz

        Eger her test method'un sonra MUTLAKA calismasi gereken bir method varsa
        o method'u @After notasyonu ile isaretleyebiliriz
     */


    WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void testotomasyonTesti() throws InterruptedException {
        // 1- testotomasyonu anasayfaya gidip, sayfaya gidildigini test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "otomasyon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("test otomasyonu testi PASSED");
        }else System.out.println("test otomasyonu testi FAILED");
    }

    @Test
    public void unityverseTesti() throws InterruptedException {
        driver.get("https://www.unityverseacademy.com");

        String expectedUrlIcerik = "unity";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("unityverse testi PASSED");
        }else System.out.println("unityverse testi FAILED");
    }

    @Test
    public void youtubeTesti() throws InterruptedException {
        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("YouTube testi PASSED");
        }else System.out.println("YouTube testi FAILED");
    }
}
