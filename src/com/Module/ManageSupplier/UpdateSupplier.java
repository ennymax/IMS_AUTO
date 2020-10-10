package com.Module.ManageSupplier;

import com.aventstack.extentreports.Status;
import com.base.TestBaseA;
import com.mifmif.common.regex.Generex;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateSupplier extends TestBaseA {

    String regex1 = "080(1|3|7|8)\\d{7}";

    @Test
    public void UPDATE_SUPPLIER() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE SUPPLIER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLinkA brokenLinkA = new BrokenLinkA(driver);
        ScreenShotA screenShotA = new ScreenShotA(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomWords randomWords = new RandomWords();

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successfull");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ManageSupplier_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ActionBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("UpdateSupplierBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("IMSPhoneNumber_XPATH"))).sendKeys(new Generex(regex1).random());

        driver.findElement(By.xpath(Utility.fetchLocator("IMSSubmitBTN_XPATH"))).click();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Supplier Created Successfully");
        } else {
            test.log(Status.FAIL, "Supplier Not Created");
        }

        driver.quit();
        System.out.println("********************UPDATE SUPPLIER********************");
    }
}
