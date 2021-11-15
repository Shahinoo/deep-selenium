package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckElementPresence {
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
    public void checkElementPresence() throws InterruptedException {
        // use the method to check presence of the element
        // find the element if exist
        if (isElementPresent(By.xpath("//form[@id='checkboxes']/input[5]"))) {
            WebElement check1 = chromeDriver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
            // select the checkbox if not selected
            if (!check1.isSelected()) {
                check1.click();
                Thread.sleep(2000);
            }
        }
        // display this message if the element not exist
        else {
            Assert.fail("Checkbox1 doesn't exist");
        }
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }

    // Private method to check the presence of the element
    private boolean isElementPresent(By by) {
        // return true when find the element
        try {
            chromeDriver.findElement(by);
            return true;
        }
        // Else display exception and return false
        catch (NoSuchElementException e) {
            return false;
        }


    }
}

