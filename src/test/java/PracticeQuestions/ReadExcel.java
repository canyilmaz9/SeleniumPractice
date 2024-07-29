package PracticeQuestions;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test02() throws IOException {

        // excel'deki Sayfa1'de 12.satir 3. datasini yazdirin

        // Sayfa1'e kadar tum adimlari atmak zorundayiz

        String dosyaYolu = "src/test/java/PracticeQuestions/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // workbook olusturup excel'deki tum bilgileri workbook'a yukledik
        // bundan sonra workbook'da var olan bilgileri alacagiz, bunun icin get...() kullaniriz
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        System.out.println(sayfa1.getRow(11).getCell(2)); // Azerbaycan

        // 17.satir 2.sutundaki bilginin Bolivya oldugunu test edin

        String expectedData = "Minsk";
        String actualData = sayfa1.getRow(16).getCell(1).toString();

        Assertions.assertEquals(expectedData,actualData);

    }
}
