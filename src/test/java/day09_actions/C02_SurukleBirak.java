package day09_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_SurukleBirak extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        WebElement acceptableButonu = driver.findElement(By.id("draggable2"));
        WebElement hedefAlanElementi = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(acceptableButonu,hedefAlanElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedYazi = "Dropped!";

        String actualyazi = driver.findElement(By.xpath("//*[text()='Dropped!']"))
                                    .getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(1);

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptableButonu = driver.findElement(By.id("draggable-nonvalid2"));
        hedefAlanElementi = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableButonu,hedefAlanElementi).perform();

        //6- “Drop Here” yazisinin degismedigini test edin

        WebElement dropHereYaziElementi = driver.findElement(By.xpath("//*[text()='Drop Here']"));

        expectedYazi = "Drop Here";
        actualyazi = dropHereYaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        ReusableMethods.bekle(3);
    }
}
