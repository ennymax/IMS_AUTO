package com.Module.ManageEmailAerts;

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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class CreateEmailAlerts extends TestBaseB {
    @Test
    public void Create_Email_Alert() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Create Email Alert");
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
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("ManageEmailAlert_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ManageEmailAlert_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertEmailAlert_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Add Email alert page loads fine ");
        } else {
            test.log(Status.FAIL, "Add Email Alert Page didn't load well");
        }

        Thread.sleep(2000);
        WebElement elementt = driver.findElement(By.xpath(Utility.fetchLocator("AddNewEmailAlert_XPATH")));
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        jst.executeScript("arguments[0].click();", elementt);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertName_XPATH"))).sendKeys(randomWords.RandomWords());

        Thread.sleep(700);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertType1_XPATH"))).click();

        Thread.sleep(700);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertType2_XPATH"))).click();

        Thread.sleep(700);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertType3_XPATH"))).click();

        Thread.sleep(700);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertType4_XPATH"))).click();

        Thread.sleep(700);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertType5_XPATH"))).click();

        Thread.sleep(700);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertType6_XPATH"))).click();

        Thread.sleep(700);
        WebElement elementuu11 = driver.findElement(By.xpath(Utility.fetchLocator("AlertType7_XPATH")));
        JavascriptExecutor jsuu11 = (JavascriptExecutor) driver;
        jsuu11.executeScript("arguments[0].click();", elementuu11);

        Thread.sleep(700);
        WebElement elementuu110 = driver.findElement(By.xpath(Utility.fetchLocator("AlertType8_XPATH")));
        JavascriptExecutor jsuu110 = (JavascriptExecutor) driver;
        jsuu110.executeScript("arguments[0].click();", elementuu110);

        Thread.sleep(700);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertType9_XPATH"))).click();

        Thread.sleep(700);
        driver.findElement(By.xpath(Utility.fetchLocator("AlertType10_XPATH"))).click();

        WebElement element11p = driver.findElement(By.xpath(Utility.fetchLocator("AlertEmail_XPATH")));
        element11p.sendKeys(randomWords.ListRandom() + "@gmail.com");
        Robot r = new Robot();

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(3000);
        WebElement elementuu111 = driver.findElement(By.xpath(Utility.fetchLocator("AlertSubmit_XPATH")));
        JavascriptExecutor jsuu111 = (JavascriptExecutor) driver;
        jsuu111.executeScript("arguments[0].click();", elementuu111);

        Thread.sleep(3000);
        screenShotB.ScreenShotB();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertNewStatusCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Email Alert created Created Successfully");
        } else {
            test.log(Status.FAIL, "Email alert cant be created");
        }

        driver.quit();
        System.out.println("********************Create Email alert********************");
    }
}
