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

public class C02_ExplicitWait {

    /*
        Explicit Wait implicitly wait'in yeterli olmadigi durumlarda
        spesifik bir webelement uzerinde, spesific bir condition'in calismasini kontrol etmek icin kullanilir

        1- WebDriverWait wait = new  WebDriverWait(driver, bekleme suresi);

        2- bekledigimiz element locate edilebiliyorsa
           once o webelement'i locate edip, sonra wait....

        3- Eger bekledigimiz element bekleme yapilmadan locate edilemiyorsa
           locate islemi ve wait tek bir satirda birlikte tanimlanabilir
     */


    @Test
    public void implicitlyWaitTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneyaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneyaziElementi.isDisplayed());
        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsbackYaziElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsbackYaziElementi.isDisplayed());

        ReusableMethods.bekle(3);
        driver.quit();
    }


    @Test
    public void explicitlyWaitTesti(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        /*
        WebElement itsGoneyaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneyaziElementi));

        bu iki islemin ikisi de once diger islemin calismasini istiyor
        locate etmek icin beklemek gerekiyor, beklemek icin de locate'e ihtiyac var

        Bu durum icin explicitly wait'de
        bekleme ve locate islemleri tek satirda yapilabilir
         */

        WebElement itsGoneyaziElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']"))
                .click();
        //5. It’s back mesajinin gorundugunu test edin

        // mesajin goruntulenebilmesi icin locate islemi ve wait'i birlestiriyoruz

        WebElement itsBackYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYaziElementi.isDisplayed());


        ReusableMethods.bekle(3);
        driver.quit();
    }


}
