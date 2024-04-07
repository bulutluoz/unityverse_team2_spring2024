package tests.day07_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FacebookHtmlCookies extends TestBase {

    @Test
    public void test01(){

        // facebook anasayfaya gidin
        driver.get("https://www.facebook.com");

        // cookies cikarsa kabul edin
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//*[@title='Allow all cookies']"))
                .click();


        // facebook sayfasinda oldugunuzu test edin
        String expectedurlIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedurlIcerik));

        ReusableMethods.bekle(2);

    }
}
