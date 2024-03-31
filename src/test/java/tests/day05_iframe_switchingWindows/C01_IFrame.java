package tests.day05_iframe_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void iFrameTest(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement anIframeyaziElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(anIframeyaziElementi.isEnabled());

        System.out.println(anIframeyaziElementi.getText());

        //	- Text Box’a “Merhaba Dunya!” yazin.

        /*
            textbox iframe icerisinde oldugu icin
            textbox'i direk kullanamadik

            iFrame icerisindeki bir webelement'e ulasmak icin
            once o iFrame'e gecis yapmaliyiz

            iFrame'e gecis yapabilmek icin de
            iFrame'i locate etmeliyiz
         */

        WebElement iFrameElementi = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));

        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        //	- TextBox’in altinda bulunan “Elemental Selenium”
        //    linkinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        /*
            driver'a iFrame'e gecis yaptirdigimizda
            biz onu yeniden anasayfaya dondurunceye kadar
            driver iFrame'de kalir

            Bu durumda ana sayfadaki webElementleri goremez

            Biz Elemental Selenium linkine ulasmak istiyorsak
            once gecis yaptigimiz iFrame'den anasayfaya donmeliyiz

            anasayfaya donus icin 2 yontem kullanabiliriz
            - parentFrame() : icice birden fazla iframe varsa
                              bizi bir ust iFrame'e gecirir
            - defaultContent() : direk anasayfaya doner

         */

        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement elementalSeleniumElementi = driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());

        System.out.println(elementalSeleniumElementi.getText());

        ReusableMethods.bekle(3);

    }

}
