package tests.day09_javascriptExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_JavascriptExecutor extends TestBase {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // javascriptExecutor kullanarak Men Fashion'a click yapin
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement menFashionLinki = driver.findElement(By.xpath("(//*[@class='has-sub'])[2]"));

        ReusableMethods.bekle(2);

        // jse.executeScript("arguments[0].click();",menFashionLinki);

        menFashionLinki.click();


        // acilan sayfada "chat with experts" butonuna basin

        WebElement chatWithExperts = driver.findElement(By.className("button-block"));
        ReusableMethods.bekle(2);

        jse.executeScript("arguments[0].scrollIntoView();",chatWithExperts);

        ReusableMethods.bekle(2);

        chatWithExperts.click();

        ReusableMethods.bekle(2);

        jse.executeScript("window.alert('Merhaba, bu bir JavaScript alertidir!');");

        ReusableMethods.bekle(4);

    }

}
