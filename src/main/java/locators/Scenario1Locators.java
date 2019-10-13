package locators;

import org.openqa.selenium.By;

public class Scenario1Locators
{
    public By txtBoxsearch = By.id("txtsearch");

    public By searchBtn = By.id("btnsearch");

    public By listOfBooks = By.id("book_list");

    public By titleBooks = By.className("book_list_name");

    public By btnAddToCart = By.id("ContentPlaceHolder1_AddtoCart");

    public By cartItemsTable = By.id("ContentPlaceHolder1_gvCartTable");

    public By lblNoCartItem = By.id("lblNoCartItem");

    public By lnkShoppingCart = By.xpath("//a[contains(text(),'Shopping Cart')]");

    public By imgLogo = By.id("mpstkLogo");

    public By socialLinkXpath = By.xpath("//div[@class='social links_right']");
}