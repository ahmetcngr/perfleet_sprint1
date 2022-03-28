package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//input[@id='prependedInput']")
    public WebElement userName;

    @FindBy(xpath="//input[@id='prependedInput2']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginButton;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
        // verification that we logged
    }




}
