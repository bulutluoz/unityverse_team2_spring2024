package tests.day05_iframe_switchingWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_YeniWindowKullanimi extends TestBase {

    @Test
    public void test01(){

        // testOtomasyonu anasayfaya gidin
        // url ve windowHandleDegerini yazdirin
        driver.get("https://www.testotomasyonu.com");

        System.out.println("testotomasyonu url : " + driver.getCurrentUrl()); // testotomasyonu url : https://www.testotomasyonu.com/
        System.out.println("testotomasyonu WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : DAEE8175896EF93B170D3338F7A13392

        ReusableMethods.bekle(5);


        // yeni bir tab olusturup, yeni tab'da
        driver.switchTo().newWindow(WindowType.TAB);
        // Men Fashion linkine tiklayin
        // url ve windowHandleDegerini yazdirin
        driver.get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//li[@class='has-sub'])[2]"))
                .click();

        System.out.println("Men Fashion url : " + driver.getCurrentUrl()); // testotomasyonu url : https://www.testotomasyonu.com/category/1/products
        System.out.println("Men Fashion WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : B65181F4F5A3429B3B2CBA68DB9F2D98

        ReusableMethods.bekle(5);

        // yeni bir window olusturup, yeni window'da
        // unityverse anasayfaya gidin
        // url ve windowHandleDegerini yazdirin

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.unityverseacademy.com");
        System.out.println("unityverse url : " + driver.getCurrentUrl()); // testotomasyonu url : https://unityverseacademy.com/
        System.out.println("unityverse WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : 9D4D489F3E514C040DD80A7EE9F7E259

        ReusableMethods.bekle(5);
    }
}
