package test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import screenshot.screenshot;

import java.io.IOException;
import java.util.HashMap;

public class base_test extends AbstractTestNGCucumberTests{
    static  WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    //screenshot screenshot;
    public static String downloadPath = System.getProperty("user.dir") + "\\DownLoads";
    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        //HashMap key object
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        //by dafult of chrome ,chrome doesn't appeare options
        chromePrefs.put("profile.default.content_settings.popups", 0);
        //path of folder
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        //accept ssl files and all files
        //options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }

    @BeforeSuite
    @Parameters({"browser"})
    public void open(String browser) throws InterruptedException {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOption());
            driver.manage().window().maximize();
            driver.navigate().to("https://www.demo.guru99.com/V4/");
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
