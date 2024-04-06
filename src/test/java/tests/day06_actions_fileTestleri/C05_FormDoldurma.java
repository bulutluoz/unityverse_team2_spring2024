package tests.day06_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FormDoldurma extends TestBase {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(firstnameKutusu)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Yildiz")
                .sendKeys(Keys.TAB)
                .sendKeys("aliYildiz@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();

        // kaydol tusuna basalim
        driver.findElement(By.id("btn-submit-form"))
                .click();
        ReusableMethods.bekle(1);
        //5- Kaydin olusturuldugunu test edin
        //   account linkine basinca
        //   girdigimiz isimle login olundugu gorunuyor

        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        WebElement isimElementi = driver.findElement(By.xpath("(//h3)[1]"));

        String expectedIsim = "ali";
        String actualIsim = isimElementi.getText();

        Assert.assertEquals(expectedIsim,actualIsim);

    }
}
