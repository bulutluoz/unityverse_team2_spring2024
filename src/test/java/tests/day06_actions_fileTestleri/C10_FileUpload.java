package tests.day06_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C10_FileUpload extends TestBase {

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        /*
            Selenium ile bilgisayarimizda varolan bir dosyayi
            secmek istedigimizde
            chooseFile butonuna bilgisayarimizdaki yuklemek istedigimiz dosyanin
            dosya yolunu sendKeys() ile gondermemiz yeterlidir
         */

        String dinamikDosyaYolu = System.getProperty("user.home")
                                    +"/"
                                    +"Downloads/nRoBo-Logo.png";

        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit"))
                .click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUplodedyaziElementi = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));

        Assert.assertTrue(fileUplodedyaziElementi.isDisplayed());

        ReusableMethods.bekle(5);
    }
}
