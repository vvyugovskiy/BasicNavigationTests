package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) throws Exception {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com/", "https://wayfair.com", "https://walmart.com", "https://www.westelm.com/");

        List<String> d = Arrays.asList("chrome", "firefox", "edge","chrome");

        for (int i = 0; i < d.size(); i++) {
            WebDriver driver = BrowserFactory.getDriver(d.get(i));
            driver.get(urls.get(i));
            if (driver.getCurrentUrl().contains(driver.getTitle().toLowerCase().replace(" ",""))){
                System.out.println("Contains Title");
            }else{
                System.out.println("Does not Contain");
                System.out.println("URL = " + urls.get(i));
                System.out.println("Title = " + driver.getTitle());
            }
            driver.quit();
        }
        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");

    }
}
