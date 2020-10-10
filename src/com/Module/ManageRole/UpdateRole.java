package com.Module.ManageRole;

import com.aventstack.extentreports.Status;
import com.base.TestBaseD;
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
import java.util.concurrent.TimeUnit;

public class UpdateRole extends TestBaseD {

    @Test
    public void UPDATE_ROLE() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        BrokenLinkD brokenLinkD = new BrokenLinkD(driver);
        ScreenShotD screenShotD = new ScreenShotD(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomWords ramdomwords = new RandomWords();

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("ManageRoleBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ManageRoleBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRoleName_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Role Could be Viewed ");
        } else {
            test.log(Status.FAIL, "Role page could not be Viewed");
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement elementuu = driver.findElement(By.xpath(Utility.fetchLocator("RoleUpdateBTN_XPATH")));
        JavascriptExecutor jsuu = (JavascriptExecutor) driver;
        jsuu.executeScript("arguments[0].click();", elementuu);

        Thread.sleep(1000);
        WebElement elementuu11 = driver.findElement(By.xpath(Utility.fetchLocator("RoleSubit_XPATH")));
        JavascriptExecutor jsuu11 = (JavascriptExecutor) driver;
        jsuu11.executeScript("arguments[0].click();", elementuu11);

        Thread.sleep(2000);
        screenShotD.ScreenShotD();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Role Updated successfully");
        } else {
            test.log(Status.FAIL, "Role was successfully");
        }

        driver.quit();
        System.out.println("********************UPDATE ROLE********************");
    }
}
