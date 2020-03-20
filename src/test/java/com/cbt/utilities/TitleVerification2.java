package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) throws Exception {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com/","https://wayfair.com","https://walmart.com","https://www.westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (int i = 0; i < urls.size(); i++) {
            driver.get(urls.get(i));
            if (driver.getCurrentUrl().contains(driver.getTitle().toLowerCase().replace(" ",""))){
                System.out.println("Contains Title");
            }else{
                System.out.println("Does not Contain");
                System.out.println("URL = " + urls.get(i));
                System.out.println("Title = " + driver.getTitle());
            }
        }
        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
        driver.quit();
    }
}
