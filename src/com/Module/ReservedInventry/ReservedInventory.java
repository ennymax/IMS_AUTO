package com.Module.ReservedInventry;

import com.aventstack.extentreports.Status;
import com.base.TestBaseB;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;

public class ReservedInventory extends TestBaseB {
    @Test
    public void RESERVED_INVENTORY() throws IOException, InterruptedException {
        test = extent.createTest("RESERVED INVENTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLinkA brokenLinkA = new BrokenLinkA(driver);
        ScreenShotA screenShotA = new ScreenShotA(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomWords randomWords = new RandomWords();

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000000000);
        driver.findElement(By.xpath(Utility.fetchLocator("ReservedInventry_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ReservedInventry_XPATH"))).click();





        driver.quit();
        System.out.println("********************RESERVED INVENTORY********************");
    }

}
