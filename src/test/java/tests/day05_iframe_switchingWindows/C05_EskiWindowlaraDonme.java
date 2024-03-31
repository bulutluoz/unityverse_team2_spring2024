package tests.day05_iframe_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_EskiWindowlaraDonme extends TestBase {

    @Test
    public void test01(){

        // testOtomasyonu anasayfaya gidin
        // url ve windowHandleDegerini yazdirin
        driver.get("https://www.testotomasyonu.com");

        System.out.println("testotomasyonu url : " + driver.getCurrentUrl()); // testotomasyonu url : https://www.testotomasyonu.com/
        System.out.println("testotomasyonu WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : DAEE8175896EF93B170D3338F7A13392
        String testOtomasyonuWHD = driver.getWindowHandle();
        ReusableMethods.bekle(2);


        // yeni bir tab olusturup, yeni tab'da
        driver.switchTo().newWindow(WindowType.TAB);
        // Men Fashion linkine tiklayin
        // url ve windowHandleDegerini yazdirin
        driver.get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//li[@class='has-sub'])[2]"))
                .click();

        System.out.println("Men Fashion url : " + driver.getCurrentUrl()); // testotomasyonu url : https://www.testotomasyonu.com/category/1/products
        System.out.println("Men Fashion WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : B65181F4F5A3429B3B2CBA68DB9F2D98
        String menFashionWHD = driver.getWindowHandle();

        ReusableMethods.bekle(2);

        // yeni bir window olusturup, yeni window'da
        // unityverse anasayfaya gidin
        // url ve windowHandleDegerini yazdirin

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.unityverseacademy.com");
        System.out.println("unityverse url : " + driver.getCurrentUrl()); // testotomasyonu url : https://unityverseacademy.com/
        System.out.println("unityverse WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : 9D4D489F3E514C040DD80A7EE9F7E259

        ReusableMethods.bekle(2);

        // Yeniden testotomasyonu anasayfasinin acik oldugu window'a donun
        // url'in testotomasyonu icerdigini test edin

        driver.switchTo().window(testOtomasyonuWHD);
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);
        // Men Fashion'in acik oldugu window'a gecis yapin
        // title'in Men Fashion icerdigini test edin

        driver.switchTo().window(menFashionWHD);
        String expectedTitleIcerik = "Men Fashion";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        ReusableMethods.bekle(2);

    }
}
