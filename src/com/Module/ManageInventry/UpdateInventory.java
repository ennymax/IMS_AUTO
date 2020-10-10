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
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class UpdateInventory extends TestBaseC {
    @Test
    public void UPDATE_INVENTORY() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE INVENTORY");
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
        WebElement elementb = driver.findElement(By.xpath(Utility.fetchLocator("InventryActionBTN_XPATH")));
        JavascriptExecutor jsb = (JavascriptExecutor) driver;
        jsb.executeScript("arguments[0].click();", elementb);

        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        WebElement elementbp = driver.findElement(By.xpath(Utility.fetchLocator("UpdateInventry_XPATH")));
        JavascriptExecutor jsbp = (JavascriptExecutor) driver;
        jsbp.executeScript("arguments[0].click();", elementbp);

        WebElement des = driver.findElement(By.xpath(Utility.fetchLocator("InventryDes_XPATH")));
        des.clear();
        des.sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitSubmitBTN_XPATH"))).click();

        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Inventory was Updated Successfully");
        } else {
            test.log(Status.FAIL, "Inventory want Updated");
        }

        driver.quit();
        System.out.println("********************UPDATE INVENTORY********************");
    }
}
