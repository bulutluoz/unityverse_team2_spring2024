package tests.day05_iframe_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_WindowDegistirme extends TestBase {

    @Test
    public void test01(){
        //● testotomasyonu anasayfa adresine gidin.
        driver.get("https://www.testotomasyonu.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String toWhd = driver.getWindowHandle();
        //● Sayfa title’nin “Otomasyon” icerdigini test edin
        String expectedTitleIcerik = "Otomasyon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● Yeni bir tab olusturup, acilan tab’da unityverseacademy.com adresine gidin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.unityverseacademy.com");

        //● Sayfa title’nin “unityverse” icerdigini test edin

        expectedTitleIcerik = "UNITYVERSE";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin

        expectedTitleIcerik = "Walmart";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));


        //● Ilk acilan window’a donun ve testotomasyonu sayfasina dondugunuzu test edin

        driver.switchTo().window(toWhd);

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(3);

    }

}
