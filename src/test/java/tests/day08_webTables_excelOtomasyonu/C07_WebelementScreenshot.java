package tests.day08_webTables_excelOtomasyonu;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C07_WebelementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {
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
        // bulunan urun sayisi yazisinin screenshot'ini alin

        // 1- screenshot almak istediginiz webelementi locate edin

        // 2- Screenshot'i kaydedecegimiz file'i olusturun
        File webelementScreenshot = new File("target/Screenshoots/webelementScreenshot.png");

        // 3- webelementi kullanarak screenshot alip, gecici dosyaya kaydedin
        File geciciDosya = aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, asil dosyaya kopyalayin
        FileUtils.copyFile(geciciDosya,webelementScreenshot);


    }
}
