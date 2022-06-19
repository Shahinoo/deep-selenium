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
        // use findElement(s) method>> get all elements that meet the condition
        List<WebElement> links = chromeDriver.findElements(By.tagName("a"));
        //verify
        System.out.println(links.size());
        // Assert
        Assert.assertEquals(46, links.size());
        for (WebElement link: links){
            System.out.println(link.getAttribute("href"));
        }
    }

    @Test
    public void findSpecificElement() {
        // find specific element
        WebElement link = chromeDriver.findElements(By.tagName("a")).get(5);
        //verify
        System.out.println(link.getAttribute("href"));
    }

    @Test
    public void findFirstElement() {
        // because I used findElement method without (s), it will capture first element and break
        WebElement link = chromeDriver.findElement(By.tagName("a"));
        //verify
        System.out.println(link.getAttribute("href"));
    }



    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
