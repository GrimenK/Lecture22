import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.PageObjectWikipedia;
import pageObject.WikiLoginPage;
import webdriver.Driver;

public class WikiTest {
    Driver driver;

    @BeforeMethod
    public void innit(){
        driver = new Driver();
    }

    @Test(priority = 1)
    public void firstTaskTest(){
        driver.getWebDriver().get("https://uk.wikipedia.org/");
        PageObjectWikipedia wikiPage = new PageObjectWikipedia(driver);
        wikiPage
                .clickEngLang();
        Assert.assertTrue(wikiPage.titlePage.getText().equals("Main page"));

        wikiPage
                .clickLogInLink();
        WikiLoginPage loginPage = new WikiLoginPage(driver);

        loginPage
                .inputUserLogin("Trolodor")
                .inputPassword("wikitest1")
                .selectCheckbox()
                .clickLogInButton();

        Assert.assertTrue(wikiPage.userpageBlock.isDisplayed());

        wikiPage.enterSearch("Ukraine")
        .selectSearchResultDropDown(1);
        Assert.assertTrue(wikiPage.articleTitle.getText().equals("Ukraine"));
    }

    @Test(priority = 2)
    public void secondTaskTest(){
        driver.getWebDriver().get("https://uk.wikipedia.org/");
        PageObjectWikipedia wikiPage = new PageObjectWikipedia(driver);
        wikiPage
                .clickEngLang();
        Assert.assertTrue(wikiPage.titlePage.getText().equals("Main page"));

        wikiPage
                .clickLogInLink();

        WikiLoginPage loginPage = new WikiLoginPage(driver);

        loginPage
                .inputUserLogin("Trolodor")
                .inputPassword("aaaaaaaaaa")
                .clickLogInButton();

        new WebDriverWait(driver.getWebDriver(),5).until(ExpectedConditions.visibilityOf(loginPage.errorBox));
        Assert.assertTrue(loginPage.errorBox.getText().equals("Incorrect username or password entered. " +
                "Please try again."));

    }

    @AfterMethod
    public void teardown(){
        driver.getWebDriver().close();
    }
}
