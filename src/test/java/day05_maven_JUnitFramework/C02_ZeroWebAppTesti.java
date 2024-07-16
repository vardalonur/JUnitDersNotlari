package day05_maven_JUnitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_ZeroWebAppTesti {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button"))
                .click();

        //3. Login alanina  “username” yazdirin
        WebElement userKutusu = driver.findElement(By.id("user_login"));
        userKutusu.sendKeys("username");

        //4. Password alanina “password” yazdirin
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit"))
                .click();

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']"))
                .click();

        driver.findElement(By.id("pay_bills_link"))
                .click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin

        WebElement amountKutusu = driver.findElement(By.id("sp_amount"));
        amountKutusu.sendKeys("200");
        //9. tarih kismina “2024-07-16” yazdirin
        driver.findElement(By.id("sp_date"))
                .sendKeys("2024-07-16");

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees"))
                .click();
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        WebElement mesajElementi = driver.findElement(By.id("alert_content"));

        String expectedMesaj = "The payment was successfully submitted.";
        String actualMesaj = mesajElementi.getText();

        if (expectedMesaj.equals(actualMesaj)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.quit();
    }
}
