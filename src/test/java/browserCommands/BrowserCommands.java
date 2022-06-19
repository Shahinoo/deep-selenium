package browserCommands;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserCommands {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        // Maximum browser
        chromeDriver.manage().window().maximize();
        Thread.sleep(2000);
        // Full screen browser
        chromeDriver.manage().window().fullscreen();
        Thread.sleep(2000);
        // Maximum browser
        chromeDriver.manage().window().maximize();
        // Navigate
        chromeDriver.navigate().to("https://the-internet.herokuapp.com");
        Thread.sleep(2000);

    }

    @Test
    public void browserNavigation() throws InterruptedException{
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
        Thread.sleep(1000);
        chromeDriver.navigate().back();
        Thread.sleep(1000);
        chromeDriver.navigate().forward();
        Thread.sleep(1000);
        chromeDriver.navigate().refresh();
        Thread.sleep(1000);
        String url = chromeDriver.getCurrentUrl();
        System.out.println(url);
    }

    @Test
    public void screenSize() throws InterruptedException{
        // Use get method to open url
        chromeDriver.get("https://the-internet.herokuapp.com/login");
        Thread.sleep(1000);
        // Use Dimension Class to set screen sizes
        Dimension iphoneXR = new Dimension(414, 896);
        Dimension ipadAir = new Dimension(820, 1180);
        chromeDriver.manage().window().setSize(iphoneXR);
        Thread.sleep(1000);
        chromeDriver.manage().window().setSize(ipadAir);
        Thread.sleep(1000);


    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
