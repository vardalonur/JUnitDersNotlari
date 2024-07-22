package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;
import java.util.Set;

public class C04_KontrolsuzYeniWindowKullanimi extends TestBaseEach {

    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkWindowWHD = driver.getWindowHandle();

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        String expectedYazi = "Add/Remove Elements";

        WebElement yaziElementi = driver.findElement(By.tagName("h2"));
        String actualyazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” icerdigini doğrulayın.

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● ’Please click for Electronics Products’ linkine tiklayin.

        driver.findElement(By.xpath("//*[text() ='Electronics Products']"))
                .click();

        //● Electronics sayfasinin acildigini test edin

        // once driver'i kontrolsuz acilan 2.window'a gecirmeliyiz

        Set<String> tumWindowlarinWHDSeti = driver.getWindowHandles();

        //System.out.println(ilkWindowWHD);
        //System.out.println(tumWindowlarinWHDSeti);

        String ikinciWindowWhd ="";

        for (String eachWHD : tumWindowlarinWHDSeti
             ) {

            if (  ! eachWHD.equals(ilkWindowWHD)  ){
                ikinciWindowWhd = eachWHD;
            }
        }

        // artik 2.window'un windowhandleDegerini biliyoruz
        // driver'i 2.window'a gecirebiliriz

        driver.switchTo().window(ikinciWindowWhd);

        String expectedUrl ="https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);

        //● Bulunan urun sayisinin 16 olduğunu test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='prod-img']"));

        Assertions.assertEquals(16, bulunanUrunElementleriList.size());

        //● Ilk actiginiz addremove sayfasinin oldugu window’a donun

        driver.switchTo().window(ilkWindowWHD);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(3);

    }
}
