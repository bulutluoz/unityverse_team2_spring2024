package tests.day03_JunitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        //2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin
        //3 ) Acilan urunun DSLR Camera oldugunu test edin.


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/relativeLocators");

        // DSLR elementinin HTML kodu
        // <li id="dslr-camera">
        //      <a id="pictext7" class="overlay" href="http://testotomasyonu.com/product/32">
        //      <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
        //      <span>DSLR Camera</span></a>
        //    </li>

        // Relative locator icin 2 bilgiye sahip olmaliyiz
        // 1- hedef webelement'e ait HTML kodu veya en azindan HTML kodun bir bolumu
        // 2- hedef elementin etrafinda olup kullanabilecegimiz en az bir webelement

        WebElement appleKulaklik = driver.findElement(By.id("apple-headphone"));
        WebElement motorTelefon = driver.findElement(By.id("motor"));
        WebElement batKulaklik = driver.findElement(By.id("bat-rockerz"));

        WebElement relativeDslr1 =
                driver.findElement(RelativeLocator.with(By.id("dslr-camera"))
                        .toRightOf(appleKulaklik));

        WebElement relativeDslr2 =
                driver.findElement(RelativeLocator.with(By.id("pictext7"))
                        .toLeftOf(motorTelefon));

        WebElement releativeDslr3 =
                driver.findElement(RelativeLocator.with(By.tagName("li"))
                        .below(batKulaklik)
                        .toRightOf(appleKulaklik)
                        .toLeftOf(motorTelefon));

        // 1.relative locator'i click yapip acilan sayfada urun ismini test edelim

        relativeDslr1.click();

        WebElement urunisimElementi = driver.findElement(By.xpath("(//*[text()='DSLR Camera'])[1]"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunisimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("1.relative locator testi PASSED");
        }else System.out.println("1.relative locator testi FAILED");
        Thread.sleep(1000);

        // 2.relative locator'i click yapip acilan sayfada urun ismini test edelim

        // urun sayfasi acildigi icin, yeniden eski sayfaya donmeliyiz
        driver.navigate().back();
        Thread.sleep(1000);
        relativeDslr2.click();

        /*
            StaleElementReferenceException
            bir sayfada daha once kullandigimiz bir webelementi
            yeniden kullanmak istedigimizde
            sayfa degistirmis olmamiz gibi farkli sebeplerden oturu
            webelement'e ulasamadiginda ortaya cikar

            bu sorunun cozumu icin
            stale element (bayatlamis)'i yeniden locate etmeliyiz
         */

        urunisimElementi = driver.findElement(By.xpath("(//*[text()='DSLR Camera'])[1]"));
        actualUrunIsmi = urunisimElementi.getText(); // StaleElementReferenceException


        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("2.relative locator testi PASSED");
        }else System.out.println("2.relative locator testi FAILED");


        // 2.relative locator'i click yapip acilan sayfada urun ismini test edelim

        driver.navigate().back();

        releativeDslr3.click();

        urunisimElementi = driver.findElement(By.xpath("(//*[text()='DSLR Camera'])[1]"));
        actualUrunIsmi = urunisimElementi.getText(); // StaleElementReferenceException


        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("3.relative locator testi PASSED");
        }else System.out.println("3.relative locator testi FAILED");



        Thread.sleep(3000);
        driver.quit();

    }
}
