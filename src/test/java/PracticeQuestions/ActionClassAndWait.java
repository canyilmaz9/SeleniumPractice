package PracticeQuestions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.time.Duration;

public class ActionClassAndWait extends TestBaseEach {

    @Test
    public void test01() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        WebElement hoverMe = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));

        actions.moveToElement(hoverMe).perform();

        ReusableMethods.bekle(2);
        // 3. "Link 1" e tiklayin
        WebElement button = driver.findElement(By.xpath("(//a[text()='Link 1'])[1]"));
        button.click();

        //    --- (//a[@class='list-alert'])[1]
        // 4. Popup mesajini yazdirin
        String jsPane = driver.switchTo().alert().getText();
        System.out.println(jsPane);

        // 5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6. "Click and hold" kutusuna basili tutun

        WebElement clickAndHoldButonu = driver.findElement(By.xpath("//p[text()='Click and Hold!']"));
        actions.clickAndHold(clickAndHoldButonu);

        // 7. "Click and hold" kutusunda cikan yaziyi yazdirin

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement hold = driver.findElement(By.xpath("//div[text()='Well done! keep holding that click now.....']"));
        wait.until(ExpectedConditions.visibilityOf(hold));

        System.out.println(hold.getText());

        // 8. "Double click me" butonunu cift tiklayin

        WebElement doubleClickMe = driver.findElement(By.id("double-click"));

        actions.doubleClick(doubleClickMe).perform();



    }
}
