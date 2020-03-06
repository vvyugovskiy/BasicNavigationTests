package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    // fro Windows user automate for 3 browsers: Chrome, Firefox, Edge
    // Each test should close the browser after completion
    // Test methods must use the utilities
    // Run all 3 test methods from the main method

    // TEST CASE

    // 1. Open browser
    // 2. Go to website https://google.com
    // 3. Save the title in a String variable
    // 4. Go to https://etsy.com
    // 5. Save the title in a string variable
    // 6. Navigate back to previous page
    // 7. Verify that title is same as in step 3
    // 8. Navigate forward to previous page
    // 9. Verify that is same title as in step 5

    public static void browserAction(String browser) throws Exception {
        // 1.
        WebDriver driver = BrowserFactory.getDriver(browser);
        // 2.
        driver.get("https://google.com");
        // 3.
        String googleTittle = driver.getTitle();
        // 4.
        driver.get("https://etsy.com");
        // 5.
        String etsyTitle = driver.getTitle();
        // 6.
        driver.navigate().back();
        // 7.
        StringUtility.verifyEquals(googleTittle, etsyTitle);
        // 8.
        driver.navigate().forward();
        // 9.
        StringUtility.verifyEquals(driver.getTitle(), etsyTitle);

        driver.quit();
    }

    public static void main(String[] args) throws Exception {

//        chromeAction();
//        firefoxAction();
//        edgeAction();

        browserAction("edge");
    }
}
