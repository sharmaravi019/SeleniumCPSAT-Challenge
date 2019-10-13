package locators;

import org.openqa.selenium.By;

public class Scenario3Locators
{
    public By btnCloseAdv = By.id("advertClose");

    public By lnkArsenal = By.xpath("//tr[@class='tableMid']//span[@class='long'][contains(text(),'Arsenal')]");
}