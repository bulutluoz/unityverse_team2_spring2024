package tests.day08_webTables_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void readExceltesti() throws IOException {

        // Selenium WebDriver adindan da anlasilacagi gibi
        // Web sayfalarinda kullanilabilir,
        // bilgisayarimizdaki excel'e webDriver ile ulasamayiz

        // Java ile bilgisayarimizdaki dosyalara erisebilir,
        // ve bu dosyalardaki bilgileri okuyabilir veya update edebiliriz

        String dosyaYolu = "src/test/java/tests/day08_webTables_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // buradaki workbook objesi
        // bizim class'imizda olusturdugumuz bir excel dosyasi gibidir

        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // sayfa1 de 10.satirdaki ulkenin Turkce ismini yazdirin

        Row onuncuSatir = sayfa1.getRow(9);

        Cell istenenBilgi = onuncuSatir.getCell(2);

        System.out.println(istenenBilgi); // Avustralya

        // workbook index kullanir
        // excel'deki 10. satira gitmek istersek index = 9,
        // o satirdaki 3.dataya gitmek istersek index = 2 secmeliyiz

        // Excel ile ugrasirken, workbook objesi olusturmamiz ZORUNLUDUR
        // diger objeler Sheet, Row ve Cell ise zorunlu degildir
        // workbook objesinden adim adim istenen bilgiye ulasilabilir

        System.out.println(workbook.getSheet("Sayfa1")
                                    .getRow(9)
                                    .getCell(2)); // Avustralya

    }
}
