package browserCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetTitlePageSource {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        // Use WebDriverManager dependency to open browser directly
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void getURL() {
       String currentURL = chromeDriver.getCurrentUrl();
        System.out.println("Current URL is " + currentURL );
    }
    @Test
    public void getTitle() {
        String title = chromeDriver.getTitle();
        System.out.println("Title is " +  title);
    }
    @Test
    public void getPageSource() {
        String pageSource = chromeDriver.getPageSource();
        System.out.println("here is the page source \n"+  pageSource );
    }
    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }

}

