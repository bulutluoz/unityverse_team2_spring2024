package tests.day04_dropdownMenu_JsAlerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_DropdownMenu extends TestBase {


    @Test
    public void test01(){
        // https://testotomasyonu.com/form adresine gidin
        driver.get("https://testotomasyonu.com/form");
        //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

            // 1.adim : kullanilacak Webelementi locate et
        WebElement gunDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
            // 2.adim : select objesi olusturalim, parametre olarak kullanacagimiz DDM'yu yazalim
        Select selectGun = new Select(gunDropdown);
            // 3.adim : olusturdugumuz select objesi ile, hazir methodlari kullanalim
        selectGun.selectByIndex(5);

        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        WebElement ayDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDropdown);
        selectAy.selectByValue("nisan");

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

        WebElement yilDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDropdown);
        selectYil.selectByVisibleText("1990");

        //4. Secilen değerleri konsolda yazdirin

        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> gunSecenekleriList = selectGun.getOptions();

        // WebElementlerden olusan bir liste direk yazdirilamaz
        // bir loop ile tum elementleri tek tek ele alip, String'e cevirip yazdirabiliriz

        /*
        for (WebElement eachElement : gunSecenekleriList
             ) {
            System.out.println(eachElement.getText());
        }

         */

        // listeyi String bir listeye donusturelim

        System.out.println(ReusableMethods.stringListeDonustur(gunSecenekleriList));


        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        List<WebElement> ayDDMOptionList = selectAy.getOptions();

        int expectedOptionSayisi = 13;
        int actualOptionSayisi = ayDDMOptionList.size();

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
    }
}
