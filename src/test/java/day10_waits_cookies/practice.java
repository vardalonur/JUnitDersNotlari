package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class practice extends TestBaseEach {

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
        Set<Cookie> cookieler = driver.manage().getCookies();
        int siraNo = 1;
        for (Cookie cookie : cookieler) {
            System.out.println("sira no: "+siraNo+" "+cookie);
            siraNo++;
        }

        Assertions.assertTrue(cookieler.size()<5);

        Cookie cookieYeni = new Cookie("en sevdigim cookie","cikolatali");

        driver.manage().addCookie(cookieYeni);
        System.out.println();
        System.out.println();
        cookieler = driver.manage().getCookies();
        siraNo = 1;
        for (Cookie cookie : cookieler) {
            System.out.println("sira no: "+siraNo+" "+cookie);
            siraNo++;
        }
        System.out.println();

        Cookie cookie2 = driver.manage().getCookieNamed("csm-sid");
        System.out.println(cookie2);
        System.out.println(cookie2.getValue());
        System.out.println(cookie2.getName());
        System.out.println(cookie2.getExpiry());
        System.out.println(cookie2.getDomain());
        System.out.println(cookie2.getPath());
        driver.manage().deleteCookieNamed("csm-sid");

        cookieler = driver.manage().getCookies();

        siraNo = 1;
        for (Cookie cookie : cookieler) {
            System.out.println("sira no: "+siraNo+" "+cookie);
            siraNo++;
        }
        System.out.println();
        driver.manage().deleteAllCookies();
        cookieler = driver.manage().getCookies();
        siraNo = 1;
        for (Cookie cookie : cookieler) {
            System.out.println("sira no: "+siraNo+" "+cookie);
            siraNo++;
        }
        System.out.println(cookieler.size());


       }
    }

