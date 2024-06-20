/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package lab6;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.yaml.snakeyaml.tokens.Token.ID.Key;

/**
 *
 * @author Administrator
 */
public class Lab6NGTest {

    private static WebDriver driver;
    private static String url = "https://automationexercise.com/products";
    private static String key = "Stylish Dress";
    //private static String key = "Linh dep trai";
    private static Actions action;
    private static WebDriverWait wait;

    @BeforeClass
    public static void init() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 15);
        
        ChromeOptions chr = new ChromeOptions();
        chr.addExtensions(new File(".Extensions/AdBlock.crx"));
        

    }

    @Test
    public void testGetURL() throws Exception {
        System.out.println("Input search value: " + key);

        WebElement searchbox = driver.findElement(By.id("search_product"));
        wait.until(ExpectedConditions.elementToBeClickable(searchbox));
        action.sendKeys(searchbox, key).build().perform();

    }
//
//    @Test
//    public void testSearch() throws Exception {
//        System.out.println("Click search button...");
//        WebElement searchbutton = driver.findElement(By.id("submit_search"));
//        //searchbox.click();
//        wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
//        action.click(searchbutton).build().perform();
//    }
//
//    @Test
//    public void testAddToCart() throws Exception {
//        System.out.println("Add to cart...");
//        WebElement addTC = driver.findElement(By.linkText("View Product"));
////        action.moveToElement(addTC).build().perform();
//        wait.until(ExpectedConditions.elementToBeClickable(addTC));
//        action.click(addTC).build().perform();
//    }

//    @Test
//    public void testCheckCart() throws Exception {
//        System.out.println("Checking Cart...");
//        //WebElement addTC = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
//        WebElement addTC = driver.findElement(By.linkText("Cart"));
//        //addTC.click();
//        action.click(addTC).perform();
//    }
    @AfterTest
    public void closeTest() throws Exception {
        System.out.println("Automation Test DONE");
        //driver.close();
    }
}
