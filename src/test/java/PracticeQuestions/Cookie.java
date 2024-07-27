package PracticeQuestions;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBaseEach;

import java.util.Set;

public class Cookie extends TestBaseEach {

    /*
1- amazon anasayfaya gidin
2- tum cookie’leri listeleyin
3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
6- eklediginiz cookie’nin sayfaya eklendigini test edin
7- ismi skin olan cookie’yi silin ve silindigini test edin
8- tum cookie’leri silin ve silindigini test edin
 */

    @Test
    public void test01 () {
        driver.get("https://www.amazon.com/");
        Set<org.openqa.selenium.Cookie> cookieler = driver.manage().getCookies();
        int siraNo = 1;
        for (org.openqa.selenium.Cookie cookie : cookieler) {
            System.out.println("sira no: "+siraNo+" "+cookie);
            siraNo++;
        }

        //Assertions.assertTrue(cookieler.size()>5);

        String expectedValue = "USD";
        String actualCookieValue = driver.manage().getCookieNamed("csm-sid").getValue();

        Assertions.assertEquals(expectedValue,actualCookieValue);

    }
}
