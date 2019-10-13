package seleniumCPSATChallenge;

import Locators.Scenario2Locators;
import Locators.Scenario3Locators;
import Locators.Scenario4Locators;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Scenario234Suite extends BaseScenario
{
    @Test
    public void scenario2() {
        Scenario2Locators locators = new Scenario2Locators();

        WebDriver driver = initializeBrowser(BROWSER_FIREFOX);

        launchUrl(scenario2URL, driver);

        String numberOfAttendees = "3";

        getWebElement(driver, locators.drpdwnNumberOfAttendees).sendKeys(numberOfAttendees);

        waitForElement(driver, locators.tblNumberOfAttendees);

        int rowCount = getWebElement(driver, locators.tblNumberOfAttendees).findElements(By.tagName("select")).size();

        Assert.assertEquals("Number of Row Count Should be equal", Integer.parseInt(numberOfAttendees), rowCount);

        Select select = new Select(getWebElement(driver, By.id(String.format(locators.drpdwnTableTitle, 2))));
        System.out.println("Select 1st-row title as ‘Admiral’");
        select.selectByVisibleText("Admiral");

        select = new Select(getWebElement(driver, By.id(String.format(locators.drpdwnTableTitle, 3))));
        System.out.println("Select 2nd-row title as ‘CA’ ");
        select.selectByValue("CA");

        select = new Select(getWebElement(driver, By.id(String.format(locators.drpdwnTableTitle, 4))));
        List<WebElement> dropdownOptions = select.getOptions();
        for (int j = 0; j < dropdownOptions.size(); j++)
        {
            if (dropdownOptions.get(j).getText().equals("CS")) {
                System.out.println("Select 3rd-row title as ‘CS’");
                select.selectByIndex(j);
            }
        }

        System.out.println("Print all the options that are available in the title: \n");
        dropdownOptions.forEach(options -> System.out.println(options.getText()));

        // Close Browser
        driver.quit();
    }

    @Test
    public void scenario3()
    {
        Scenario3Locators locators = new Scenario3Locators();
        WebDriver driver = initializeBrowser(BROWSER_FIREFOX);

        launchUrl(scenario3URL, driver);

        //Sometimes there is a advertisement pop up comes up on every page, we are closing this pop-up if it present on page.
        closeAdvertisePopUp(driver, locators);

        getWebElement(driver, By.className("subNav")).findElement(By.linkText("Tables")).click();

        closeAdvertisePopUp(driver, locators);

        WebElement teamName = getWebElement(driver, locators.lnkArsenal);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        Actions action = new Actions(driver);
        action.contextClick(teamName).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        //Switch to the newly open window
        driver.switchTo().window(driver.getWindowHandles().iterator().next());

        String pageUrl = driver.getCurrentUrl();

        System.out.println("Step 3: Page url is " + pageUrl);

        String pageTitleNewwindow = driver.getTitle();

        System.out.println("Step 4: New Window Page Title is " + pageTitleNewwindow);

        // Switch to main window
        driver.switchTo().defaultContent();

        String pageTitleMainwindow = driver.getTitle();

        System.out.println("Step 6: Main Page Title is " + pageTitleMainwindow);

        // Close Browser
        driver.quit();
    }

    @Test
    public void scenario4()
    {
        Scenario4Locators locators = new Scenario4Locators();
        WebDriver driver = initializeBrowser(BROWSER_FIREFOX);

        launchUrl(scenario4URL, driver);

        getWebElement(driver, locators.lnkElectronics).click();

        getWebElement(driver, locators.drpdwnColor).click();

        getWebElement(driver, locators.chkboxBlackColor);

        WebElement productImage = getWebElement(driver, locators.imageProduct);

        Actions actions = new Actions(driver);

        actions.moveToElement(productImage);

        getWebElement(driver, locators.bannerQuickView);

        boolean isTrue = getWebElement(driver, locators.titleProduct).getText().contains(COLOR_BLACK);

        Assert.assertTrue(isTrue);

        getWebElement(driver, locators.btnClose).click();

        boolean isPresent = getWebElement(driver, locators.panelFilter).getText().contains(COLOR_BLACK);

        Assert.assertTrue(isPresent);

        // Close Browser
        driver.quit();
    }

    private void closeAdvertisePopUp(WebDriver driver, Scenario3Locators locators)
    {
        WebElement advertiseClose = getWebElement(driver, locators.btnCloseAdv);
        if (advertiseClose.isDisplayed()) {
            advertiseClose.click();
        }
    }
}
