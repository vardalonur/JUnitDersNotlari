package day10_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_FileUpload extends TestBaseEach {

    @Test
    public void fileUploadTesti(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));
        String dosyaYolu = System.getProperty("user.dir")+"/src/test/java/day09_actions/sample.png";
        ///Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team144_JUnit     /src/test/java/day09_actions/sample.png
        chooseFileButonu.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        String expectedyazi = "File Uploaded!";

        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedyazi,actualYazi);

        ReusableMethods.bekle(3);
    }
}
