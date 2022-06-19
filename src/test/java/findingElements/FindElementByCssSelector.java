package findingElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByCssSelector {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findCssSelector() {
        //Find Login BTN by Css selector
        WebElement loginBtn = chromeDriver.findElement(By.cssSelector("button.radius"));
        WebElement userName = chromeDriver.findElement(By.cssSelector("input#username"));
        System.out.println(loginBtn.getText());
        System.out.println(userName.getTagName());
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
