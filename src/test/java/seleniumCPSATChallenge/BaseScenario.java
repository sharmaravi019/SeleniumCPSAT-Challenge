package seleniumCPSATChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScenario
{

    public static final String BROWSER_CHROME = "chrome";

    public static final String BROWSER_FIREFOX = "firefox";

    public static final String FILE_PATH = "/src/test/resources/Products.xlsx";

    public static final String COLOR_BLACK = "Black";


    public static String scenario1URL = "https://www.meripustak.com/";

    public static String scenario2URL = "https://www.cii.in/OnlineRegistration.aspx";

    public static String scenario3URL = "https://www.premierleague.com/";

    public static String scenario4URL = "https://www.hometown.in/";

    public static String scenario6URL = "https://www.woodlandworldwide.com/";


    public WebDriver initializeBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");

            return new FirefoxDriver();
        } else
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

            return new ChromeDriver();
        }
    }

    public void launchUrl(String url, WebDriver driver)
    {
        driver.manage().window().maximize();

        driver.get(url);
    }

    public WebElement getWebElement(WebDriver driver, By by)
    {
        return driver.findElement(by);
    }

    public void waitForElement(WebDriver driver, By locator)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10000);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}