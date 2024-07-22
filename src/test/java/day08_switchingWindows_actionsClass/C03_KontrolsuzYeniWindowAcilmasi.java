package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C03_KontrolsuzYeniWindowAcilmasi extends TestBaseEach {

    @Test
    public void test01(){

        // https://testotomasyonu.com/addremove/  url'e gidin

        driver.get("https://testotomasyonu.com/addremove/");

        System.out.println("addremove : "+ driver.getCurrentUrl()); // https://testotomasyonu.com/addremove/
        System.out.println("addremove : "+ driver.getWindowHandle()); // B3EAA570CB2910434B41A8E608AF22F2
        String ilkWindowWhd = driver.getWindowHandle();
        ReusableMethods.bekle(3);

        // Electronics linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]"))
                .click();

        System.out.println("electronics linkine tiklayinca  : "+ driver.getCurrentUrl()); // https://testotomasyonu.com/addremove/
        System.out.println("electronics linkine tiklayinca  : "+ driver.getWindowHandle()); //

        // back tusuna basin ve
        // https://testotomasyonu.com/addremove/ adresine dondugunuzu test edin
        ReusableMethods.bekle(3);
        driver.navigate().back();

        String expectedUrl = "https://testotomasyonu.com/addremove/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);


        // Please click for Electronics Products linkine tiklayin
        ReusableMethods.bekle(3);
        driver.findElement(By.xpath("//*[text() = 'Electronics Products']"))
                .click();

        System.out.println("Please click for Electronics Products linkine basinca : "+ driver.getCurrentUrl());
        // Yeni Tab acildiginda : about:blank
        System.out.println("Please click for Electronics Products linkine basinca : "+ driver.getWindowHandle());
        // 83E84E3762FDEB38AF2F6DB152CD78AF
        System.out.println("Please click for Electronics Products linkine basinca tum WHD'leri : "+ driver.getWindowHandles());
        // 83E84E3762FDEB38AF2F6DB152CD78AF



        // kategory olarak Electronics sayfasinin acildigini test edin
        // Home/Electronics yazisinin gorundugunu test edin





        /*
            Kontrolsuz bir window acildiginda
            driver yeni window'a ve yeni sayfa'ya gecemez
            eski window ve eski url'de bekler

            biz yeni acilan windowda, acilan url'deki bir web elementi kullanmak istedigimizde
            o web elementi bulamaz ve testimiz failed olur

            Kontrolsuz acilan 2.window'a gecis yapabilmek icin
            2.window'un window handle degerini bulmamiz gerekir

            driver.getWindowHandle() icinde oldugu window'un WHD'ini verir
            driver yeni window'a gecmeden driver'i kullanarak WHD'ini alamayiz
            WHD olmadan da driver'i yeni window'a geciremeyiz.

            Bu durumda bizim driver'a henuz gecmedigi window'un WHD'ini bulmamiz lazim

            Burada JAVA devreye girer

            1- ilk window acildiginda birinciWindowWHD'ini kaydederiz
            2- kontrolumuz disinda bir window acildiginda
               driver.getWindowHandles() ile acilmis olan 2 window'un
               WindowHandleDegerlerini kaydederiz
            3- Bir for-each loop ile Set'deki 2 WHD'ini ele alip
               kaydettigimiz birinciWindowWHD'ine esit olmayan String'i
               ikinciWindowWHD olarak atariz
            4- java ile buldugumuz ikinciWindowWHD'ini kullanarak
               driver'i ikinci window'a gecirebiliriz

         */

        Set<String> acikTumWindowlarinWHDleri = driver.getWindowHandles();
        String ikinciWindowWHD = "";

        for (String eachWhd : acikTumWindowlarinWHDleri
             ) {

            if (   ! eachWhd.equals(ilkWindowWhd) ){
                ikinciWindowWHD = eachWhd;
            }
        }

        driver.switchTo().window(ikinciWindowWHD); // driver ikinci window'a gecis yapti

        WebElement seciliKategoryElementi = driver.findElement(By.xpath("//li[@class='current']"));

        String expectedSeciliKategori = "Electronics";
        String actualSeciliKategori = seciliKategoryElementi.getText();

        Assertions.assertEquals(expectedSeciliKategori,actualSeciliKategori);
        ReusableMethods.bekle(2);


        ReusableMethods.bekle(3);
    }
}
