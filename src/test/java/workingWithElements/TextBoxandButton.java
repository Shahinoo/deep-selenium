package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxandButton {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        // Maximum browser
        chromeDriver.manage().window().maximize();
        // Full screen browser
        chromeDriver.manage().window().fullscreen();
        // Navigate
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginScreen() throws InterruptedException {
        // find elements
        WebElement usernameTxt = chromeDriver.findElement(By.id("username"));
        WebElement passwordTxt = chromeDriver.findElement(By.id("password"));
        WebElement loginBtn = chromeDriver.findElement(By.className("radius"));
        // clear old values if exist
        usernameTxt.clear();
        passwordTxt.clear();
        // insert values
        usernameTxt.sendKeys("tomsmith");
        passwordTxt.sendKeys("SuperSecretPassword");
        // Click on login Button
        loginBtn.click();

        // display text
        WebElement invalidMessage = chromeDriver.findElement(By.id("flash"));
        String messageText = invalidMessage.getText();
        System.out.println(messageText);
        // Assert
        Assert.assertEquals("Your password is invalid!\n×",messageText);
        // Assert True - contains
        Assert.assertTrue(messageText.contains("invalid"));
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
