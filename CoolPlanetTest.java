import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CoolPlanetTest {

    WebDriver driver;

    @BeforeEach
    public void OpenPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://coolplanet.lk/");
    }

//    @AfterEach
//    public void ClosePage(){
//        driver.close();
//    }

    @Test
    public void SearchItemsTest(){
        WebElement Search = driver.findElement(By.xpath("//input[@name='q']"));
        Search.sendKeys("ladies pants" + Keys.ENTER);

//        WebElement selectItem = driver.findElement(By.xpath("//img[@src='//coolplanet.lk/cdn/shop/files/IMG_9873.jpg?v=1702550304&width=1200']"));
//        selectItem.click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='//coolplanet.lk/cdn/shop/files/IMG_9873.jpg?v=1702550304&width=1200']")));
//        element.click();


        WebElement element = driver.findElement(By.xpath("//img[@src='//coolplanet.lk/cdn/shop/files/IMG_9873.jpg?v=1702550304&width=1200']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);


        WebElement AddToCart = driver.findElement(By.xpath("//button[@class='product-form__add-button button button--primary']"));
        AddToCart.click();

    }

    @Test
    public void RegisterTest(){
        WebElement SignIn = driver.findElement(By.xpath("//a[@class='header__action-item-link hidden-pocket hidden-lap']"));
        SignIn.click();

        WebElement NewSignIn = driver.findElement(By.xpath("//a[@class='link link--accented']"));
        NewSignIn.click();

        WebElement FName = driver.findElement(By.id("customer[first_name]"));
        FName.sendKeys("Isurika");

        WebElement LName = driver.findElement(By.id("customer[last_name]"));
        LName.sendKeys("Dhananji");

        WebElement Email = driver.findElement(By.id("customer[email]"));
        Email.sendKeys("hvdisurikadhananji@gmail.com");

        WebElement Pwd = driver.findElement(By.id("customer[password]"));
        Pwd.sendKeys("Isurika@123");

//        WebElement Submit = driver.findElement(By.xpath("//button[@class='form__submit button button--primary button--full']"));
//        Submit.click();
//        String expectedTitle = "Account";
//        String actualTitle = driver.getTitle();
//
//        Assert.assertEquals(expectedTitle, actualTitle, "Title mis matched");

        WebElement submit = driver.findElement(By.xpath("//button[@class='form__submit button button--primary button--full']"));
        submit.click();

// Wait for the next page to load or for a specific element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Account")); // Wait for the title to be the expected one

        String expectedTitle = "Account";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched");
    }

 @Test
    public void LoginTest(){
    WebElement SignIn = driver.findElement(By.xpath("//a[@class='header__action-item-link hidden-pocket hidden-lap']"));
    SignIn.click();

    WebElement Email = driver.findElement(By.id("customer[email]"));
    Email.sendKeys("hvdisurikadhananji@gmail.com");

    WebElement Pwd = driver.findElement(By.id("customer[password]"));
    Pwd.sendKeys("Isu@1234");

    WebElement Submit = driver.findElement(By.xpath("//button[@class='form__submit button button--primary button--full']"));
     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Submit);

     // Wait until the title changes to "Account" or other expected behavior
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.titleIs("Account"));

     // Get the actual title and validate
     String expectedTitle = "Account";
     String actualTitle = driver.getTitle();

     if (expectedTitle.equals(actualTitle)){
         System.out.println("Successfully logged in");
     } else {
         System.out.println("Failed to log in");
     }
 }








 }






