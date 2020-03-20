package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork3Tests7_8 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();

        BrowserUtils.wait(3);
    }

    @Test
    public void test1(){

        driver.findElement(By.linkText("File Upload")).click();
        WebElement upload = driver.findElement(By.id("file-upload"));
        String filePath = "C:/Users/FaRAoN/Desktop/SDET_File.txt";
        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();

        String expected = "File Uploaded!";
        String actual = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actual,expected,"message mismatch");

        String expected2 = "SDET_File.txt";
        String actual2 = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actual2,expected2,"message mismatch");

        BrowserUtils.wait(3);
    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//*[@value='Submit']")).click();

        BrowserUtils.wait(2);

        String expected = "You selected: United States of America";
        String actual = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actual,expected, "message mismatch");

        BrowserUtils.wait(2);

    }


    @AfterMethod
    public void teardown (){
        driver.quit();
    }
}
