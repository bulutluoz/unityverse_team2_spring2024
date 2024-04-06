package tests.day06_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_DragAndDrop extends TestBase {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement acceptableButonu = driver.findElement(By.xpath("//*[text()='Acceptable']"));
        WebElement dropHereKutusu = driver.findElement(By.xpath("//*[@id='droppable2']"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(acceptableButonu,dropHereKutusu).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        ReusableMethods.bekle(1);
        WebElement droppedYaziElementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertTrue(droppedYaziElementi.isDisplayed());

        //4- Sayfayi yenileyin
        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAccaptableElementi = driver.findElement(By.id("draggable-nonvalid2"));
        dropHereKutusu = driver.findElement(By.xpath("//*[@id='droppable2']"));
        ReusableMethods.bekle(1);
        actions.dragAndDrop(notAccaptableElementi,dropHereKutusu).perform();

        //6- “Drop Here” yazisinin degismedigini test edin
        WebElement dropHereYaziElementi = driver.findElement(By.xpath("//*[text()='Drop Here']"));

        String expectedYazi = "Drop Here";
        String actualYazi = dropHereYaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(3);
    }
}
