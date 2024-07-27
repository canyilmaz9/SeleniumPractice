package PracticeQuestions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class iFrame_Homework extends TestBaseEach {

    @Test
    public void test01(){

            //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
            driver.get("http://webdriveruniversity.com/IFrame/index.html");

            // 2. “Our Products” butonuna basin

            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame']")));

            driver.findElement(By.xpath("//a[text()='Our Products']")).click();

            // 3. “Cameras product”i tiklayin

            //WebElement iFrame1 = driver.findElement(By.id("frame"));

            //driver.switchTo().frame(iFrame1);
            driver.findElement(By.id("camera-img")).click();

            // 4. Popup mesajini yazdirin

            ReusableMethods.bekle(2);

            Actions actions = new Actions(driver);

            actions.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.bekle(2);
            String popupHeader = driver.findElement(By.className("modal-header")).getText();
            String popupBody = driver.findElement(By.className("modal-body")).getText();
            System.out.println(popupHeader+" "+popupBody);

            // 5. “close” butonuna basin

            ReusableMethods.bekle(1);
            driver.findElement(By.xpath("//button[text()='Close']")).click();
            // 6. "WebdriverUniversity.com (IFrame)" linkini tiklayin

            driver.switchTo().defaultContent();

            driver.findElement(By.xpath("//a[text()='WebdriverUniversity.com (IFrame)']")).click();
            // 7. "https://webdriveruniversity.com/index.html" adresine gittigini test edin
            Assertions.assertEquals("https://webdriveruniversity.com/index.html",driver.getCurrentUrl().toString());

            ReusableMethods.bekle(3);


    }
}
