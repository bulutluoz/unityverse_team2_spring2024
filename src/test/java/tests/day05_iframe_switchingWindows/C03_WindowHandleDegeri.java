package tests.day05_iframe_switchingWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_WindowHandleDegeri extends TestBase {

    @Test
    public void test01(){

        // testOtomasyonu anasayfaya gidin
        // url ve windowHandleDegerini yazdirin
        driver.get("https://www.testotomasyonu.com");

        System.out.println("testotomasyonu url : " + driver.getCurrentUrl()); // testotomasyonu url : https://www.testotomasyonu.com/
        System.out.println("testotomasyonu WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : 23E47D283573A09D4D9972F84AC0AE89

        // Men Fashion linkine tiklayin
        // url ve windowHandleDegerini yazdirin

        driver.findElement(By.xpath("(//li[@class='has-sub'])[2]"))
                .click();

        System.out.println("Men Fashion url : " + driver.getCurrentUrl()); // testotomasyonu url : https://www.testotomasyonu.com/category/1/products
        System.out.println("Men Fashion WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : 23E47D283573A09D4D9972F84AC0AE89


        // unityverse anasayfaya gidin
        // url ve windowHandleDegerini yazdirin

        driver.get("https://www.unityverseacademy.com");
        System.out.println("unityverse url : " + driver.getCurrentUrl()); // testotomasyonu url : https://unityverseacademy.com/
        System.out.println("unityverse WHD : " + driver.getWindowHandle()); // testotomasyonu WHD : 23E47D283573A09D4D9972F84AC0AE89


    }
}
