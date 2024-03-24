package tests.day03_JunitFramework;

import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_Assertion {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown() throws InterruptedException {

        driver.quit();
    }

    @Test
    public void test01(){
        // 1- test otomasyonu anasayfaya gidip
        //    testotomasyonu sayfasina gidildigini test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();


        Assert.assertTrue("testotomasyonu anasayfaya gidilemedi",actualUrl.contains(expectedUrlIcerik));

    }

    @Test
    public void test02(){
        // 2- arama kutusuna phone yazip aratin
        //    arama sonucunda urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size() > 0);
    }

    @Test
    public void test03(){
        // 3- ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]"))
                .click();
        //    urun aciklama bolumunde case sensitive olmadan phone kelimesi gectigini test edin

        WebElement urunAciklamaElementi = driver.findElement(By.xpath("//*[@class='product-short-desc  my-2']"));

        String expectedUrunIcerik = "phone";
        String aciklamaKucukHarf = urunAciklamaElementi.getText().toLowerCase();

        Assert.assertTrue("urun aciklamasinda phone kelimesi gecmiyor",aciklamaKucukHarf.contains(expectedUrunIcerik));
    }

}


















