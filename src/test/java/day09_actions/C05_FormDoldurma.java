package day09_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_FormDoldurma extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[text()='Account'])[1]"))
                .click();

        // eger signUp linki sayfada gorunmuyirsa
        // actions ile PAGEDOWN yapmak gerekir

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath(" //*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        //   bilgi yazmak icin her kutuyi ayri ayri locate etmek yerine
        //   firstname kutusunu locate edip, kalanlari TAB ile gezinebiliriz

        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(firstnameKutusu)
                .sendKeys("Levent")
                .sendKeys(Keys.TAB)
                .sendKeys("Ismail")
                .sendKeys(Keys.TAB)
                .sendKeys("wise@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        // signup butonuna basalim
        driver.findElement(By.id("btn-submit-form"))
                .click();

        //5- Kaydin olusturuldugunu test edin
        // login yaparak hesabin olusturulabildigini test edelim
        WebElement emailKutusu = driver.findElement(By.id("email"));
        ReusableMethods.bekle(2);
        actions.click(emailKutusu)
                .sendKeys("wise@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();
        ReusableMethods.bekle(2);
        driver.findElement(By.id("submitlogin"))
                .click();

        ReusableMethods.bekle(2);

        WebElement logoutButonu = driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();

        ReusableMethods.bekle(2);
    }
}
