package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        // Maximum browser
        chromeDriver.manage().window().maximize();
        // Navigate
        chromeDriver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
    }

    @Test
    public void dragAndDropElement() throws InterruptedException {
        // find drag element
        WebElement source = chromeDriver.findElement(By.id("draggable"));
        // find drop element
        WebElement target = chromeDriver.findElement(By.id("droppable"));

        // Use Actions class to use dragAndDrop method
        Actions builder = new Actions(chromeDriver);
        builder.dragAndDrop(source,target);
        builder.perform();
        Thread.sleep(2000);

        // Assert that text of target element is changed from drop here to dropped
        Assert.assertEquals("Dropped!",target.getText());

    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
