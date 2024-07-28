package PracticeQuestions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class WebTable extends TestBaseEach {

    @Test
    public void test01(){

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
        //[First Name, Last Name, Age, Email, Salary, Department, Action]
        List<WebElement> headersButunBasliklar = driver.findElements(By.xpath("//div[@role='columnheader']"));

        System.out.println(ReusableMethods.getStringList(headersButunBasliklar));
        //[First Name, Last Name, Age, Email, Salary, Department, Action]

        // 3. 3.sutunun basligini yazdirin

        System.out.println("3. sutunun basligi : " +headersButunBasliklar.get(2).getText());
        //3. sutunun basligi: Age

        System.out.println("==============================================");

        // 4. Tablodaki tum datalari yazdirin

        List<WebElement> tumDataElementleriList = driver.findElements(By.xpath("//div[@role='grid']"));

        System.out.println("Data Elementleri: ");
        for (WebElement element : tumDataElementleriList) {

            System.out.println(element.getText());
        }
        //First Name
        //Last Name
        //Age
        //Email
        //Salary
        //Department
        //Action
        //Cierra
        //Vega
        //39
        //cierra@example.com
        //10000
        //Insurance
        //Alden
        //Cantrell
        //45
        //alden@example.com
        //12000
        //Compliance
        //Kierra
        //Gentry
        //29
        //kierra@example.com
        //2000
        //Legal

        System.out.println("===========");
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        //Bos olmayan cell sayisi: 18
        List<WebElement> cellList = driver.findElements(By.xpath("//div[@class='rt-td']"));

        int doluCellSayisi = 0;
        for (WebElement element : cellList) {

            if (!(element.getText().isBlank())){
                doluCellSayisi++;
            }

        }

        System.out.println("Bos olmayan cell sayisi: " + doluCellSayisi);

        System.out.println("===========");
        // 6. Tablodaki satir sayisini yazdirin
        //Tablodaki satir sayisi : 3
        List <WebElement> Satirlar = driver.findElements(By.xpath("//div[@class='rt-tr -odd'] | //div[@class= 'rt-tr -even']"));

        System.out.println("Tablodaki satir sayisi : " + Satirlar.size() );

        System.out.println("===========");
        // 7. Tablodaki sutun sayisini yazdirin
        //sutun sayisi: 7

        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//div[@class='rt-tr -even']//*[@class='rt-td']"));

        System.out.println("sutun sayisi: " + sutunSayisi.size());

        System.out.println("===========");
        // 8. Tablodaki 3.kolonu yazdirin
        //3. sutun elementleri : [39, 45, 29]

        List <WebElement> ucuncuSutun = driver.findElements(By.xpath("//div[@class='rt-tr -odd']//*[@role='gridcell'][3] | //div[@class='rt-tr -even']//*[@role='gridcell'][3]"));

        System.out.println("3. sutun elementleri : " + ReusableMethods.getStringList(ucuncuSutun));

        System.out.println("===========");
        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //Salary of Kierra : 2000

        List <WebElement> birinciSutun = driver.findElements(By.xpath("//*[@role='gridcell'][1]"));
        List <WebElement> besinciSutun = driver.findElements(By.xpath("//div[@class='rt-tr -odd']//*[@role='gridcell'][5] | //div[@class='rt-tr -even']//*[@role='gridcell'][5]"));

        for (int i = 0; i < 3; i++) {
            if (birinciSutun.get(i).getText().equalsIgnoreCase("Kierra")){
                String salary = besinciSutun.get(i).getText();
                System.out.println("Salary of Kierra : " + salary);
            }
        }

        System.out.println("===========");
        // 10. bir method olusturun, satir ve sutun sayisi girildiğinde datayi yazdirsin

        System.out.println(getCellData(2, 2));
        //Cantrell

    }

    public String getCellData (int satir, int sutun){

            if( satir > 3) {
                System.out.println("Yanlis satir sayisi girdiniz");
            }

             String dinamikXpath = "(//*[@class='rt-tr-group'])["+ satir +"]//*[@class='rt-td'][" + sutun+"]";

            WebElement istenenWebElement = driver.findElement(By.xpath(dinamikXpath));
            String istenenStringElement = istenenWebElement.getText();

        return istenenStringElement;
    }
}
