package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    @Test(priority = 1)
    public void ValidUsernameAndValidPassword(){
        loginPage.setUserName(validUsername);
        loginPage.setPassword(validPassword);
        HomePage homePage=loginPage.clickOnLoginButton();
        assertTrue(homePage.getTitle().contains("Bank Manager HomePage"));
    }
}
