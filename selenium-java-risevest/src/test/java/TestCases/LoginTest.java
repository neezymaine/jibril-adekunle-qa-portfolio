package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTest.BaseTest;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void login_successful() {
        String email = System.getenv("TEST_EMAIL");
        String password = System.getenv("TEST_PASSWORD");

        if (email == null || password == null) {
            throw new IllegalStateException("Set TEST_EMAIL and TEST_PASSWORD environment variables before running the valid-login test.");
        }

        driver.manage().window().maximize();
        driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys(email);
        driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys(password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(loc.getProperty("submitButton"))));
        submitButton.click();
    }

    @Test(priority = 2)
    public void login_emptyEmail() {
        driver.manage().window().maximize();
        driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("");
        driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("dummy-password");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton")))).click();

        SoftAssert softAssert = new SoftAssert();
        String actualError = driver.findElement(By.xpath(loc.getProperty("emptyEmail"))).getText();
        softAssert.assertEquals(actualError, "Enter your email address");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void login_emptyPassword() {
        driver.manage().window().maximize();
        driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("test@example.com");
        driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton")))).click();

        SoftAssert softAssert = new SoftAssert();
        String actualError = driver.findElement(By.xpath(loc.getProperty("emptyPassword"))).getText();
        softAssert.assertEquals(actualError, "Enter your password");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void login_emptyPassword_emptyEmail() {
        driver.manage().window().maximize();
        driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("");
        driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton")))).click();

        SoftAssert softAssert = new SoftAssert();
        String actualEmailError = driver.findElement(By.xpath(loc.getProperty("emptyEmail"))).getText();
        String actualPasswordError = driver.findElement(By.xpath(loc.getProperty("emptyPassword"))).getText();
        softAssert.assertEquals(actualEmailError, "Enter your email address");
        softAssert.assertEquals(actualPasswordError, "Enter your password");
        softAssert.assertAll();
    }
}
