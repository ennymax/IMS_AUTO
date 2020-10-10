package com.Module.ManageUsers;

import com.aventstack.extentreports.Status;
import com.base.TestBaseD;
import com.mifmif.common.regex.Generex;
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

public class UpdateUser extends TestBaseD {
    @Test
    public void UPDATE_USER() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE USER");
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
        String regex1 = "080(1|3|7|8)\\d{7}";
        new Generex(regex1).random();


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
        WebElement element7 = driver.findElement(By.xpath(Utility.fetchLocator("UserActionBTN_XPATH")));
        JavascriptExecutor js7 = (JavascriptExecutor) driver;
        js7.executeScript("arguments[0].click();", element7);

        Thread.sleep(2000);
        WebElement element77 = driver.findElement(By.xpath(Utility.fetchLocator("UpdateUser_XPATH")));
        JavascriptExecutor js77 = (JavascriptExecutor) driver;
        js77.executeScript("arguments[0].click();", element77);

        WebElement git = driver.findElement(By.xpath(Utility.fetchLocator("NewUserPhoneNumber_XPATH")));
        git.clear();
        git.sendKeys(Utility.fetchLocator("a_TEXT") +  new Generex(regex1).random());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitNewUser_XPATH"))).click();

        Thread.sleep(2000);
        screenShotD.ScreenShotD();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertNewUserCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "User Created successfully");
        } else {
            test.log(Status.FAIL, "User cant be created");
        }

        Thread.sleep(3000);
        screenShotD.ScreenShotD();

        driver.quit();
        System.out.println("********************UPDATE USERS********************");
    }
}
