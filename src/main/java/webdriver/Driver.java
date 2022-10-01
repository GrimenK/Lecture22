package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    private WebDriver webDriver;

    public Driver(){
        webDriver = null;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/drivers/chromedriver");
        ChromeOptions params = new ChromeOptions();
        params.addArguments("window-size=1024,768");
        params.addArguments("--start-fullscreen");
        params.addArguments("enable-automation");
        params.addArguments("--disable-extensions");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }
}
