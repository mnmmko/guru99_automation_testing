package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class login_page extends base_page{


    public login_page(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "uid")
    private WebElement uid;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "btnLogin")
    private WebElement logins;


    public void user_id(String uids) {
        wait_for_element(driver,20,uid);
        uid.sendKeys(uids);

    }

    public void setPassword(String pass) {
        wait_for_element(driver,20,password);
        password.sendKeys(pass);
    }

    public void Logins() {
        wait_for_element(driver,20,logins);
        logins.click();
    }
}
