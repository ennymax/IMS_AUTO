package com.Module.ManageUsers;

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
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class DownloadLastUserLogin extends TestBaseD {

    @Test
    public void DOWNLOAD_LAST_USERS_LOGIN() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD LAST USERS LOGIN");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        BrokenLinkD brokenLinkD = new BrokenLinkD(driver);
        ScreenShotD screenShotD = new ScreenShotD(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomWords ramdomwords = new RandomWords();
        RandomWords ramdomword = new RandomWords();

        //new Generex(regex1).random();

        ramdomwords.ListRandom();
        ramdomword.ListRandom();

        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(7) + 1;
        int resourcelevel = rn.nextInt(6) + 1;

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("ManageUserBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ManageUserBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertViewUser_XPATH"))).size() != 0) {
            test.log(Status.PASS, "User Could be Viewed");
        } else {
            test.log(Status.FAIL, "User could not be Viewed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LastloginUserBTN_XPATH"))).click();
        WebElement element7 = driver.findElement(By.xpath(Utility.fetchLocator("LastloginUserBTN_XPATH")));
        JavascriptExecutor js7 = (JavascriptExecutor) driver;
        js7.executeScript("arguments[0].click();", element7);

        driver.findElement(By.xpath(Utility.fetchLocator("TimeFrom_XPATH"))).sendKeys("2020-02-24");

        Thread.sleep(2000);
        WebElement element7b = driver.findElement(By.xpath(Utility.fetchLocator("DownlloadtheuserLogin_XPATH")));
        JavascriptExecutor js7b = (JavascriptExecutor) driver;
        js7b.executeScript("arguments[0].click();", element7b);

        Thread.sleep(7000);
        screenShotD.ScreenShotD();

        driver.quit();
        System.out.println("********************DOWNLOAD LAST USERS LOGIN********************");
    }
}
