package com.Module.BinCard;

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
import java.util.concurrent.TimeUnit;

public class ViewBinCard extends TestBaseC {

    @Test
    public void VIEW_BIN_CARD() throws IOException, InterruptedException {
        test = extent.createTest("VIEW BIN CARD");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        BrokenLinkC brokenLinkC = new BrokenLinkC(driver);
        ScreenShotC screenShotC = new ScreenShotC(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("BinCardBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("BinCardBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBinCertCaption_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Bin card Page Displayed successfully");
        } else {
            test.log(Status.FAIL, "Bin card page failed to load");
        }

        Thread.sleep(1200);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("FilterStore_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(10);

        Thread.sleep(1200);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("FilterByInventry_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(1);

        Thread.sleep(2000);
        WebElement elementc = driver.findElement(By.xpath(Utility.fetchLocator("LoadRecord_XPATH")));
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].click();", elementc);

        Thread.sleep(2000);
        screenShotC.ScreenShotC();

        driver.quit();
        System.out.println("********************VIEW BIN CARD********************");
    }
}
