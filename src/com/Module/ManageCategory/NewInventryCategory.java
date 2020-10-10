package com.Module.ManageCategory;

import com.aventstack.extentreports.Status;
import com.base.TestBaseA;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewInventryCategory extends TestBaseA {

    @Test
    public void NEW_INVENTORY_CATEGORY() throws IOException, InterruptedException {
        test = extent.createTest("NEW INVENTORY CATEGORY");
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
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageCATEGORYBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewCategoryBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CategoryName_XPATH"))).sendKeys(Utility.fetchLocator("IMSCompanyName_TEXT") + randomWords.RandomWords());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CategoryDescrition_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT") + randomWords.RandomWords());

        Thread.sleep(2000);
        WebElement ele1111 = driver.findElement(By.xpath(Utility.fetchLocator("UniqueIdentifier_XPATH")));
        Select sel111 = new Select(ele1111);
        sel111.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele111d = driver.findElement(By.xpath(Utility.fetchLocator("Mustreturn_XPATH")));
        Select sel11d = new Select(ele111d);
        sel11d.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("HasSpecification_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("IdentifierName_XPATH"))).sendKeys(randomWords.RandomWords());

        driver.findElement(By.xpath(Utility.fetchLocator("IdentifierOption_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT") + randomWords.RandomWords());

        Thread.sleep(1000);
        WebElement ele111o = driver.findElement(By.xpath(Utility.fetchLocator("Required_XPATH")));
        Select sel11o = new Select(ele111o);
        sel11o.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele111oo = driver.findElement(By.xpath(Utility.fetchLocator("Unique_identifier_XPATH")));
        Select sel11oo = new Select(ele111oo);
        sel11oo.selectByIndex(1);

        /*
        driver.findElement(By.xpath(Utility.fetchLocator("AddUniqueIdentierBTN_XPATH"))).click();


        driver.findElement(By.xpath(Utility.fetchLocator("2IdentifierName_XPATH"))).sendKeys(randomWords.RandomWords()+randomWords.RandomWords());

        driver.findElement(By.xpath(Utility.fetchLocator("2identifierOption_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT") + randomWords.RandomWords()+randomWords.RandomWords());

        Thread.sleep(1000);
        WebElement ele111oi = driver.findElement(By.xpath(Utility.fetchLocator("2required_XPATH")));
        Select sel11oi = new Select(ele111oi);
        sel11oi.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele111ooii = driver.findElement(By.xpath(Utility.fetchLocator("2Uniqueidentifier_XPATH")));
        Select sel11ooii = new Select(ele111ooii);
        sel11ooii.selectByIndex(1);
        */

        driver.findElement(By.xpath(Utility.fetchLocator("SubmitCategoryBTN_XPATH"))).click();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageSupplierCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New Inventory was Created Successfully");
        } else {
            test.log(Status.FAIL, "Inventory want Created");
        }

        driver.quit();
        System.out.println("********************NEW INVENTORY CATEGORY********************");
    }

}
