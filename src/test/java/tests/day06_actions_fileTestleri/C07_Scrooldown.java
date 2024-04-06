package tests.day06_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_Scrooldown extends TestBase {

    @Test
    public void test01(){

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        /*
            driver objesi gorunmeyen bir webelementi kullanmasi gerektiginde
            farkli websayfalarinda farkli davranabilir

            bazi websayfalarinda webelementi goremesek de driver kullanabilirken,
            bazi sayfalarda gorunmeyen webelementleri kullanamayabilir

            Testimiz sirasinda gorunmeyen bir webelementi kullanmamiz gerekirse
            deneyip sonucu gozlemlemek en iyi yol olacaktir
         */

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // actions.scrollToElement(videoIframeElementi); EGER webelementi locate edip kullanabileceksek
        ReusableMethods.bekle(5);

        //4- videoyu izlemek icin Play tusuna basin

        // video iframe icinde oldugundan, once iframe'e gecis yapmaliyiz
        WebElement videoIframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(videoIframeElementi);

        driver.findElement(By.xpath("//button[@title='Play']"))
                .click();

        //5- videoyu calistirdiginizi test edin

        // calistigini test etmek icin
        // mouse'u volume butonuna yaklastirip
        // volume logosunun gorunur oldugunu test edelim

        ReusableMethods.bekle(4);

        WebElement volumeButonu = driver.findElement(By.className("ytp-volume-panel"));
        actions.moveToElement(volumeButonu).perform();

        Assert.assertTrue(volumeButonu.isDisplayed());

        ReusableMethods.bekle(2);
    }
}
