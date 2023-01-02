package Base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTests {

    public String username;
    public String password;

    private String pathToGlobalVariables = "/home/ferko/Desktop/IntelljProjects/sauceLabsProject/src/main/java/config/credentials";

    private EventFiringWebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    public CheckOutInfoPage checkOutInfoPage;

    public OverviewPage overviewPage;

    public CheckoutComplete checkoutComplete;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
    }

    @BeforeMethod
    public void goHome() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(pathToGlobalVariables);
        properties.load(fileInputStream);
        driver.get("https://www.saucedemo.com");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.setLoginButton();
        checkOutInfoPage = new CheckOutInfoPage(driver);
        overviewPage = new OverviewPage(driver);
        checkoutComplete = new CheckoutComplete(driver);



    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }
}

