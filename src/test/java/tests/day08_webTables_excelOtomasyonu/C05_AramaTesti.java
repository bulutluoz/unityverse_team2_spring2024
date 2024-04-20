package tests.day08_webTables_excelOtomasyonu;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_AramaTesti extends TestBase {

    @Test
    public void phoneAramaTesti() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='product-count-text']"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
        ReusableMethods.bekle(1);
        // arama sonucunda urun bulunduguna dair
        // sayfanin screenshot'ini alin

        // 1.adim TakesScreenShot objesi olusturun
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.screenShoot'i kaydedecegimiz File olusturun
        File tumSayfaScreenshot = new File("target/Screenshoots/tumSayfaScreenshot.png");

        // 3.screenshot'i alip gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4. gecici dosyayi asil kaydetmek istedigimiz dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        ReusableMethods.bekle(2);

    }
}
