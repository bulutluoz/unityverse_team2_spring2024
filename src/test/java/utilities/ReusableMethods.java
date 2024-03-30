package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> donusturulecekListe){

        List<String> stingListe = new ArrayList<>();


        for (WebElement eachElement : donusturulecekListe
             ) {

            stingListe.add(eachElement.getText());
        }

        return stingListe;

    }

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("bekletme isleminde sorun olustu");
        }

    }
}
