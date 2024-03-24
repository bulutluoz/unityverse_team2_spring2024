package tests.day03_JunitFramework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Assertions {

    //2)    https://www.bestbuy.com/ Adresine gidin
    //      farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void urlTest(){
        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
        /*
            Eger assertEquals kullanirsak
            failed oldugunda asagidaki gibi detay bilgisi verir
            org.junit.ComparisonFailure:
                Expected :https://www.bestbuy.com
                Actual   :https://www.bestbuy.com/
         */

        Assert.assertTrue(expectedUrl.equals(actualUrl));
        // java.lang.AssertionError


    }

    @Test
    public void titleTest(){
        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String unExpectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertTrue( ! actualTitle.contains(unExpectedTitleIcerik)  );

        Assert.assertFalse( actualTitle.contains(unExpectedTitleIcerik)  );

    }

    @Test
    public void logoTest(){
        //		○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void francaisLinkTesti(){
        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francaisLinkElementi = driver.findElement(By.xpath("//button[@lang='fr']"));

        Assert.assertTrue(francaisLinkElementi.isDisplayed());

    }

}
