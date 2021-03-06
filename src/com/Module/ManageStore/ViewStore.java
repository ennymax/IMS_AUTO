package com.Module.ManageStore;

import com.aventstack.extentreports.Status;
import com.base.TestBaseF;
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

public class ViewStore extends TestBaseF {

    @Test
    public void VIEW_STORE() throws IOException, InterruptedException {
        test = extent.createTest("VIEW STORE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        BrokenLinkF brokenLinkF = new BrokenLinkF(driver);
        ScreenShotF screenShotF = new ScreenShotF(driver);
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
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("ManageStoreBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ManageStoreBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageStore_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Role Could be Viewed ");
        } else {
            test.log(Status.FAIL, "Role page could not be Viewed");
        }

        WebElement Element1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertManageStore_XPATH")));
        JavascriptExecutor jsk1 = (JavascriptExecutor) driver;
        jsk1.executeScript("arguments[0].scrollIntoView();", Element1);

        Thread.sleep(2000);
        screenShotF.ScreenShotF();

        driver.quit();
        System.out.println("********************VIEW STORE********************");
    }
}
