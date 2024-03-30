package tests.day04_dropdownMenu_JsAlerts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C02_RadioButtons extends TestBase {


    @Test
    public void radioButtonTesti(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");
        //	b. Cinsiyet Radio button elementlerini locate edin

        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin

        erkekRadioButton.click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());
    }

    @Test
    public void yazidanSecimTesti(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");
        //	b. Cinsiyet Radio button elementlerini locate edin

        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        WebElement erkekRadioButtonYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekRadioButtonYaziElementi.click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());

    }
}
