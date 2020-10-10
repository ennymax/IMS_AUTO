package com.Module.ManageStore;

import com.aventstack.extentreports.Status;
import com.base.TestBaseF;
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

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddNewStore extends TestBaseF {

    String regex1 = "080(1|3|7|8)\\d{7}";

    @Test
    public void ADD_NEW() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("ADD NEW STORE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        BrokenLinkF brokenLinkF = new BrokenLinkF(driver);
        ScreenShotF screenShotF = new ScreenShotF(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomWords randomWords = new RandomWords();
        RandomWords randomWord = new RandomWords();


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

        Thread.sleep(2000);
        WebElement elementL = driver.findElement(By.xpath(Utility.fetchLocator("AddNewStoreBTN_XPATH")));
        JavascriptExecutor jsL = (JavascriptExecutor) driver;
        jsL.executeScript("arguments[0].click();", elementL);

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("StoreName_XPATH"))).sendKeys(Utility.fetchLocator("a_TEXT") + randomWord.ListRandom() + " " + randomWords.ListRandom());

        Thread.sleep(2000);
        WebElement element11p = driver.findElement(By.xpath(Utility.fetchLocator("StoreEmail_XPATH")));
        Actions actionp = new Actions(driver);
        actionp.moveToElement(element11p).doubleClick().perform();

        Robot r = new Robot();
        String text =  randomWords.ListRandom() + "@gmail.com";
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);

        screenShotF.ScreenShotF();
        driver.findElement(By.xpath(Utility.fetchLocator("StorePhoneNumber_XPATH"))).sendKeys(new Generex(regex1).random());

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("StoreAddressLine1_XPATH"))).sendKeys(Utility.fetchLocator("IMSAddressline_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("StoreAddressLine2_XPATH"))).sendKeys(Utility.fetchLocator("IMSAddressline_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("StoreArea_XPATH"))).sendKeys(randomWord.ListRandom());

        driver.findElement(By.xpath(Utility.fetchLocator("SubmitStoreCeation_XPATH"))).click();

        Thread.sleep(2000);
        screenShotF.ScreenShotF();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Store added successfully");
        } else {
            test.log(Status.FAIL, "Store cant be added");
        }

        driver.quit();
        System.out.println("********************ADD NEW STORE********************");
    }
}
