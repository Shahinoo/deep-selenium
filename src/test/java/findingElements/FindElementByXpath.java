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
//        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
//        chromeDriver.navigate().to("https://the-internet.herokuapp.com/login");
        firefoxDriver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findElementByAbsoluteXpath() {
        WebElement userName = firefoxDriver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = firefoxDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginBtn = firefoxDriver.findElement(By.xpath("//*[@id=\"login\"]/button"));

        System.out.println(userName.getTagName());
        System.out.println(password.getTagName());
        System.out.println(loginBtn.getText());
    }

    @Test
    public void findElementByRelativeXpath() {
        // Find Relative Xpath
        WebElement userName = firefoxDriver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = firefoxDriver.findElement(By.xpath("//input[@id='password']"));
        // use regular expression in find Login Button with Xpath
        WebElement loginBtn = firefoxDriver.findElement(By.xpath("//button[@class='radius']"));

        System.out.println(userName.getTagName());
        System.out.println(password.getTagName());
        System.out.println(loginBtn.getText());
    }

    @AfterTest
    public void closeBrowser() {
        firefoxDriver.quit();
    }

}
