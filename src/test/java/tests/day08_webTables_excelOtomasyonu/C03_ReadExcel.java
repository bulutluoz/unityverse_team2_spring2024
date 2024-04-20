package tests.day08_webTables_excelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/test/java/tests/day08_webTables_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //		- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)

        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String istenenHucredekiYazi = sayfa1.
                                            getRow(0).
                                            getCell(1).
                                            toString();
        System.out.println(istenenHucredekiYazi);// Başkent (İngilizce)

        //		- 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim

        String expectedCellYazi = "Kabil";
        String actualCellYazi = sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedCellYazi,actualCellYazi);

        // 3.satir 6.sutun'daki bilgiyi yazdirin
        System.out.println(sayfa1.getRow(2).getCell(5)); // null

        // 200.satir 3.sutundaki bilgiyi yazdiralim

        // System.out.println(sayfa1.getRow(199).getCell(2)); // NullPointerException

        // kullanilan satirlardaki, kullanilmayan sutunlar icin default deger olarak null veriyor
        // ama kullanilmayan satirlar olusturulmadigi icin NullPointerException verir

        //		- Satir sayisini bulalim
        System.out.println(sayfa1.getLastRowNum()); // 190
        // son satirin index'ini verir

        //		- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows()); // 191
        // fiziki olarak kullanilan satir sayisini verir

        // Sayfa2'de son satir index'ini
        // ve fiziki kullanilan satir sayisini yazdiralim

        System.out.println(workbook.getSheet("sayfa2")
                                    .getLastRowNum()); // 19

        System.out.println(workbook.getSheet("Sayfa2")
                                    .getPhysicalNumberOfRows()); // 8

        // Ingilizce baskent isimlerinde Amsterdam isimli baskentin oldugunu test edin
        // 1.satirdan baslayip, son satira kadar Amsterdam var mi diye kontrol etmeliyiz

        boolean amsterdamVarMi = false;

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            if (satirdakiIngilizceBaskentIsmi.equalsIgnoreCase("amsterdam")){
                amsterdamVarMi = true;
                break;
            }

        }

        Assert.assertTrue(amsterdamVarMi);

        // Ingilizce ulke isimlerinde Pakistan oldugunu test edin

        boolean pakistanVarMi = false;

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi =
                    sayfa1.getRow(i).getCell(0).toString();


            if (satirdakiIngilizceUlkeIsmi.equalsIgnoreCase("pakistan")){
                pakistanVarMi = true;
                break;
            }
        }

        Assert.assertTrue(pakistanVarMi);


        //		- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> ulkelerMap = new TreeMap();

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();
            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

            ulkelerMap.put(satirdakiIngilizceUlkeIsmi,satirdakiIngilizceBaskentIsmi);
        }


        // Ingilizce baskent ismi Berlin olan bir ulke bulundugunu test edin

        Assert.assertTrue(ulkelerMap.containsValue("Berlin"));

        // Ingilizce ismi Turkey olan bir ulke bulundugunu test edin

        Assert.assertTrue(ulkelerMap.containsKey("Turkey"));

        // Ingilizce ismi Banana Republic olan bir ulke bulunmadigini test edin

        Assert.assertFalse(ulkelerMap.containsKey("Banana Republic"));
    }
}
