package findingElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com");
    }

    @Test
    public void findElements() {
        // get all the links displayed on page and common with the tag name <a>
        List<WebElement> links = chromeDriver.findElements(By.tagName("xyz"));
        //verify
        System.out.println(links.size());
        Assert.assertEquals(46, links.size());
        for (WebElement link: links){
            System.out.println(link.getAttribute("href"));
        }
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
