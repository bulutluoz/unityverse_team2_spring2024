package tests.day04_dropdownMenu_JsAlerts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Checkbox {

    WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        //https://demoqa.com/checkbox

        driver.get("https://demoqa.com/checkbox");
        Thread.sleep(3000);

        // home yazisinin yanindaki > ile menuyu acin
        driver.findElement(By.xpath("(//*[@title='Toggle'])[1]"))
                .click();
        Thread.sleep(3000);
        // desktop yazinin yanindaki > ile menuyu acin
        driver.findElement(By.xpath("(//*[@title='Toggle'])[2]"))
                .click();
        Thread.sleep(3000);

        // Notes checkbox'ini secin
        WebElement notesCheckbox = driver.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])[3]"));
        notesCheckbox.click();
        Thread.sleep(3000);
        // Notes checkbox'in secili oldugunu test edin
        notesCheckbox = driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-check']"));
        Assert.assertTrue(notesCheckbox.isDisplayed());
        // Commands checkbox'in secili olmadigini test edin

        WebElement commandsCheckbox = driver.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])[1]"));

        Assert.assertFalse(commandsCheckbox.isSelected());
    }
}
