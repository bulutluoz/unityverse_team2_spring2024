package tests.day07_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ExplicitWait {

    @Test
    public void implicitlyWaitTest(){
        // implicitlyWait'i degistirmek icin
        // Driver'i bu method icinde olusturalim

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();
        // implicitlywait yeterli oldugundan bekleme eklemedim

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsEnabledYaziElementi.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());

        ReusableMethods.bekle(3);
        driver.quit();
    }


    @Test
    public void explicitWaitTest(){
        /*
            Implicitlywait sayfanin yuklenmesi ve webelementlerin bulunmasi icin belirlenmis
            maximim bekleme suresidir
            Bu sure internet ve bilgisayardaki yavasliklari tolere edecek kadar uzun,
            tum testlerin calisma suresini cok fazla uzatmayacak kadar kisa secilmelidir

            Testlerimiz sirasinda genel bekleme suresi olan implicitly wait suresi icinde
            sonuclandirilamayan islemler olabilir,
            bu durumda sadece o webelement'e ve sadece o goreve ozel
            explicit wait tanimlanabilir
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();

        // implicitlyWait suresini dusurdugumuz icin, bekleme yeterli olmayacaktir
        // textbox'a ozel enable oluncaya kadar bekleme tanimlayalim

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //6. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());

        //7. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsEnabledYaziElementi.isDisplayed());


        ReusableMethods.bekle(3);
        driver.quit();

    }
}
