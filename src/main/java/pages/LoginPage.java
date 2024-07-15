package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;
    private By userName= By.cssSelector("input[name='uid']");
    private By Password=By.cssSelector("input[name='password']");
    private By loginButton=By.cssSelector("input[value='LOGIN']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
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
    public HomePage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
