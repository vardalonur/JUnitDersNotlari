package day07_JsAllerts_IFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C03_JsAllerts extends TestBaseEach {

    //3 test method'u olusturup asagidaki gorevi tamamlayin

    @Test
    public void test01(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']"))
                .click();
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertyazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertyazi,actualAlertYazi);
        ReusableMethods.bekle(2);

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@*='jsConfirm()']"))
                .click();

        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucElementi = driver.findElement(By.id("result"));

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = sonucElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }

    @Test
    public void test03(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@*='jsPrompt()']"))
                .click();

        //	- Cikan prompt ekranina "Levent" yazdiralim
        driver.switchTo().alert().sendKeys("Levent");

        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement sonucElementi = driver.findElement(By.id("result"));

        String expectedYaziIcerik = "Levent";
        String actualSonucYazisi = sonucElementi.getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedYaziIcerik));

    }


}
