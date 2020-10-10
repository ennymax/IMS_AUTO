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

public class Suspend_UnsuspendCategory extends TestBaseA {

    @Test
    public void SUSPEND_UNSUSPEND_INVENTORY_CATEGORY() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND  INVENTORY CATEGORY");
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

        driver.findElement(By.xpath(Utility.fetchLocator("SuspendCategoryBTN_XPATH"))).click();

        login.AcceptAlert();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Category was Suspended successfully");
        } else {
            test.log(Status.FAIL, "Category suspension failed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CategoryActionBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendCategory_XPATH"))).click();

        login.AcceptAlert();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Category was Suspended successfully");
        } else {
            test.log(Status.FAIL, "Category suspension failed");
        }

        driver.quit();
        System.out.println("********************SUSPEND UNSUSPEND INVENTORY CATEGORY********************");
    }
}
