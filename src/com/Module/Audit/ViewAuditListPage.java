package com.Module.Audit;

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

public class ViewAuditListPage extends TestBaseC {
    @Test
    public void VIEW_AUDIT_LIST() throws IOException, InterruptedException {
        test = extent.createTest("VIEW AUDIT LIST");
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
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("AuditBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AuditBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertAuditPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Audit Page Displayed successfully");
        } else {
            test.log(Status.FAIL, "Audit page failed to load");
        }

        Thread.sleep(1000);
        screenShotC.ScreenShotC();

        driver.quit();
        System.out.println("********************VIEW AUDIT LIST********************");
    }
}
