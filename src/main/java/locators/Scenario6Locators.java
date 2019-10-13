package locators;

import org.openqa.selenium.By;

public class Scenario6Locators
{
    public By searchIcon = By.xpath("//div[@class='floatright spirit-bg search-icon searchIcon']");

    public By txtSearchBox = By.id("searchkey");

    public By btnSearch = By.id("searchBtn");

    public By rdbtnHighToLow = By.xpath("//li[@class='spaceright radioSortBy']//label[@class='spirit-bg radio1']");

    public String productPriceList = "//div[@id='categoryProductList']//section[contains(@id,'categoryProduct')][%s]//span[@class='mrp']";
}