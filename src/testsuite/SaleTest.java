package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */
public class SaleTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {

        driver.findElement(By.xpath("//span[text()='Sale']")).click();
        driver.findElement(By.xpath("//a[@ href=\"https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html\" and text()='Jackets']")).click();
        String expected = "Jackets";
        String actual = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expected, actual);

        int expected2 = 12;
        int actual2 = driver.findElements(By.xpath("//li[@class='item product product-item']")).size();
        Assert.assertEquals("Correct amount not displayed", expected2, actual2);

        List<WebElement> items = driver.findElements(By.xpath("//a[@class='product-iten-link']"));
        for (WebElement item3 : items) {
            System.out.println(item3.getText());
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

