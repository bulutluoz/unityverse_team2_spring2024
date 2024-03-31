package tests.day05_iframe_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_IFrame extends TestBase {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIFrame);

        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//h2[text()='Electronics Products']"));
        Assert.assertTrue(electronicsYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        WebElement dellElementi = driver.findElement(By.id("dell-core"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin

        // once sagdaki iFrame'e gecmeliyiz
        // ama biz soldaki iFrame'in icinde oldugumuzdan
        // en once oradan anasayfaya donmeliyiz

        driver.switchTo().defaultContent();

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        WebElement fashionYaziElementi = driver.findElement(By.xpath("//h2[text()='Fashion']"));

        Assert.assertTrue(fashionYaziElementi.isDisplayed());

        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        driver.switchTo().defaultContent();

        WebElement hereAreYaziElementi =
                driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreYaziElementi.isDisplayed());


        //7- Sayfayi kapatin
        ReusableMethods.bekle(3);
        }
}
