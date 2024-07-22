package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_SwitchingWindows extends TestBaseEach {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // yazi iframe icinde oldugundan once iframe'e gecelim
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframe);

        WebElement electronicProductsYaziElementi = driver.findElement(By.tagName("h2"));

        Assertions.assertTrue(electronicProductsYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellElementi = driver.findElement(By.id("pictext1"));

        String expectedurunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assertions.assertEquals(expectedurunIsmi,actualUrunIsmi);

        //4- Dell bilgisayar’a tiklayip
        dellElementi.click();

        // acilan sayfada urun fiyatinin $399.00 olduğunu test edin.

        // elemente tikladigimizda kontrolsuz olarak yeni window aciliyor
        // once yeni acilan window'a gecmemiz gerekir
        ReusableMethods.switchWindowByUrl(driver,"https://testotomasyonu.com/product/58");

        String expectedFiyat = "$399.00";
        String actualFiyat = driver.findElement(By.id("priceproduct"))
                                    .getText();

        Assertions.assertEquals(expectedFiyat,actualFiyat);

        //5- Ilk window'a donun

        ReusableMethods.switchWindowByTitle(driver,"Test Otomasyonu");

        // ve Fashion yazisinin gorunur olduğunu test edin

        // Fashion yazisi iframe icinde oldugundan once iframe'e gecis yapalim

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        WebElement fashionYaziElementi = driver.findElement(By.tagName("h2"));

        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        //6- Sayfayi kapatin
    }
}
