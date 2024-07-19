package day07_JsAllerts_IFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_JsAllerts extends TestBaseEach {

    @Test
    public void test01(){

        /*
            Eger acilan pop-up veya uyari locate edilebiliyorsa
            yani HTML kodlarina ulasabiliyorsak
            bu allert'e HTML alert denir ve
            tum HTML elementler gibi locate edip kullanilabilir
         */

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // cookies kabul edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse'])[2]"))
                .click();
        ReusableMethods.bekle(1);

        // youtube logosunun gorundugunu test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assertions.assertTrue(logoElementi.isDisplayed());

        ReusableMethods.bekle(2);


        //https://testotomasyonu.com/javascriptAlert sayfasina gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(2);

        // Click For JS alert butonuna basin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']"))
                .click();
        ReusableMethods.bekle(2);
        /*
            EGER bir alert ciktiginda, HTML kodlari goruntulenemiyorsa
            driver ile locate edip kullanamayiz

            Selenium'da driver method'lari icinde olan
            switchTo() bu tur durumlarda kullanilabilir
         */

        // alert'de cikan yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertyazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertyazi,actualAlertYazi);
        ReusableMethods.bekle(2);

        // OK'e basarak alert'u kapatin

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(2);
    }
}
