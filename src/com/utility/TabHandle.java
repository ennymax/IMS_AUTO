package com.utility;

import org.openqa.selenium.WebDriver;

public class TabHandle {
    WebDriver driver;

    public TabHandle(WebDriver driver) {
        this.driver = driver;
    }

    public void TabHandle() throws InterruptedException {
        Thread.sleep(2000);
        String mjj = driver.getWindowHandle();
        System.out.println("The WindownHandle is " + mjj);

        Thread.sleep(4000);

        for (String childTab : driver.getWindowHandles()) {
            driver.switchTo().window(childTab);
        }

        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
    }
}