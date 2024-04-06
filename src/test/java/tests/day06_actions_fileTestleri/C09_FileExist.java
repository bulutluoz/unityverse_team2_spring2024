package tests.day06_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C09_FileExist {

    @Test
    public void test01(){

        // projede calistigimiz package altinda deneme.txt dosyasinin oldugunu test edin

        String dosyaYolu = "/Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/unityverseTeam2_JUnit" +
                            "/" +
                            "src/test/java/tests/day06_actions_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
            Bir proje uzerinde pekcok insanla ortak calistigimizda
            dosya yolunun sadece bizim bilgisayarimiza ozel olmasini istemeyiz

            Bunun icin file testlerinde dosya yolunu dinamik hale getirmeliyiz
            Java bilgisayarimizdaki iki konumu dinamik olarak bize verebilir

            home : /Users/ahmetbulutluoz
                  bu konumu kullanarak downloads, desktop gibi tum bilgisayarlarda olan klasorlere ulasabiliriz
                  home/Downloads
                  home/Desktop

            proje : /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler
                   bu konumu kullanarak, projemiz icerisindeki dosyalara dinamik olarak ulasabiliriz
         */


        // Dinamik olarak asagidaki testleri yapalim

        // 1- projedeki day06 package'i icinde deneme.txt dosyasi oldugunu test edin

        String dinamikDosyaYolu = "herkesin bilgisayarina ozel kisim" + "herkes icin ortak kisim";

        dinamikDosyaYolu = System.getProperty("user.dir") +"/"+"src/test/java/tests/day06_actions_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


        // 2- Downloads'da nRoBo-Logo.png dosyasinin var oldugunu test edin
        //    "/Users/ahmetbulutluoz"  +  "/" +   "Downloads/nRoBo-Logo.png"

        dinamikDosyaYolu = System.getProperty("user.home")+"/"+"Downloads/nRoBo-Logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }
}
