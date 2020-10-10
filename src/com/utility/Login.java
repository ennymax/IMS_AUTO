package com.utility;

import com.mifmif.common.regex.Generex;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {

    String regex1 = "080(1|3|7|8)\\d{7}";

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public static void uploadTest(RemoteWebDriver driver) throws Exception {

    }

    public void AcceptAlert() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null)//switches only if alert is displayed
        {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // alert.accept();
        }
    }

    public void AlertDismis() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void UploadFile() throws IOException, InterruptedException, AWTException {

        String fileAbsolutePath = "C:\\Users\\Ennymax\\Music\\01 Praises.mp3";
        StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

        try {
            //Robot Class
            Robot robot = new Robot();
            //Keyboard Action : CTRL+V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            //Keyboard Action : Enter
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);

        } catch (StaleElementReferenceException e) {
            System.out.println("An Error Occur but Test will continue");
        }

    }

    public void CreateSupplier() throws IOException, InterruptedException {

        RandomNumbers randomNumbers = new RandomNumbers();
        RandomWords randomWords = new RandomWords();

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("CompanyName_XPATH"))).sendKeys(Utility.fetchLocator("IMSCompanyName_TEXT") + randomWords.RandomWords());
        driver.findElement(By.xpath(Utility.fetchLocator("FullName_XPATH"))).sendKeys(Utility.fetchLocator("IMSFullName_TEXT") + randomNumbers.RandomNumbers());
        driver.findElement(By.xpath(Utility.fetchLocator("IMSEmail_XPATH"))).sendKeys(randomWords.RandomWords() + "@gmail.com");
        driver.findElement(By.xpath(Utility.fetchLocator("IMSPhoneNumber_XPATH"))).sendKeys(new Generex(regex1).random());
        driver.findElement(By.xpath(Utility.fetchLocator("AddressLin1_XPATH"))).sendKeys(Utility.fetchLocator("IMSAddressline_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("IMSAddressLine2_XPATH"))).sendKeys(Utility.fetchLocator("IMSAddressline_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("IMSArea_XPATH"))).sendKeys(Utility.fetchLocator("IMSArea_TEXT") + " " + randomNumbers.RandomNumbers());
        driver.findElement(By.xpath(Utility.fetchLocator("IMSSTATE_XPATH"))).sendKeys(Utility.fetchLocator("IMSState_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("IMSCountry_XPATH"))).sendKeys(Utility.fetchLocator("IMSCOuntry_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("IMSSubmitBTN_XPATH"))).click();
    }

    public void LoginWrongDomainName() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("DefaultShopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginWrongEmail() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("DefaultEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginWrongPassWord() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("DefaultPassWord_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginCorrectDetails() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }
}
