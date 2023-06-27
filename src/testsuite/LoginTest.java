package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on Login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //Verify the text secure area
        String expectedText="Secure Area";
        String actualText=driver.findElement(By.xpath("//h2[text()='secure Area']")).getText();
        Assert.assertEquals("Message is displayed",actualText,expectedText);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on Login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //Verify the error message invalid username
        String expectedText="Your username is invalid! ";
        String actualText=driver.findElement(By.xpath("/div[@id='flash']")).getText();
        Assert.assertEquals("Text is not displayed",expectedText,actualText);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on Login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        //verify that your password is invalid
        String expectedMessage="Your password is invalid!";
        String actualMessage=driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals("Your password is invalid",expectedMessage,actualMessage);
    }




    @After
    public void tearDown() {
        closeBrowser();

    }
}