package day06_JUnitAssertions_dropdownMenu;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_Assertions {

    /*
        JUnit calisan test method'larinin hangisinin failed, hangisinin passed oldugunu da gosterir

        JUnit bir test method'u sorun olmadan calisip
        "Process finished with exit code 0" yaziyorsa
        bu test method'unu PASSED olarak algilar


        Eger bir test method'u calisirken
        herhangi bir sebeple calismasi durduruluyorsa
        ve beklenemeyen sebeple tum kodlar calistirilamiyorsa testi FAILED olarak algilar
     */

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        ReusableMethods.bekle(1);
        driver.quit();
    }

    @Test
    public void testotomasyonuTesti(){

        // 1- testotomasyonu.com'a gidip url'in "testotomasyonu" icerdigini test etsin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonuPPP";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu Url testi PASSED");
        }else {
            System.out.println("Testotomasyonu Url testi FAILED");
            throw new AssertionFailedError();
        }

    }


    @Test
    public void wisequarterTesti(){

        // 2- wisequarter.com'a gidip url'in "wisequarter" icerdigini test etsin
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarterPPP";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Url testi PASSED");
        }else System.out.println("Wisequarter Url testi FAILED");

    }

    @Test
    public void youtubeTesti(){

        // 3- youtube.com'a gidip url'in "youtube" icerdigini test etsin
        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtubePPP";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik),"Actual Url expected icerigi barindirmiyor");

    }
}
