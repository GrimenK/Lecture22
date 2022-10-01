package pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Driver;



public class PageObjectWikipedia {
    Driver driver;

    public PageObjectWikipedia(Driver driver){
        this.driver = driver;
        PageFactory.initElements(driver.getWebDriver(), this);
    }

    public PageObjectWikipedia getWikiPage(){
        return this;
    }

    @FindBy(xpath = "//li[@id = 'pt-login']//a")
    private WebElement logInLink;

    @FindBy(xpath = "//a[@lang = 'en']")
    private WebElement englishLangLink;

    @FindBy(xpath = "//li[@id = 'n-mainpage-description']//span")
    public WebElement titlePage;

    @FindBy(xpath = "//li[@id = 'pt-userpage']")
    public WebElement userpageBlock;

    @FindBy(xpath = "//input[@id = 'searchInput']")
    public WebElement searchInput;

    @FindBy(xpath = "//h1[@id = 'firstHeading']")
    public WebElement articleTitle;

    @FindBy(xpath = "//div[@class = 'suggestions-results']//a")
    public List<WebElement> searchResultsDropDown;


    public PageObjectWikipedia enterSearch(String query){
        searchInput.sendKeys(query);
        return this;
    }

    public PageObjectWikipedia selectSearchResultDropDown(int id){
        new WebDriverWait(driver.getWebDriver(),5).until(ExpectedConditions.visibilityOf(searchResultsDropDown.get(--id)));
        searchResultsDropDown.get(id).click();
        return this;
    }


    public WikiLoginPage clickLogInLink(){
        new WebDriverWait(driver.getWebDriver(),5).until(ExpectedConditions.elementToBeClickable(logInLink));
        logInLink.click();
        return new WikiLoginPage(this.driver);
    }

    public void clickEngLang(){
        new WebDriverWait(driver.getWebDriver(),5).until(ExpectedConditions.elementToBeClickable(englishLangLink));
        englishLangLink.click();
    }
}
