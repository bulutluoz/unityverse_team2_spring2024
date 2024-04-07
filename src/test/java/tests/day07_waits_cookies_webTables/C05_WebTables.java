package tests.day07_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C05_WebTables extends TestBase {

    @Test
    public void test01(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");
        //2. Web table tum body’sini yazdirin

        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("======Tum Body======");
        System.out.println(tumBody.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedBodyIcerik = "Comfortable Gaming Chair";
        String actualBody = tumBody.getText();

        Assert.assertTrue(actualBody.contains(expectedBodyIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();

        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin
        System.out.println("======Tum Satirlar======");
        System.out.println(ReusableMethods.stringListeDonustur(satirElementleriList));
        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //   WebTable'larda sutun yapisi yoktur,
        //   kac sutun oldugunu bulmak icin, herhangi bir satirdaki data sayisini bulalim
        List<WebElement> satir4DataElementleri = driver.findElements(By.xpath("//tbody/tr[4]/td"));
        Assert.assertEquals(4,satir4DataElementleri.size());

        //7. 3.sutunu yazdirin
        List<WebElement> sutun3Elementleri =
                driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println(ReusableMethods.stringListeDonustur(sutun3Elementleri));

        //8. Tablodaki basliklari yazdirin
        List<WebElement> baslikElementleriList =
                driver.findElements(By.xpath("//thead/tr/th"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikElementleriList));
        //9. Satir ve sutunu parametre olarak alip,
        //   hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(getTableData(2, 3)); // $40.00
        System.out.println(getTableData(1,2)); // Electronics

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedData = "Furniture";
        String actualData = getTableData(4,2);

        Assert.assertEquals(expectedData,actualData);

    }

    public String getTableData(int satirNo , int sutunNo){

        //             //tbody/tr[    satirNo    ]/td[    sutunNo     ]

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";
        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElementi.getText();
    }
}
