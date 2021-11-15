package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        // Maximum browser
        chromeDriver.manage().window().maximize();
        // Navigate
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void webTables() throws InterruptedException {
        // find element of the table
        WebElement webTable = chromeDriver.findElement(By.id("table1"));
        // get all rows
        List<WebElement> rows = webTable.findElements(By.tagName("tr"));
        // Assert the size of rows
        Assert.assertEquals(5, rows.size());
        // get all cells data
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.println(col.getText());
            }
            System.out.println();
        }
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
