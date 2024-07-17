package day06_JUnitAssertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C06_DropdownMenu extends TestBaseEach {


    @Test
    public void dropdowntesti(){
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");
        //1. Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

            // 1.adim dropdown'i select tag'i olan HTML element ile locate edin
        WebElement gunDDM = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
            // 2.adim Select class'indan bir obje olusturup, gunDDM'yi parametre olarak gonderelim
        Select selectGun = new Select(gunDDM);
            // 3.adim selectGun objesi ile istediginiz islemleri yapin
        selectGun.selectByIndex(5);

        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        WebElement ayDDM = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDDM);
        selectAy.selectByValue("nisan");

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDDM = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDDM);
        selectYil.selectByVisibleText("1990");

        //4. Secilen değerleri konsolda yazdirin

        System.out.println(selectGun.getFirstSelectedOption().getText()); // 5
        System.out.println(selectAy.getFirstSelectedOption().getText()); // Nisan
        System.out.println(selectYil.getFirstSelectedOption().getText()); // 1990


        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> ayDdmTumSecenekler =  selectAy.getOptions();

        System.out.println(ReusableMethods.getStringList(ayDdmTumSecenekler));
        // [Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]

        // System.out.println(ayDDM.getText());

        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedListSize = 13;
        int actualListSize = ayDdmTumSecenekler.size();

        Assertions.assertEquals(expectedListSize,actualListSize);

        ReusableMethods.bekle(3);
    }
}
