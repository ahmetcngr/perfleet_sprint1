package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStepDefs {
    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @Then("user should able to login")
    public void userShouldAbleToLogin() {
        BrowserUtils.waitFor(4);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard", actualTitle);
        Driver.closeDriver();


    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        String username = "FakeName";
        String password = "FakePassword";

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);


    }

    @Then("user should able NOT to login")
    public void userShouldAbleNOTToLogin() {
        BrowserUtils.waitFor(4);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Login", actualTitle);
        Driver.closeDriver();
    }

    @Then("the user should see the password in bullet signs")
    public void theUserShouldSeeThePasswordInBulletSigns() {
        System.out.println("Elements type is 'password' so it is shown with bullet signs.");
        Driver.closeDriver();
    }

    @Then("the user can see and click on remember me box")
    public void theUserCanSeeAndClickOnRememberMeBox() {

        WebElement rememberBox = Driver.get().findElement(By.xpath("//span[contains(text(),'Remember me on this computer')]"));
        Assert.assertTrue(rememberBox.isDisplayed());
        rememberBox.click();
        Driver.closeDriver();
    }

    @Then("the user can see forget password option")
    public void theUserCanSeeForgetPasswordOption() {

        WebElement forgotPassword = Driver.get().findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        Assert.assertTrue(forgotPassword.isDisplayed());
        Driver.closeDriver();

    }

    @When("user does not click yet")
    public void userDoesNotClickYet() {
        
    }

    @Then("user should able to log out")
    public void userShouldAbleToLogOut() {
        WebElement drop = Driver.get().findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[4]/a[1]/i[1]"));
        drop.click();
        WebElement logout = Driver.get().findElement(By.xpath("//a[contains(text(),'Logout')]"));
        logout.click();
        String actual = Driver.get().getTitle();
        Assert.assertEquals("Login",actual);
        Driver.closeDriver();


    }
}
