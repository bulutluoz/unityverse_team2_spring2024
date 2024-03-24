package tests.day03_JunitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_CheckBox {



    @Test
    public void checkboxTest() throws InterruptedException {
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        //     secim hem yazidan hem de kutucuktan yapilabiliyor
        //     ikisini de test edebilmek icin
        //     sirt agrisini kutucuktan, carpintiyi yazidan secelim

        WebElement sirtAgriKutusu = driver.findElement(By.id("gridCheck5"));
        WebElement sirtAgriYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck5']"));

        WebElement carpintiKutusu = driver.findElement(By.id("gridCheck4"));
        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));

        sirtAgriKutusu.click();
        carpintiYaziElementi.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assert.assertTrue(sirtAgriKutusu.isSelected());
        Assert.assertTrue(carpintiKutusu.isSelected());

        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekerKutusu = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiKutusu = driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(sekerKutusu.isSelected());
        Assert.assertFalse(epilepsiKutusu.isSelected());

        Thread.sleep(3000);
        driver.quit();

    }
}
