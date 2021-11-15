package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindingLinks {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findByLinkText() {
        WebElement seleniumLink = chromeDriver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumLink.getAttribute("href"));

    }

    @Test
    public void findByPartialLinkText() {
        WebElement seleniumLink = chromeDriver.findElement(By.partialLinkText("Elemental"));
        System.out.println(seleniumLink.getAttribute("href"));

    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
