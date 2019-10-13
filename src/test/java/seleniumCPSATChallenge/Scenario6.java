package seleniumCPSATChallenge;


import locators.Scenario6Locators;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scenario6 extends BaseScenario
{
    @Test
    public void scenario6() throws IOException
    {
        Scenario6Locators locators = new Scenario6Locators();

        WebDriver driver = initializeBrowser(BROWSER_CHROME);

        launchUrl(scenario6URL, driver);

        List<String> listOfProducts = getProductsFromFile();

        for (String product : listOfProducts)
        {
            getWebElement(driver, locators.searchIcon).click();

            getWebElement(driver, locators.txtSearchBox).sendKeys(product);

            getWebElement(driver, locators.btnSearch).click();

            getWebElement(driver, locators.rdbtnHighToLow).click();

            int price = Integer.parseInt(getWebElement(driver, By.xpath(String.format(locators.productPriceList, 1))).getText().replace("R", "").trim());

            for (int i = 2; i <= 8; i++)
            {
                int currentPrice = Integer.parseInt(getWebElement(driver, By.xpath(String.format(locators.productPriceList, i))).getText().replace("R", "").trim());

                Assert.assertTrue(price >= currentPrice);

                price = currentPrice;
            }
        }

        driver.quit();
    }

    private List<String> getProductsFromFile() throws IOException
    {
        List<String> products = new ArrayList<>();

        File file = new File(System.getProperty("user.dir") + FILE_PATH);

        FileInputStream inputStream = new FileInputStream(file);

        Workbook productBook = new XSSFWorkbook(inputStream);

        Sheet productSheet = productBook.getSheetAt(0);

        int rows = productSheet.getLastRowNum() - productSheet.getFirstRowNum();

        for (int i = 0; i <= rows; i++)
        {
            Row row = productSheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++) {

                products.add(row.getCell(j).getStringCellValue());
            }
        }
        return products;
    }
}