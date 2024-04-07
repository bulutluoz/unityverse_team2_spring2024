package tests.day07_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void test01(){

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSeti  = driver.manage().getCookies();
        int no = 1;

        for (Cookie each : cookiesSeti
             ) {
            System.out.println(no + ". cookie :  " + each);
            no++;
        }


        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSeti.size() > 5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String expectedDeger = "USD";
        String actualDeger = driver
                                .manage()
                                .getCookieNamed("i18n-prefs")
                                .getValue();
        Assert.assertEquals(expectedDeger,actualDeger);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        //   ve sayfaya ekleyin
        Cookie newCookie = new Cookie("En Sevdigim Cookie","cikolatali");
        driver.manage().addCookie(newCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        cookiesSeti  = driver.manage().getCookies();
        boolean cikolataliCookieVarMi = false;

        for (Cookie eachCookie : cookiesSeti
             ) {

            if (eachCookie.getName().equals("En Sevdigim Cookie")){
                cikolataliCookieVarMi = true;
            }

        }

        Assert.assertTrue(cikolataliCookieVarMi);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        cookiesSeti  = driver.manage().getCookies();

        boolean skinCookieVarMi = false;

        for (Cookie eachCookie : cookiesSeti
        ) {

            if (eachCookie.getName().equals("skin")){
                skinCookieVarMi = true;
            }

        }

        Assert.assertFalse(skinCookieVarMi);

        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
        cookiesSeti  = driver.manage().getCookies();

        Assert.assertEquals(cookiesSeti.size(),0);


        ReusableMethods.bekle(2);
    }
}
