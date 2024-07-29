package day12_excelOtomasyon_Screenshot_JsExecutor;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

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
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // 		- 1.satirdaki 2.hucreye gidelim ve yazdirin
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)
        //		- 1.satirdaki 2.hucreyi bir string degiskene atayin ve  degerinin Başkent (İngilizce) oldugunu test edin

        String expectedYazi = "Başkent (İngilizce)";
        String actualYazi = sayfa1.getRow(0).getCell(1).toString();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //		- 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin

        String expectedBaskent = "Kabil";
        String actualBaskent = sayfa1.getRow(1).getCell(3).toString();

        Assertions.assertEquals(expectedBaskent,actualBaskent);
        //		- Ulke sayisinin 190 oldugunu test edin

        int expectedUlkeSayisi = 190;
        int actualUlkeSayisi = sayfa1.getLastRowNum() + 1 - 1;
        // getLastRowNum() bize index verdigi icin 191 satir kullanildigi halde 190 verecek
        // eger kac satir kullanildigini bulmak istersek buna 1 eklememiz gerekiyor
        // Ancak en basta baslik oldugundan,
        // ulke sayisini bulmak icin kullanilan satir sayisindan 1 cikarmak gerekiyor

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

        //		- Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin

        int expectedKullanilanSatirSayisi = 191 ;
        int actualKullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);
        // kullanilan satir sayisini bulmak icin
        // sayfa1.getLastRowNum() + 1 de kullanilabilir
        // ANCAK arada bos satirlar varsa
        // - getPhysicalNumberOfRows() bos satirlari saymaz, sadece dolulari sayar
        // - sayfa1.getLastRowNum() + 1 dersek bos satirlar da sayilmis olur

        //		- Ingilizce ismi Netherlands olan ulkenin
        //		baskentinin turkce Amsterdam oldugunu test edin
        String satirdakiTurkceBaskentIsmi="";

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Netherlands")){
                satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();
            }


        }
        Assertions.assertEquals("Amsterdam",satirdakiTurkceBaskentIsmi);

        //      - Turkce baskent isimlerinde Ankara bulundugunu test edin

        // bu soruyu iki turlu cozebiliriz
        // 1- for loop ve flag kullanalim

        boolean ankaraVarMi = false;

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

           satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();

           if (satirdakiTurkceBaskentIsmi.equalsIgnoreCase("Ankara")){
               ankaraVarMi = true;
               break;
           }

        }

        Assertions.assertTrue(ankaraVarMi);


        // 2.yol ingilizce ulke ismini Key, turkce baskent ismini value olarak secip
        //       tum ulkelerin bu iki bilgisini bir map'e ekleyelim

        Map<String,String > ulkelerMap = new TreeMap<>();

        for (int i = 1; i <=sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();

            ulkelerMap.put(satirdakiIngilizceUlkeIsmi,satirdakiTurkceBaskentIsmi);

        }

        System.out.println(ulkelerMap);

        // ulkeler map'inde baskent olarak Ankara bulundugunu test edin

        Assertions.assertTrue(ulkelerMap.containsValue("Ankara"));

        // ulkeler map'inde baskent olarak Berlin bulundugunu test edin

        Assertions.assertTrue(ulkelerMap.containsValue("Berlin"));

        // ulkeler map'inde ulke olarak Nepal bulundugunu test edin

        Assertions.assertTrue(ulkelerMap.containsKey("Nepal"));


        // 195.satirin, 1.hucresini yazdirin
        // System.out.println(sayfa1.getRow(194).getCell(0)); // NullPointerException

        // 3.satirdaki 10.hucreyi yazdirin
        System.out.println(sayfa1.getRow(10).getCell(9)); // null

    }
}
