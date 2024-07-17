package day06_JUnitAssertions_dropdownMenu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_CheckBox {


    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void checkboxTesti(){

        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin

            // secme islemi yazidan ve checkbox'dan yapilabiliyor
            // yazidan secme ve kutudan secme ihtimallerini test etmek icin
            // sirt agrisini yazidan, carpintiyi kutudan secelim

        WebElement sirtAgrisiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck5']"));
        WebElement sirtAgrisiCheckbox = driver.findElement(By.xpath("//*[@id='gridCheck5']"));
        WebElement carpintiCheckbox = driver.findElement(By.xpath("//*[@id='gridCheck4']"));

        sirtAgrisiYaziElementi.click();
        carpintiCheckbox.click();
        ReusableMethods.bekle(2);

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assertions.assertTrue(sirtAgrisiCheckbox.isSelected());
        Assertions.assertTrue(carpintiCheckbox.isSelected());

        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekerCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox = driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckbox.isSelected());
        Assertions.assertFalse(epilepsiCheckbox.isSelected());

    }
}
