package tests.day06_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_FileExist extends TestBase {

    @Test
    public void test01(){

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='nRoBo-Logo.png']"))
                .click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu = "/Users/ahmetbulutluoz/Downloads/nRoBo-Logo.png";

        ReusableMethods.bekle(1);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
