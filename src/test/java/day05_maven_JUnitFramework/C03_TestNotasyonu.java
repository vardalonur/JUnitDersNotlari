package day05_maven_JUnitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_TestNotasyonu {

    /*
        Bir test framework'unde kullanilacak her bagimsiz mini test
        farkli test gruplarinda (smoke, E2E testi, regression ...) calistirilabilir olmalidir

        Bu class'da birbirinden bagimsiz calisabilecek
        3 test yapmak istiyorum
        1- testotomasyonu.com'a gidip url'in "testotomasyonu" icerdigini test etsin
        2- wisequarter.com'a gidip url'in "wisequarter" icerdigini test etsin
        3- youtube.com'a gidip url'in "youtube" icerdigini test etsin


     */


    public static void testotomasyonuTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1- testotomasyonu.com'a gidip url'in "testotomasyonu" icerdigini test etsin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu Url testi PASSED");
        }else System.out.println("Testotomasyonu Url testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();
    }

    public static void wisequarterTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 2- wisequarter.com'a gidip url'in "wisequarter" icerdigini test etsin
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Url testi PASSED");
        }else System.out.println("Wisequarter Url testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();
    }

    public static void youtubeTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 3- youtube.com'a gidip url'in "youtube" icerdigini test etsin
        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Url testi PASSED");
        }else System.out.println("Youtube Url testi FAILED");

        ReusableMethods.bekle(1);
        driver.quit();
    }


}
