package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(urls.get(0));
        String a = driver.getTitle();
        driver.get(urls.get(1));
        String b = driver.getTitle();
        driver.get(urls.get(2));
        String c = driver.getTitle();
//---------------------------------------------------------------------------------------
        System.out.println("If Titles equal : " + a.equals(b));
        System.out.println("If Titles equal : " + b.equals(c));
        System.out.println("If Titles equal : " + c.equals(a));

        for (int i = 0; i < urls.size(); i++) {

            driver.get(urls.get(i));
            System.out.println(urls.get(i) + " : getTitle() = " + driver.getTitle());
            if (driver.getCurrentUrl().contains("http://practice.cybertekschool.com")){
                System.out.println("Contains");
            }else{
                System.out.println("FAIL");
            }
            driver.navigate().back();
        }
        driver.quit();
    }

}
