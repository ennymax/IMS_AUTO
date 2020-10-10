package com.Module.ManageInventry;

import com.aventstack.extentreports.Status;
import com.base.TestBaseB;
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
import java.security.SecureRandom;

public class AddInventory extends TestBaseC {

    @Test
    public void ADD_INVENTORY_CATEGORY() throws IOException, InterruptedException {
        test = extent.createTest("ADD INVENTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLinkC brokenLinkC = new BrokenLinkC(driver);
        ScreenShotC screenShotC = new ScreenShotC(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomWords randomWords = new RandomWords();
        RandomNumbers randomNumbers = new RandomNumbers();

        SecureRandom rn = new SecureRandom();
        int role = rn.nextInt(11) + 1;
        int role1 = rn.nextInt(10) + 1;

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("InventoryBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("InventoryBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementg = driver.findElement(By.xpath(Utility.fetchLocator("ManageInventry_XPATH")));
        JavascriptExecutor jsg = (JavascriptExecutor) driver;
        jsg.executeScript("arguments[0].click();", elementg);

        Thread.sleep(2000);
        WebElement element11s = driver.findElement(By.xpath(Utility.fetchLocator("AddNewInventryBTN_XPATH")));
        Actions actions = new Actions(driver);
        actions.moveToElement(element11s).click();

        Thread.sleep(2000);
        screenShotC.ScreenShotC();
        WebElement elementgg = driver.findElement(By.xpath(Utility.fetchLocator("AddNewInventryBTN_XPATH")));
        JavascriptExecutor jsgg = (JavascriptExecutor) driver;
        jsgg.executeScript("arguments[0].click();", elementgg);

        Thread.sleep(2000);
        WebElement ele1111 = driver.findElement(By.xpath(Utility.fetchLocator("CategoryAA_XPATH")));
        Select sel111 = new Select(ele1111);
        sel111.selectByIndex(2);

        Thread.sleep(1500);
        WebElement ele111d = driver.findElement(By.xpath(Utility.fetchLocator("SubCategoryA_XPATH")));
        Select sel11d = new Select(ele111d);
        sel11d.selectByIndex(2);

        screenShotC.ScreenShotC();
        driver.findElement(By.xpath(Utility.fetchLocator("IMSCODE_XPATH"))).sendKeys(Utility.fetchLocator("IMSCompanyName_TEXT") + randomWords.RandomWords());
        driver.findElement(By.xpath(Utility.fetchLocator("InventryName_XPATH"))).sendKeys(randomWords.RandomWords());
        driver.findElement(By.xpath(Utility.fetchLocator("InventryDes_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("ActualUnit_XPATH"))).sendKeys("meters");
        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("Group_XPATH"))).sendKeys("Drums");

        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        driver.findElement(By.xpath(Utility.fetchLocator("NoinGroup_XPATH"))).sendKeys("10");
        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("GeneralLedgerCode_XPATH"))).sendKeys(Utility.fetchLocator("a_TEXT") + randomNumbers.RandomNumbers());
        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("UnitPrice_XPATH"))).sendKeys("10");
        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("PriceMps_XPATH"))).sendKeys("10");
        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("DamilareStore_XPATH"))).sendKeys("10");
        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitSubmitBTN_XPATH"))).click();

        Thread.sleep(1500);
        screenShotC.ScreenShotC();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Inventory was Added Successfully");
        } else {
            test.log(Status.FAIL, "Inventory want Added");
        }

        driver.quit();
        System.out.println("********************ADD INVENTORY********************");
    }
}
