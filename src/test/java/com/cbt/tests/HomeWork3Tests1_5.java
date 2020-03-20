package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork3Tests1_5 {

    private WebDriver driver;
    private By cBy = By.xpath("//*[@for='inlineCheckbox1']");
    private By javaBy = By.xpath("//*[@for='inlineCheckbox2']");
    //private By javaBy = By.id("inlineCheckbox2");
    private By javaScriptBy = By.xpath("//*[@for='inlineCheckbox3']");
    private By firstNameBy = By.name("firstname");
    private By firstName64WarningBy = By.xpath("//*[@data-bv-for='firstname' and contains (text(),'64')]");
    private By lastNameBy = By.name("lastname");
    private By lastName64WarningBy = By.xpath("//*[@data-bv-for='lastname' and contains (text(),'64')]");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    private By maleRadioBy = By.xpath("//input[@value='male']");
    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By sighUpBy = By.id("wooden_spoon");

    @Test(description = "verify warning isDisplayed")
    public void test1() {
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String expectedMessage = "The date of birth is not valid";
        String actualMessage = driver.findElement(By.xpath("//*[@data-bv-result='INVALID']")).getText();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test(description = "verify programming languages are displayed ")
    public void test2() {

        String actual = "C++\nJava\nJavaScript";
        String expected = driver.findElement(By.xpath("(//*[@class='col-sm-5'])[11]")).getText();

        Assert.assertEquals(actual,expected,"languages mismatch");

//        String optionC = driver.findElement(cBy).getText();
//        String expectedC = "C++";
//        String optionJava = driver.findElement(javaBy).getText();
//        String expectedJava = "Java";
//        String optionJavaScript = driver.findElement(javaScriptBy).getText();
//        String expectedJavaScript = "JavaScript";
//
//        Assert.assertEquals(optionC, expectedC);
//        Assert.assertEquals(optionJava, expectedJava);
//        Assert.assertEquals(optionJavaScript, expectedJavaScript);
    }

    @Test(description = "verify first name warning isDisplayed")
    public void test3() {
        driver.findElement(firstNameBy).sendKeys("A");
        String expected = "first name must be more than 2 and less than 64 characters long";
        String actualMsg = driver.findElement(firstName64WarningBy).getText();

        Assert.assertEquals(expected,actualMsg);
    }

    @Test (description = "verify last name warning isDisplayed")
    public void test4(){
        driver.findElement(lastNameBy).sendKeys("A");
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actualMsg = driver.findElement(lastName64WarningBy).getText();

        Assert.assertEquals(expected,actualMsg);
    }

    @Test (description = "verify registration complete message displayed")
    public void test5(){
        driver.findElement(firstNameBy).sendKeys("Vladislav");
        driver.findElement(lastNameBy).sendKeys("Vyugovskiy");
        driver.findElement(usernameBy).sendKeys("vvyugovskiy");
        driver.findElement(emailBy).sendKeys("resident@gmail.com");
        driver.findElement(passwordBy).sendKeys("validPassword");
        driver.findElement(phoneBy).sendKeys("843-800-1517");
        driver.findElement(maleRadioBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("09/17/1986");
        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Engineering");
        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");
        driver.findElement(javaBy).click();
        driver.findElement(sighUpBy).click();
        BrowserUtils.wait(3);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(expected,actual,"Message does not match");


    }
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(2);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
