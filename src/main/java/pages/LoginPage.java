package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(id = "btn_login")
    public WebElement submit;

    @FindBy(css = "div[aria-label=点击按钮进行验证]")
    public WebElement verification;

    public WebElement getVerification() {
        return verification;
    }
    public WebElement getPassword() {
        return password;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getUsername() {
        return username;
    }
}
