package tests.webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_XPath_textKullanimi {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']"))
                .click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonElementi = driver.findElement(By.xpath("//button[text()='Delete']"));

        if (deleteButonElementi.isDisplayed()){
            System.out.println("Delete butonu testi PASSED");
        }else{
            System.out.println("Delete butonu testi FAILED");
        }


        //4- Delete tusuna basin
        deleteButonElementi.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add Remove yazi testi PASSED");
        }else System.out.println("Add Remove yazi testi FAILED");

        Thread.sleep(3000);
        driver.quit();
    }
}
