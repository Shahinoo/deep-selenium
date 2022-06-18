package findingElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXpath {
    ChromeDriver chromeDriver;
    FirefoxDriver firefoxDriver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
//        firefoxDriver = new FirefoxDriver();
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
//        firefoxDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findElementByRelativeXpath() {
        WebElement userName = chromeDriver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = chromeDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginBtn = chromeDriver.findElement(By.xpath("//*[@id=\"login\"]/button"));

        System.out.println("relative path:\n" + userName.getTagName());
        System.out.println(password.getTagName());
        System.out.println(loginBtn.getText());
    }

    @Test
    public void findElementByAbsoluteXpath() {
        // Find Relative Xpath
        WebElement userName = chromeDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div/input"));
        WebElement password = chromeDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div/input"));
        // use regular expression in find Login Button with Xpath
        WebElement loginBtn = chromeDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button"));

        System.out.println("Absolute path:\n" + userName.getTagName());
        System.out.println( password.getTagName());
        System.out.println( loginBtn.getText());
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }

}
