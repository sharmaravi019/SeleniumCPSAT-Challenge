package seleniumCPSATChallenge;

import locators.Scenario1Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Scenario1 extends BaseScenario
{
    Scenario1Locators locators = new Scenario1Locators();

    String emptyCartMessage = "No Item is Added In Cart yet.Cart is Empty!!!";

    @Test
    public void scenario1()
    {
        String bookName = "OCP Java SE 8: Programmer II Exam Guide";
        WebDriver driver = initializeBrowser(BROWSER_CHROME);

        launchUrl(scenario1URL, driver);
        // Step 1: Print the width and height of the logo
        printWidthAndHeightOfLogo(driver);

        // Step 2: Twitter href
        printTwitterHref(driver);

        // Step 3 & 4: Click on the shopping cart when an item in the cart is 0 and verify empty cart message
        assertEmptyShoppingCartMessage(driver);

        // Step 5 & 6: Add anyone java book in cart
        addJavaBook(driver, bookName);

        // Close the browser
        driver.quit();
    }

    private void printWidthAndHeightOfLogo(WebDriver driver)
    {
        int height = getWebElement(driver, locators.imgLogo).getSize().height;

        int width = getWebElement(driver, locators.imgLogo).getSize().width;

        System.out.println("Step 1: Width of Logo is " + width + " and Height of Logo is " + height);
    }

    private void printTwitterHref(WebDriver driver)
    {
        List<WebElement> links = getWebElement(driver, locators.socialLinkXpath).findElements(By.tagName("a"));

        for (WebElement e : links) {
            if (e.getAttribute("href").contains("twitter")) {
                System.out.println("Step 2: Twitter href is " + e.getAttribute("href"));
            }
        }
    }

    private void assertEmptyShoppingCartMessage(WebDriver driver)
    {
        if (getWebElement(driver, locators.lblNoCartItem).getText().equalsIgnoreCase("0 Item")) {

            getWebElement(driver, locators.lnkShoppingCart).click();

            String actualMessage = getWebElement(driver, locators.cartItemsTable).findElement(By.tagName("h4")).getText();

            Assert.assertEquals(actualMessage, emptyCartMessage);

            System.out.println("Step 3 and 4 Succeeded");
        }
        else
        {
            Assert.fail("Cart is not empty");
        }
    }

    private void addJavaBook(WebDriver driver, String bookName)
    {
        getWebElement(driver, locators.txtBoxsearch).sendKeys(bookName);

        getWebElement(driver, locators.searchBtn).click();

        waitForElement(driver, locators.listOfBooks);

        List<WebElement> bookList = getWebElement(driver, locators.listOfBooks).findElements(By.tagName("li"));

        for (WebElement e : bookList)
        {
            if (e.findElement(locators.titleBooks).findElement(By.tagName("a")).getText().equalsIgnoreCase(bookName)) {
                e.click();
                break;
            }
        }

        getWebElement(driver, locators.btnAddToCart).click();

        String notEmptyCartMessage = getWebElement(driver, locators.cartItemsTable).getText();

        Assert.assertFalse(notEmptyCartMessage.contains(emptyCartMessage));

        System.out.println("Step 5 & 6 Succeeded");
    }
}