package com.Module.ManageCategory;

import com.aventstack.extentreports.Status;
import com.base.TestBaseA;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class RemoveCategory extends TestBaseA {
    @Test
    public void REMOVE_CATEGORY() throws IOException, InterruptedException {
        test = extent.createTest("REMOVE CATEGORY");
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
            test.log(Status.PASS, "Login was successfull");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ManageCATEGORYBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("CategoryActionBTN_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("RemoveCAtegory_XPATH"))).click();

        login.AlertDismis();

        driver.quit();
        System.out.println("********************REMOVE CATEGORY********************");
    }

}
