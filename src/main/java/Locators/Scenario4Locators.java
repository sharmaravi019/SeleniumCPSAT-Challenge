package Locators;

import org.openqa.selenium.By;

public class Scenario4Locators
{
    public By drpdwnColor = By.xpath("//button[contains(text(),'Color')]");

    public By chkboxBlackColor = By.xpath("//div[@class='checkbox']/following-sibling::label[text()='Black']");

    public By imageProduct = By.xpath("//img[contains(@class,'Product__ProductImg')]");

    public By bannerQuickView = By.xpath("//img[contains(@class,'Product__ProductImg')]//button[text()='QUICK VIEW']");

    public By titleProduct = By.xpath("//h1[contains(@class,'Heading-sc')]//a");

    public By btnClose = By.xpath("//button[contains(@class,'styles_closeButton')]");

    public By panelFilter = By.xpath("//div[@class='_1C7t6hCkKmMddDs8HIk_KY']");

    public By lnkElectronics = By.linkText("Electronics");
}