package screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class screenshot {
    public static void take_screenshot(WebDriver driver,String screenpath) throws IOException {
        TakesScreenshot srcscreenshot=((TakesScreenshot) driver);
        File srcfile=srcscreenshot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcfile,new File(screenpath));
    }
}
