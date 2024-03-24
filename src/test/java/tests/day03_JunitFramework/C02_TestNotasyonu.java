package tests.day03_JunitFramework;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TestNotasyonu {

    // 3 farkli method olusturarak, asagidaki testleri yapin
    // test method'lari ayri ayri veya bir butun olarak calistirilabilmelidir
    // 1- testotomasyonu anasayfaya gidip, sayfaya gidildigini test edin
    // 2- unityverseacademy.com anasayfaya gidip, sayfaya gidildigini test edin
    // 3- youtube anasayfaya gidip, sayfaya gidildigini test edin

    /*
        JUnit'deki @Test notasyonu sayesinde
        istedigimiz her method, bagimsiz calisabilen bir test method'u haline donusur

        JUnit'de test method'larinin hangi sira ile calisacagini
        ONGOREMEYIZ ve KONTROL EDEMEYIZ

        eger sira ile calistirmak istediginiz test method'lari varsa
        isimlerini test01() , test02(), test03() .... kullanabilirsiniz
     */


    @Test
    public void testotomasyonTesti() throws InterruptedException {
        // 1- testotomasyonu anasayfaya gidip, sayfaya gidildigini test edin

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "otomasyon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("test otomasyonu testi PASSED");
        }else System.out.println("test otomasyonu testi FAILED");

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void unityverseTesti() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.unityverseacademy.com");

        String expectedUrlIcerik = "unity";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("unityverse testi PASSED");
        }else System.out.println("unityverse testi FAILED");

        Thread.sleep(2000);
        driver.quit();


    }

    @Test
    public void youtubeTesti() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("YouTube testi PASSED");
        }else System.out.println("YouTube testi FAILED");

        Thread.sleep(2000);
        driver.quit();


    }

}
