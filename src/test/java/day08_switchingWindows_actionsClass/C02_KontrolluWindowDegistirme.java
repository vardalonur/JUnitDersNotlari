package day08_switchingWindows_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C02_KontrolluWindowDegistirme extends TestBaseEach {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        System.out.println("Anasayfa : "+ driver.getCurrentUrl()); // https://www.testotomasyonu.com/
        System.out.println("Anasayfa : "+ driver.getWindowHandle()); // B3EAA570CB2910434B41A8E608AF22F2
        ReusableMethods.bekle(3);

        // Yeni bir tab olusturup electronics linkine tiklayin

        // EGER driver'a YENI BIR WINDOW actirmak istersek
        // switchTo().newWindow() kullanabiliriz
        // Bu method kullanildiginda 4 onemli noktaya DIKKAT ETMEMIZ gerekir
        // 1- driver OTOMATIK olarak yeni acilan window'a gecer
        // 2- yeni window bos olarak gelir
        // 3- yeni acilan window'da driver.navigate.back dersek anasayfaya donmez
        //    anasayfaya donmek isterseniz driver.switchTo(anasayfanin acik oldugu window'un WHD)
        // 4- switchTo().newWindow() ile acilan window bos oldugundan
        //    electronics linkine basmak icin anasayfaya bir kere daha gitmek gerekir
        System.out.println("=============================");
        driver.switchTo().newWindow(WindowType.TAB);
        System.out.println("Yeni Tab acildiginda : "+ driver.getCurrentUrl());
        // Yeni Tab acildiginda : about:blank
        System.out.println("Yeni Tab acildiginda : "+ driver.getWindowHandle());
        // 83E84E3762FDEB38AF2F6DB152CD78AF
        System.out.println("Yeni Tab acildiginda tum WHD'leri : "+ driver.getWindowHandles());
        // 83E84E3762FDEB38AF2F6DB152CD78AF

        driver.get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]"))
                .click();
        System.out.println("=============================");
        System.out.println("Electronics linkine basinca : "+ driver.getCurrentUrl());
        // Yeni Tab acildiginda : about:blank
        System.out.println("Electronics linkine basinca : "+ driver.getWindowHandle());
        // 83E84E3762FDEB38AF2F6DB152CD78AF
        System.out.println("Electronics linkine basinca tum WHD'leri : "+ driver.getWindowHandles());
        // 83E84E3762FDEB38AF2F6DB152CD78AF

        ReusableMethods.bekle(3);

        // Yeni bir window'da wisequarter.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);

        System.out.println("=============================");
        System.out.println("3.window acildiginda : "+ driver.getCurrentUrl());
        // Yeni Tab acildiginda : about:blank
        System.out.println("3.window acildiginda  : "+ driver.getWindowHandle());
        // 83E84E3762FDEB38AF2F6DB152CD78AF
        System.out.println("3.window acildiginda  tum WHD'leri : "+ driver.getWindowHandles());
        // 83E84E3762FDEB38AF2F6DB152CD78AF

        driver.get("https://www.wisequarter.com");


        // testotomasyonu anasayfanin acik oldugu window'a donun ve
        // anasayfada oldugunuzu test edin


        // electronics urunlerin oldugu window'a gidin
        // Home/Electronics yazdigini test edin


        // wisequarter'in acik oldugu window'a gidin
        // url'in wisequarter icerdigini test edin




        ReusableMethods.bekle(2);
    }
}
