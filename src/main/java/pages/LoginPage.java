package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;


public class LoginPage extends BasePage {
    private By userName= By.cssSelector("input[name='uid']");
    private By Password=By.cssSelector("input[name='password']");
    private By loginButton=By.cssSelector("input[value='LOGIN']");
    private By resetButton=By.cssSelector("input[value='RESET']");


    public LoginPage(WebDriver driver){
        super(driver);
    }
    public String getTitle (){
        return  driver.getTitle();
    }
    public void setUserName(String username){
        driver.findElement(userName).sendKeys(username);
    }
    public void setPassword (String password){
        driver.findElement(Password).sendKeys(password);
    }
    public void reset(){
        driver.findElement(resetButton).click();
    }
    public void waitTillUsernameField(){
        waitTillVisibility(userName);
    }
    public HomePage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
    public String getAlertTextandAccept(){
        loginAlert l=new loginAlert();
        String text=l.getAlertText();
        l.acceptAlert();
        return text;
    }
    public class loginAlert{
        public String getAlertText(){
            return driver.switchTo().alert().getText();
        }
        public void acceptAlert(){
            driver.switchTo().alert().accept();
        }
    }
}
