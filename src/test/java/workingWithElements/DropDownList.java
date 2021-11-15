package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownList {
    ChromeDriver chromeDriver;

    @BeforeTest
    public void openBrowser() {
        String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromePath);
        chromeDriver = new ChromeDriver();
        // Maximum browser
        chromeDriver.manage().window().maximize();
        // Navigate
        chromeDriver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropDownList() throws InterruptedException {
        // find dropdown element
        WebElement optionList = chromeDriver.findElement(By.id("dropdown"));
        Select selectOptions = new Select(optionList);

        // assert that Select is not multiple selection
        Assert.assertFalse(selectOptions.isMultiple());
        // assert that select has 3 options
        Assert.assertEquals(3, selectOptions.getOptions().size());
        Thread.sleep(1000);

        // select option1 by visible text
        selectOptions.selectByVisibleText("Option 1");
        Thread.sleep(1000);
        // select option2 by value
        selectOptions.selectByValue("2");
        Thread.sleep(1000);
        // select option 1 by index
        selectOptions.selectByIndex(1);
        Thread.sleep(1000);


        // assert
        String option1Text = selectOptions.getFirstSelectedOption().getText();
        Assert.assertEquals("Option 1",option1Text);
        System.out.println(option1Text);
    }

    @AfterTest
    public void closeBrowser() {
        chromeDriver.quit();
    }
}
