package tests.day06_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement kidsWearMenu = driver.findElement(By.xpath("(//li[@class='has-sub'])[7]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(kidsWearMenu).perform();

        //3- “Boys” linkine basin
        driver.findElement(By.linkText("Boys"))
                .click();

        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]"))
                .click();

        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[text()='Boys Shirt White Color']"));

        String expectedUrunIsmi = "Boys Shirt White Color";
        String actualUrunIsmi = urunIsimElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        ReusableMethods.bekle(5);
    }
}
