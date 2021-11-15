package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerificationAndAssertion {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        // Maximum browser
        chromeDriver.manage().window().maximize();
        // Navigate
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test (priority = 0)
    public void invalidLogin() {
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

    }

    @Test(priority = 1)
    public void assertTrueInvalidMessage() {
        // Verifying - display text
        WebElement invalidMessage = chromeDriver.findElement(By.xpath("//div[@id='flash']"));
        String messageText = invalidMessage.getText();
        System.out.println(messageText);
        // Assert True - contains part of the message
        Assert.assertTrue(messageText.contains("invalid"));
    }

    @Test(priority = 2)
    public void assertEqualInvalidMessage() {
        // Verifying - display text
        WebElement invalidMessage = chromeDriver.findElement(By.xpath("//div[@id='flash']"));
        String messageText = invalidMessage.getText();
        System.out.println(messageText);
        // Assert equals all message
        Assert.assertEquals("Your password is invalid!\n×", messageText);
    }

    @Test(priority = 3)
    public void assertLoginBtn() {
        WebElement loginBtn = chromeDriver.findElement(By.className("radius"));
        // Verifying - get text of Login Button
        loginBtn.getText();
        // Assert equals
        Assert.assertEquals("Login", loginBtn.getText());
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}

