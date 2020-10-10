package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ClickAllStuff {

    WebDriver driver;

    public ClickAllStuff(WebDriver driver) {

        this.driver = driver;
    }

    public void ClickAllCheckBox() throws InterruptedException, IOException {
        WebElement e = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div/div[2]/form/div[1]/div[2]/div/div"));
        List<WebElement>ee = e.findElements(By.tagName("t"));
        System.out.println("Total Item to be clicked  " + ee.size());
        Thread.sleep(3000);
        for (int i = 0; i < ee.size(); i++) {
            Random r = new Random();
            ee.get(r.nextInt(5)).click();
            Actions actions = new Actions(driver);

            actions.moveToElement(ee.get(r.nextInt(5))).click().perform();
        }
    }
}
