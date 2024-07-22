package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

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

        WebElement seciliKategoryElementi = driver.findElement(By.xpath("//li[@class='current']"));

        String expectedSeciliKategori = "Electronics";
        String actualSeciliKategori = seciliKategoryElementi.getText();

        Assertions.assertEquals(expectedSeciliKategori,actualSeciliKategori);
        ReusableMethods.bekle(2);


        ReusableMethods.bekle(3);

    }
}
