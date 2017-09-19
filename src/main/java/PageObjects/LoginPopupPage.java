package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPopupPage extends BasePage{
    @FindBy(name = "login")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "auth_submit")
    private WebElement submitButton;

    public LoginPopupPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver,this);
    }


    public MainPage loginAs(String userEmail, String userPass) {
        this.loginInput.sendKeys(userEmail);
        this.passwordInput.sendKeys(userPass);
        this.submitButton.click();
        return new MainPage(driver,wait);
    }
}
