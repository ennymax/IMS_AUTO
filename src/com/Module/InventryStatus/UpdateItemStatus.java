package com.Module.InventryStatus;

import com.aventstack.extentreports.Status;
import com.base.TestBaseB;
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

public class UpdateItemStatus extends TestBaseB {

    @Test
    public void Update_INVENTORY_STATUS() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE INVENTORY STATUS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLinkB brokenLinkB = new BrokenLinkB(driver);
        ScreenShotB screenShotB = new ScreenShotB(driver);
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

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("InventoryStatusBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("InventoryStatusBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementt = driver.findElement(By.xpath(Utility.fetchLocator("InVentoryStatus_XPATH")));
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        jst.executeScript("arguments[0].click();", elementt);

        Thread.sleep(1500);
        WebElement elementtb = driver.findElement(By.xpath(Utility.fetchLocator("NewStatusActionBTN_XPATH")));
        JavascriptExecutor jstb = (JavascriptExecutor) driver;
        jstb.executeScript("arguments[0].click();", elementtb);

        Thread.sleep(1500);
        WebElement elementtbv = driver.findElement(By.xpath(Utility.fetchLocator("NewStatusUpdateBTN_XPATH")));
        JavascriptExecutor jstbv = (JavascriptExecutor) driver;
        jstbv.executeScript("arguments[0].click();", elementtbv);

        driver.findElement(By.xpath(Utility.fetchLocator("StatusDescription_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT") + randomWords.RandomWords());

        driver.findElement(By.xpath(Utility.fetchLocator("NewStatusSubmitBTN_XPATH"))).click();

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertNewStatusCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Status Created Successfully");
        } else {
            test.log(Status.FAIL, "New Status Cant br created");
        }

        Thread.sleep(3000);
        screenShotB.ScreenShotB();

        driver.quit();
        System.out.println("********************UPDATE INVENTORY STATUS********************");
    }
}
