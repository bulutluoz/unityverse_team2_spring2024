package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static void windowDegistir(WebDriver driver, String yeniWindowUrl) {

        Set<String> tumWHDleriSeti = driver.getWindowHandles();

        for ( String eachWhd : tumWHDleriSeti
             ) {

            driver.switchTo().window(eachWhd);
            String url = driver.getCurrentUrl();
            if (url.equals(yeniWindowUrl)){
                break;
            }
        }
    }
}
