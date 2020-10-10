package com.Module.ManageInventry;

import com.aventstack.extentreports.Status;
import com.base.TestBaseC;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class ReceiveInventory extends TestBaseC {

    @Test
    public void Received_INVENTORY() throws IOException, InterruptedException {
        test = extent.createTest("Received INVENTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLinkC brokenLinkC = new BrokenLinkC(driver);
        ScreenShotC screenShotC = new ScreenShotC(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomWords randomWords = new RandomWords();
        RandomNumbers randomNumbers = new RandomNumbers();

        SecureRandom rn = new SecureRandom();
        int role = rn.nextInt(11) + 1;
        int role1 = rn.nextInt(10) + 1;

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("InventoryBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("InventoryBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        screenShotC.ScreenShotC();
        WebElement elementg = driver.findElement(By.xpath(Utility.fetchLocator("ManageInventry_XPATH")));
        JavascriptExecutor jsg = (JavascriptExecutor) driver;
        jsg.executeScript("arguments[0].click();", elementg);

        Thread.sleep(2000);
        WebElement elementb = driver.findElement(By.xpath(Utility.fetchLocator("RecieveInventryBtn_XPATH")));
        JavascriptExecutor jsb = (JavascriptExecutor) driver;
        jsb.executeScript("arguments[0].click();", elementb);

        login.AcceptAlert();

        Thread.sleep(2500);
        driver.findElement(By.xpath(Utility.fetchLocator("RecieveInventryBatchNumber_XPATH"))).sendKeys(Utility.fetchLocator("a_TEXT")+ randomNumbers.RandomNumbers());

        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        driver.findElement(By.xpath(Utility.fetchLocator("QauntityRecieved_XPATH"))).sendKeys("1");

        Thread.sleep(1500);
        WebElement ele111d = driver.findElement(By.xpath(Utility.fetchLocator("SelectSuppliers_XPATH")));
        Select sel11d = new Select(ele111d);
        sel11d.selectByIndex(role1);

        driver.findElement(By.xpath(Utility.fetchLocator("Manufacture_XPATH"))).sendKeys("Manufacture"+ randomNumbers.RandomNumbers());

        screenShotC.ScreenShotC();
        driver.findElement(By.xpath(Utility.fetchLocator("NextBTN_XPATH_XPATH"))).click();

        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        driver.findElement(By.xpath(Utility.fetchLocator("RecieveRecieveBTN_XPATH"))).click();

        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Inventory was Received Successfully");
        } else {
            test.log(Status.FAIL, "Inventory want Received");
        }

        driver.quit();
        System.out.println("********************Received INVENTORY********************");
    }
}
