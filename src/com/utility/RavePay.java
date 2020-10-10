package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RavePay {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 20);


    public RavePay(WebDriver driver) {
        this.driver = driver;
    }

    public void RavePay() throws IOException, InterruptedException {

        //CARD DETAILS
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayCardnumber_XPATH"))).sendKeys(Utility.fetchLocator("CardNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("expiredate_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RavPayCVV_XPATH"))).sendKeys(Utility.fetchLocator("CVV_XPATH"));
        driver.findElement(By.xpath(Utility.fetchLocator("pppppp_XPATH"))).click();

        //PIN
        driver.findElement(By.xpath(Utility.fetchLocator("a1_XPATH"))).sendKeys(Utility.fetchLocator("a11_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a2_XPATH"))).sendKeys(Utility.fetchLocator("a21_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a3_XPATH"))).sendKeys(Utility.fetchLocator("a31_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a4_XPATH"))).sendKeys(Utility.fetchLocator("a41_TEXT"));

        //OTP
        driver.findElement(By.xpath(Utility.fetchLocator("OTP_XPATH"))).sendKeys(Utility.fetchLocator("otp_TEXT"));

        // driver.findElement(By.xpath(Utility.fetchLocator("AuthorizePaymentBTN_XPATH"))).click();

    }

    public void RavePayWorkShop() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.switchTo().frame("checkout");
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayCardnumber_XPATH"))).sendKeys(Utility.fetchLocator("CardNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RavePayValidTill_XPATH"))).sendKeys(Utility.fetchLocator("Expire_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("RavPayCVV_XPATH"))).sendKeys(Utility.fetchLocator("CVV_XPATH"));

        Thread.sleep(10000);
        WebElement eee = driver.findElement(By.xpath("//*[@id=\"paycard-btn\"]"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(eee).perform();
        eee.click();

        //PIN
        driver.findElement(By.xpath(Utility.fetchLocator("a1_XPATH"))).sendKeys(Utility.fetchLocator("a11_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a2_XPATH"))).sendKeys(Utility.fetchLocator("a21_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a3_XPATH"))).sendKeys(Utility.fetchLocator("a31_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("a4_XPATH"))).sendKeys(Utility.fetchLocator("a41_TEXT"));

        //OTP
        driver.findElement(By.xpath(Utility.fetchLocator("OTP_XPATH"))).sendKeys(Utility.fetchLocator("otp_TEXT"));

        // driver.findElement(By.xpath(Utility.fetchLocator("AuthorizePaymentBTN_XPATH"))).click();
    }
}
