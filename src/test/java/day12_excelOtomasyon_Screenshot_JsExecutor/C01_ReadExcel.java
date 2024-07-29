package day12_excelOtomasyon_Screenshot_JsExecutor;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws FileNotFoundException {

        //      gerekli ayarlamalari yapip ulkeler excelindeki Sayfa1'e gidin

        // String dosyaYolu = "src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";
        // Eger calisacagimiz dosya proje klasorunun icinde degilse
        // proje ekibindeki herkesin calistirabilmesi icin
        // dosya yolunu dinamik yapmak gerekir

        System.out.println(System.getProperty("user.dir")); // projenin dosya yolunu verir
        //   /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team144_JUnit

        System.out.println(System.getProperty("user.home")); // kodun calistigi bilgisayarin ana dosya yolunu verir
        //   /Users/ahmetbulutluoz

        String dinamikDosyaYolu = System.getProperty("user.dir")+"/"+ "src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dinamikDosyaYolu);

        // 		- 1.satirdaki 2.hucreye gidelim ve yazdirin

        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdirin
        //		- 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
        //		- Ulke sayisinin 190 oldugunu test edin
        //		- Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        //		- Ingilizce ismi Netherland olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        //      - Turkce baskent isimlerinde Ankara bulundugunu test edin
    }
}
