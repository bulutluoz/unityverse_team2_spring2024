package tests.day06_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_SagClick extends TestBase {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        //2- “DGI Drones” uzerinde sag click yapin
        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.contextClick(dgiDronesElementi).perform();
        ReusableMethods.bekle(1);

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(1);
    }
}
