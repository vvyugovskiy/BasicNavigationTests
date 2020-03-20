package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class HomeWork3Tests9_12 {

    private WebDriver driver;
    private By firstBy = By.linkText("200");
    private By secondBy = By.linkText("301");
    private By thirdBy = By.linkText("404");
    private By forthBy = By.linkText("500");
    private String expected1 = "This page returned a 200 status code.";
    private String expected2 = "This page returned a 301 status code.";
    private String expected3 = "This page returned a 404 status code.";
    private String expected4 = "This page returned a 500 status code.";

    @Test(description = "verify status codes", dataProvider = "TestData")
    public void test1(By statusCode, String expected) {

        driver.findElement(statusCode).click();
        BrowserUtils.wait(2);
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(actual.trim().contains(expected), "message mismatch");
        BrowserUtils.wait(2);
    }

    @DataProvider(name = "TestData")
    public Object[][] testData() {

        return new Object[][]{{firstBy, expected1},
                              {secondBy, expected2},
                              {thirdBy, expected3},
                              {forthBy, expected4},
        };
    }

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Status Codes")).click();

        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
