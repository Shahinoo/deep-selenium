package findingElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByClassName {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {

        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findClassNameElement() {
        WebElement userName = chromeDriver.findElement(By.name("username"));
        WebElement password = chromeDriver.findElement(By.name("password"));
        // find element by Class name
        WebElement loginBtn = chromeDriver.findElement(By.className("radius"));

        System.out.println(userName.getTagName());
        System.out.println(password.getTagName());
        System.out.println(loginBtn.getTagName());

    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
