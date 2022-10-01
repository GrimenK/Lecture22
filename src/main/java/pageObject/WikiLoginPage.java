package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Driver;

public class WikiLoginPage {
    Driver driver;

    public WikiLoginPage(Driver driver){
        this.driver = driver;
        PageFactory.initElements(driver.getWebDriver(), this);
    }

    public WikiLoginPage getWikiPage(){
        return this;
    }

    @FindBy(xpath = "//input[@id = 'wpName1']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id = 'wpPassword1']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name= 'wpRemember']")
    private WebElement checkboxRemember;

    @FindBy(xpath = "//button[@id= 'wpLoginAttempt']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains (@class, 'mw-message-box-error')]")
    public WebElement errorBox;


    public WikiLoginPage inputUserLogin(String login){
        loginInput.sendKeys(login);
        return getWikiPage();
    }


    public WikiLoginPage inputPassword(String pass){
        passwordInput.sendKeys(pass);
        return getWikiPage();
    }

    public WikiLoginPage selectCheckbox(){
        checkboxRemember.click();
        return getWikiPage();
    }

    public PageObjectWikipedia clickLogInButton(){
        new WebDriverWait(driver.getWebDriver(),5).until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new PageObjectWikipedia(this.driver);
    }

}
