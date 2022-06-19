package findingElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementById {

    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findIdElement() {
        WebElement userName = chromeDriver.findElement(By.id("username"));
        WebElement password = chromeDriver.findElement(By.id("password"));
        System.out.println(userName.getTagName());
        System.out.println(password.getTagName());
        System.out.println(userName.getAttribute("id"));
    }

    @Test
    public void findIdElementUsingByClass() {
        By userName = By.id("username");
        By password = By.id("password");
        WebElement usernameElement = chromeDriver.findElement(userName);
        WebElement passwordElement = chromeDriver.findElement(password);
        System.out.println(usernameElement.getTagName());
        System.out.println(passwordElement.getTagName());
        System.out.println(usernameElement.getAttribute("id"));
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}

