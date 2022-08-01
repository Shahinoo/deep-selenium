package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DoubleClick {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        // Maximum browser
        chromeDriver.manage().window().maximize();
        // Navigate
        chromeDriver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
    }

    @Test
    public void doubleClickOnElement() throws InterruptedException {
        // find elements
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement message = chromeDriver.findElement(By.id("message"));
        // verify background color before double click
        String backgroundColor = message.getCssValue("background-color");
        System.out.println(backgroundColor);

        // use Action interface to use double click method
        Actions builder = new Actions(chromeDriver);
        builder.doubleClick(message);
        builder.perform();
        Thread.sleep(4000);

        //Verify background color after double click
        String backgroundColorResult = message.getCssValue("background-color");
        System.out.println(backgroundColorResult);
        // Assert the color is changed after double click
        Assert.assertEquals("rgba(255, 255, 0, 1)", backgroundColorResult);
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
