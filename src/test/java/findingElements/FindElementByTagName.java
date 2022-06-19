package findingElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementByTagName {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void findTagNameElement() {

        WebElement table = chromeDriver.findElement(By.id("table1"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> columns = table.findElements(By.tagName("td"));

        System.out.println(rows.size());
        System.out.println(columns.size());
        System.out.println(rows.get(3).getText());
        System.out.println(columns.get(1).getText());
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
