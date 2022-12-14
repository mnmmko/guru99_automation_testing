package com.example.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.pages.login_page;
import com.example.read_excel.Read_excel;

import java.io.IOException;


public class Invalid_Login_test {

    login_page lbs;
    @Test(enabled = true,priority = 0,dataProvider = "data")
    public void invalid_user(String uid,String pass){
        lbs=new login_page(base_test.getDriver());
        lbs.user_id(uid);
        lbs.setPassword(pass);
        lbs.Logins();
        String alert=base_test.getDriver().switchTo().alert().getText();
        Assert.assertEquals("User or Password is not valid",alert);
        base_test.getDriver().switchTo().alert().accept();
    }

    @DataProvider
    public Object[][] data() throws IOException, InvalidFormatException {
        Read_excel re=new Read_excel();
        return re.read_sheet();
    }

}
