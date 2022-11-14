package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.Home_page;
import page.login_page;
import test.base_test;

public class Valid_login {
    login_page lb;
    Home_page hp;
    @Given("user add username {string}")
    public void add_username(String username){
        lb=new login_page(base_test.getDriver());
        lb.user_id(username);
    }

    @When("user add password {string}")
    public void userAddPassword(String password) {
        lb=new login_page(base_test.getDriver());
        lb.setPassword(password);
    }

    @And("submit login")
    public void submitLogin() {
        lb=new login_page(base_test.getDriver());
        lb.Logins();
    }

    @And("assertion username")
    public void assertionUsername() {
        hp=new Home_page(base_test.getDriver());
        System.out.println(hp.get_yid());
        Assert.assertEquals(hp.get_yid(),"Manger Id : mngr454711");
    }

    @Then("Logout")
    public void logout() {
        hp=new Home_page(base_test.getDriver());
        hp.logout();
        base_test.getDriver().switchTo().alert().accept();
    }
}
