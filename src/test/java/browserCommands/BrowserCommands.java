package browserCommands;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserCommands {
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
        chromeDriver.navigate().to("https://the-internet.herokuapp.com");
    }

    @Test
    public void testBrowserCommands() {
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
        chromeDriver.navigate().back();
        chromeDriver.navigate().forward();
        chromeDriver.navigate().refresh();
        String url = chromeDriver.getCurrentUrl();
        System.out.println(url);


    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
