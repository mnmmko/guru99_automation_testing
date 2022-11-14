package test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.Home_page;
import page.login_page;
import read_excel.Read_excel;

import java.io.IOException;

public class Valid_Login_test{

    login_page lb;
    Home_page hp;
    @Test(enabled = true,groups = "h",priority = 0)
    @Given("login")
    public void valid_user_test(){
        lb=new login_page(base_test.getDriver());
        lb.user_id("mngr454711");
        lb.setPassword("bEbypYt");
        lb.Logins();
        hp=new Home_page(base_test.getDriver());
        System.out.println(hp.get_yid());
        Assert.assertEquals(hp.get_yid(),"Manger Id : mngr454711");
        hp.logout();
        base_test.getDriver().switchTo().alert().accept();
    }


}
