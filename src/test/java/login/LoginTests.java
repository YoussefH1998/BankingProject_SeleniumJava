package login;

import base.BaseTests;
import org.testng.annotations.*;
import pages.HomePage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @BeforeMethod
    public void cleanUp(){
       loginPage.waitTillUsernameField();
    }

    @Test(priority =1)
    public void InvalidUsernameAndValidPassword(){
        loginPage.setUserName("InvalidUsername");
        loginPage.setPassword(validPassword);
        loginPage.clickOnLoginButton();
        String popup=loginPage.getAlertTextandAccept();
        assertTrue(popup.contains("User or Password is not valid"));
        //assertTrue(loginPage.getTitle().contains("Bank Home Page"));

    }
    @Test(priority=2)
    public void ValidUsernameAndInvalidPassword(){
        loginPage.setUserName(validUsername);
        loginPage.setPassword("InvalidPassword");
        loginPage.clickOnLoginButton();
        String popup=loginPage.getAlertTextandAccept();
        assertTrue(popup.contains("User or Password is not valid"));
       // assertTrue(loginPage.getTitle().contains("Bank Home Page"));

    }
    @Test(priority=3)
    public void InvalidUsernameAndInvalidPassword(){
        loginPage.setUserName("InvalidUsername");
        loginPage.setPassword("InvalidPassword");
        loginPage.clickOnLoginButton();
        String popup=loginPage.getAlertTextandAccept();
        assertTrue(popup.contains("User or Password is not valid"));
        //assertTrue(loginPage.getTitle().contains("Bank Home Page"));
    }
    @Test(priority=4)
    public void ValidUsernameAndValidPassword(){
        loginPage.setUserName(validUsername);
        loginPage.setPassword(validPassword);
        HomePage homePage=loginPage.clickOnLoginButton();
        assertTrue(homePage.getTitle().contains("Bank Manager HomePage"));
    }
}
