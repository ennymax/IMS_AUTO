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
import java.security.SecureRandom;

public class RemoveInventoryStatusRule extends TestBaseB {

    @Test
    public void REMOVE_INVENTORY_STATUS_RULE() throws IOException, InterruptedException {
        test = extent.createTest("REMOVE INVENTORY STATUS RULE");
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

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("InventoryStatusBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2200);
        WebElement elementt = driver.findElement(By.xpath(Utility.fetchLocator("AssertInventoryStatusRule_XPATH")));
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        jst.executeScript("arguments[0].click();", elementt);

        Thread.sleep(2200);
        WebElement elementtg = driver.findElement(By.xpath(Utility.fetchLocator("ActionStatustorule_XPATH")));
        JavascriptExecutor jstg = (JavascriptExecutor) driver;
        jstg.executeScript("arguments[0].click();", elementtg);

        WebElement elementtgn = driver.findElement(By.xpath(Utility.fetchLocator("RemoverBTN_XPATH")));
        JavascriptExecutor jstgn = (JavascriptExecutor) driver;
        jstgn.executeScript("arguments[0].click();", elementtgn);

        login.AlertDismis();

        driver.quit();
        System.out.println("********************REMOVE INVENTORY STATUS RULE********************");
    }
}
