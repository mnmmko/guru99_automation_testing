package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page extends base_page{
    public Home_page(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
    private WebElement uid;
    @FindBy(linkText = "Log out")
    private WebElement log_out;
    public String get_yid(){
        wait_for_element(driver,20,uid);
        return uid.getText();
    }
    public void logout(){
        wait_for_element(driver,20,log_out);
        log_out.click();
    }
}
