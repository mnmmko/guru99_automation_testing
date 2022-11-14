package com.example.tests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.example.screenshot.screenshot;

import java.io.IOException;

public class base_test extends AbstractTestNGCucumberTests{
    static  WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeSuite
    @Parameters({"browser"})
    public void open(String browser) throws InterruptedException {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.demo.guru99.com/");
        }
        else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.demo.guru99.com/V4/");
        }
        Thread.sleep(2000);
    }

    @AfterSuite
    public void close(){
        driver.quit();
    }

    @AfterMethod
    public void failed_screenshots(ITestResult testcase_Result) throws IOException {
        if (testcase_Result.getStatus() == ITestResult.FAILURE) {
            screenshot.take_screenshot(driver, ".\\screenshots\\" + testcase_Result.getName() + ".png");
            System.out.println("itestresult.failure is " + ITestResult.FAILURE);
            System.out.println("testcase_Result.getStatus() " + testcase_Result.getStatus());
        }
    }
}
