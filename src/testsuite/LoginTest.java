package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials()
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("jackshrof99@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("jack123!");
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expectedMessage = "Welcome, Jack Shrof!";
        String actualMessage = driver.findElement(By.xpath("//span[text()='Welcome, Jack Shrof!']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("Rajpatel@gmal.com");
        driver.findElement(By.id("pass")).sendKeys("321!Prime");
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText = driver.findElement(By.xpath("//div[text() = 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("jackshrof99@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("jack123!");
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expected = "Welcome, Jack Shrof!";
        String actual = driver.findElement(By.xpath("//span[text()='Welcome, Jack Shrof!']")).getText();
        Assert.assertEquals(expected, actual);

        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        String expectedDisplay = "You are signed out";
        String actualDisplay = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals(expectedDisplay, actualDisplay);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
