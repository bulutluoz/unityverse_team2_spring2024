package tests.day08_webTables_excelOtomasyonu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void webTableTesti(){

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikSutunElementleriList =
                driver.findElements(By.xpath("//div[@role='hrow']/ *[@role='hdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikSutunElementleriList));

        //  3. 3.sutunun basligini yazdirin

        System.out.println("3.sutun basligi : " + baslikSutunElementleriList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin

        List<WebElement> bodydekiTumDataElementleriList =
                driver.findElements(By.xpath("//div[@role='trow']/ *[@role='tdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(bodydekiTumDataElementleriList));
        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablo body'sindeki data sayisi : " + bodydekiTumDataElementleriList.size());
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//div[@role='trow']"));

        System.out.println("Tablodaki satir sayisi : " + satirElementleriList.size());
        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi : " + baslikSutunElementleriList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//div[@role='trow']/ *[@role='tdata'][3]"));

        System.out.println("3.Sutun : "+ ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));
        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        //     tum satirlari kontrol etmesi gerektigi icin, bir for loop olusturalim

        for (int i = 1; i <=satirElementleriList.size() ; i++) {

            //     ((//div[@role='trow'])[   5   ] / *[@role='tdata'])[2]
            String dinamikCategoryXpathi = "((//div[@role='trow'])[" + i + "] / *[@role='tdata'])[2]";

            //     ((//div[@role='trow'])[   5   ] / *[@role='tdata'])[3]
            String dinamikFiyatXpathi = "((//div[@role='trow'])[" + i + "] / *[@role='tdata'])[3]";

            String satirdakiCategory = driver.findElement(By.xpath(dinamikCategoryXpathi))
                                                .getText();

            String satirdakiFiyat = driver.findElement(By.xpath(dinamikFiyatXpathi))
                                            .getText();

            if (satirdakiCategory.equalsIgnoreCase("Furniture")){
                System.out.println("Category'si furniture olan urunun fiyati : " + satirdakiFiyat);
            }

        }

        //10. Bir method olusturun,
        //    Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

        ReusableMethods.bekle(3);
        printData(1,2); // Electronics
        printData(2,3); // $399.00

    }


    public void printData(int satir , int sutun){

        //         ((//div[@role='trow'])[  2   ] / *[@role='tdata'])[   2   ]

        String dinamikXpath = "((//div[@role='trow'])[" + satir +
                              "] / *[@role='tdata'])[" + sutun + "]";

        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));

        System.out.println(satir +".satir, " + sutun+".sutundaki data : " + istenenDataElementi.getText());
    }
}
