package com.utility;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.base.TestBaseB;
import com.base.TestBaseC;
import com.base.TestBaseD;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotD extends TestBaseD {
    WebDriver driver;

    public ScreenShotD(WebDriver driver) {
        this.driver = driver;
    }


    public void ScreenShotD() throws InterruptedException {
        Thread.sleep(1000);
        String extentReportImageqm11 = System.getProperty("user.dir") + "\\ScreenShot\\ScreenShot" + System.currentTimeMillis() + ".png";
        File srcam11 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the screenshot to desired location using copyFile method
            FileUtils.copyFile(srcam11, new File(extentReportImageqm11));
            test.log(Status.INFO, "Screenshot from : " + extentReportImageqm11, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImageqm11).build());
        } catch (IOException e) {
            System.out.println("Error in the captureAndDisplayScreenShot method: " + e.getMessage());
        }
    }
}