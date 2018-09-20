package tests;

import Data.DataSource;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import Data.Setup;

import java.io.IOException;


public class LoginTest extends Setup {

    private static final Logger logger = Logger.getLogger(LoginTest.class.getName());

    @Test(dataProvider = "user")
    public void openBrowser(String username, String password) throws IOException {
        WebDriver driver = InitializeDriver();
        driver.get(DataSource.url);
        LoginPage loginPage = new LoginPage(driver);
       // Assert.assertEquals(loginPage.getSubmit().getText(),"登录 ");
        loginPage.getUsername().sendKeys(username);

        loginPage.getPassword().sendKeys(password);
        loginPage.getVerification().click();
        logger.info("success login");
    }

    @DataProvider(name="user")
    public Object[][] Users(){
        return new Object[][]{
                {"root","passowrd"},
                {"cnblogs.com", "tankxiao"},
                {"tank","xiao"}
        };
    }

    @AfterMethod
    public void tearDown(){
        Setup.driver.close();
        Setup.driver = null;
    }
}
