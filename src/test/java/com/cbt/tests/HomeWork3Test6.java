package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork3Test6 {

    private WebDriver driver;
    private By emailBy = By.className("animace");


    @Test
    private void test1() {
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(emailBy).getText();
        System.out.println(email);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Vladislav Vyugovskiy");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expected,actual,"Message mismatch");

        BrowserUtils.wait(5);

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        BrowserUtils.wait(2);

        driver.findElement(By.className("wpcc-btn")).click();
        String expected2 = "do-not-reply@practice.cybertekschool.com";
        String actual2 = driver.findElement(By.xpath("//*[@class='from']")).getText().trim();
        Assert.assertEquals(actual2,expected2, "email was not received");

        driver.findElement(By.xpath("//*[@class='from']")).click();

        String expected3 = "do-not-reply@practice.cybertekschool.com";
        String actual3 = driver.findElement(By.id("odesilatel")).getText();

        String expected4 = "Thanks for subscribing to practice.cybertekschool.com!";
        String actual4 = driver.findElement(By.id("predmet")).getText();

        Assert.assertEquals(actual3,expected3, "email mismatch");
        Assert.assertEquals(actual4,expected4,"message mismatch");

        BrowserUtils.wait(3);

    }

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
