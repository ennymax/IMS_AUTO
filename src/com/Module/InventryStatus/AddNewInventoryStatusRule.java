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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;

public class AddNewInventoryStatusRule extends TestBaseB {

    @Test
    public void ADD_NEW_INVENTORY_STATUS_RULE() throws IOException, InterruptedException {
        test = extent.createTest("ADD NEW INVENTORY STATUS RULE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLinkB brokenLinkB = new BrokenLinkB(driver);
        ScreenShotB screenShotB = new ScreenShotB(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomWords randomWords = new RandomWords();

        SecureRandom rn = new SecureRandom();
        int role = rn.nextInt(4) + 1;
        int selectrole = rn.nextInt(24) + 1;
        int selectrole1 = rn.nextInt(24) + 1;

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

        WebElement elementt = driver.findElement(By.xpath(Utility.fetchLocator("AssertInventoryStatusRule_XPATH")));
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        jst.executeScript("arguments[0].click();", elementt);

        WebElement elementtj = driver.findElement(By.xpath(Utility.fetchLocator("NewInventoryStatusBTN_XPATH")));
        JavascriptExecutor jstj = (JavascriptExecutor) driver;
        jstj.executeScript("arguments[0].click();", elementtj);

        Thread.sleep(1200);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("RoleAdmin_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(role);

        Thread.sleep(1200);
        WebElement ele11l = driver.findElement(By.xpath(Utility.fetchLocator("SelectRole_XPATH")));
        Select sel1l = new Select(ele11l);
        sel1l.selectByIndex(selectrole);

        Thread.sleep(1200);
        WebElement ele11ll = driver.findElement(By.xpath(Utility.fetchLocator("SelectRole2_XPATH")));
        Select sel1ll = new Select(ele11ll);
        sel1ll.selectByIndex(selectrole1);

        driver.findElement(By.xpath(Utility.fetchLocator("Desdes_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("SubmitStatustorole_XPATH"))).click();

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertNewStatusCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status added Successfully");
        } else {
            test.log(Status.FAIL, "Status Cant be added");
        }

        screenShotB.ScreenShotB();

        driver.quit();
        System.out.println("********************ADD NEW INVENTORY STATUS RULE********************");
    }
}
