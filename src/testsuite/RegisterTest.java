package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

/**
 * Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userSholdRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Emai
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */
public class RegisterTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay(){
        driver.findElement(By.linkText("Create an Account")).click();
        String expectedText = "Create an Account";
        String actualText = driver.findElement(By.xpath("//span[text() ='Create an Account']")).getText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully(){
        driver.findElement(By.linkText("Create an Account")).click();

        driver.findElement(By.id("firstname")).sendKeys("Jack");
        driver.findElement(By.id("lastname")).sendKeys("Shrof");

        Random random = new Random();
        int emailField = random.nextInt(1000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jack"+emailField+"@gmail.com");
        driver.findElement(By.id("password")).sendKeys("jack123!");
        driver.findElement(By.id("password-confirmation")).sendKeys("jack123!");
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();

        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals(expectedText,actualText);

        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        String expectedMessage =  "You are signed out";
        String actualMessage = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
