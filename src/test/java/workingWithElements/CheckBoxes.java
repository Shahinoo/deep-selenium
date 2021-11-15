package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxes {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        // Maximum browser
        chromeDriver.manage().window().maximize();
        // Navigate
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void testCheckBoxes() throws InterruptedException {
        // find checkboxes elements
        Thread.sleep(2000);
        WebElement check1 = chromeDriver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement check2 = chromeDriver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        // Select Checkbox1
        check1.click();
        Thread.sleep(2000);
        // Select CheckBox2 in case it is not selected
        if (!check2.isSelected()) {
            check2.click();
        }
        Thread.sleep(2000);
        // Assert that checkboxes 1 and 2 are selected
        Assert.assertTrue(check1.isSelected());
        Assert.assertTrue(check2.isSelected());

    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
