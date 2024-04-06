package tests.day06_actions_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_FakerClassKullanim extends TestBase {

    @Test
    public void test01(){
        // bir onceki class'daki testi, Faker class'indan degerler ile yapin

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
        Faker faker = new Faker();
        String fakePassword = faker.internet().password();
        String fakeIsim = faker.name().firstName();

        ReusableMethods.bekle(1);
        actions.click(firstnameKutusu)
                .sendKeys(fakeIsim)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .perform();
        ReusableMethods.bekle(1);
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

        String actualIsim = isimElementi.getText();

        Assert.assertEquals(fakeIsim,actualIsim);

    }
}
