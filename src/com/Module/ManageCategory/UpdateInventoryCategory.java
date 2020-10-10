package com.Module.ManageCategory;

import com.aventstack.extentreports.Status;
import com.base.TestBaseA;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateInventoryCategory extends TestBaseA {

    @Test
    public void UPDATE_INVENTORY_CATEGORY() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE INVENTORY CATEGORY");
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

        driver.findElement(By.xpath(Utility.fetchLocator("UpdateCategoryBTN_XPATH"))).click();

        WebElement kkkk = driver.findElement(By.xpath(Utility.fetchLocator("CategoryDescrition_XPATH")));
        kkkk.clear();
        kkkk.sendKeys(Utility.fetchLocator("Decrib_TEXT") + randomWords.RandomWords());

        driver.findElement(By.xpath(Utility.fetchLocator("SubmitCategoryBTN_XPATH"))).click();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Inventory was Created Successfully");
        } else {
            test.log(Status.FAIL, "Inventory want Created");
        }

        driver.quit();
        System.out.println("********************UPDATE INVENTORY CATEGORY********************");
    }

}
