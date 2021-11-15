package findingElements;

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
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findIdElement() {
        WebElement userName = chromeDriver.findElement(By.id("username"));
        WebElement password = chromeDriver.findElement(By.id("password"));
        System.out.println(userName.getTagName());
        System.out.println(password.getTagName());
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
