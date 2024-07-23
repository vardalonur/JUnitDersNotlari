package day09_actions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_FakeBilgilerleFormDoldurma extends TestBaseEach {

    @Test
    public void test01(){

        Faker faker = new Faker();

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[text()='Account'])[1]"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath(" //*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        String fakeSifre = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();

        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre).perform();

        // signup butonuna basalim
        driver.findElement(By.id("btn-submit-form"))
                .click();

        //5- Kaydin olusturuldugunu test edin
        // login yaparak hesabin olusturulabildigini test edelim
        WebElement emailKutusu = driver.findElement(By.id("email"));
        ReusableMethods.bekle(2);
        actions.click(emailKutusu)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre).perform();
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
