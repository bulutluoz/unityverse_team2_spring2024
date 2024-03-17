package tests.day01_seleniumGiris;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");

        System.out.println("Maximize konum : "+ driver.manage().window().getPosition());
        System.out.println("Maximize boyut : "+ driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum : "+ driver.manage().window().getPosition());
        System.out.println("fullscreen boyut : "+ driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().minimize();

        Thread.sleep(2000);

        driver.manage().window().setPosition(new Point(100,300));
        driver.manage().window().setSize(new Dimension(500,500));

        System.out.println("ozel konum : "+ driver.manage().window().getPosition());
        System.out.println("ozel boyut : "+ driver.manage().window().getSize());

        Thread.sleep(8000);

        driver.quit();


    }
}
