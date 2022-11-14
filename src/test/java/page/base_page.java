package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class base_page {
  protected   WebDriver driver;

    public base_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }
    public void scroll_down(WebDriver driver){
        JavascriptExecutor java=(JavascriptExecutor) driver;
        java.executeScript("scroll(0,250)");
    }
    public void wait_for_element(WebDriver driver, int time, WebElement element){
        WebDriverWait waits=new WebDriverWait(driver,time);
        waits.until(ExpectedConditions.visibilityOf(element));
    }
    public void waits_for_element(WebDriver driver, int time, By element){
        WebDriverWait waits=new WebDriverWait(driver,time);
        waits.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
