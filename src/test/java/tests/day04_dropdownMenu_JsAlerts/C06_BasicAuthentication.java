package tests.day04_dropdownMenu_JsAlerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.concurrent.RunnableScheduledFuture;

public class C06_BasicAuthentication extends TestBase {

    /*
        basic authentication daha cok bilgisayarlar/uygulamalar arasi iletisimde kullanilir

        hizmet saglayicisi her isteyenin hic bir kontrol olmadan sistemine giris yapmasina izin vermez

        Basic authentication ile giris yapabilmemiz icin 2 bilgiyi hizmet saglayicidan ogrenmeliyiz

        1- kullanacagimiz username ve password
        2- bu username ve password'u nasil url'e ekleyecegimiz
     */

    @Test
    public void test01(){

        //2- https://testotomasyonu.com/basicauth sayfasina gidin

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        //
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basariliGirisYazielementi= driver.findElement(By.tagName("h1"));

        String expectedYazi = "Basic Auth";
        String actualYazi = basariliGirisYazielementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(15);
    }

}
