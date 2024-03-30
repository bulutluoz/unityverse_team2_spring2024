package tests.day04_dropdownMenu_JsAlerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfterClass;

public class C05_JsAlerts extends TestBase_BeforeAfterClass {


    @Test
    public void jsAlertTesti(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 1.alert'e tiklayin

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertYazi = "I am a JS Alert";

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }

    @Test
    public void confirmTest(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();
        //	- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        driver.switchTo().alert().dismiss();

        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']"))
                                            .getText();
        String expectedSonucYazisi = "You clicked: Cancel";

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    @Test
    public void promptTest(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();
        //	- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim

        String expectedYaziIcerik = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']"))
                                            .getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedYaziIcerik));
    }
}
