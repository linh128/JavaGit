/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package lab6;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("./Extensions/AdBlock.crx"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception {
        System.out.println("1====Input search value... ");
        WebElement searchbox = driver.findElement(By.id("search_product"));
        wait.until(ExpectedConditions.visibilityOfAllElements(searchbox));
        //Assert.assertEquals(false,ExpectedConditions.visibilityOfAllElements(searchbox),"Khong tim thay text search box");
        action.sendKeys(searchbox, key).build().perform();
        //System.out.println("...Inputed value: "+key+" !!!");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("2====Click search button...");
        WebElement searchbutton = driver.findElement(By.id("submit_search"));
        //Assert.assertEquals(false, searchbutton.isDisplayed());
        //searchbox.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(searchbutton));
        //Assert.assertEquals(false,ExpectedConditions.visibilityOfAllElements(searchbutton),"Khong tim thay search button");
        action.click(searchbutton).build().perform();
        //System.out.println("...Clicked Search success !!!");
        WebElement searched = driver.findElement(By.xpath(".//div[@class='features_items']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(searched));
        //Assert.assertEquals(true,ExpectedConditions.visibilityOfAllElements(searched),"Danh sach searched chua xuat hien");
        //System.out.println("...Searched result visible");
    }

    @Test
    public void test3() throws Exception {
        System.out.println("3====Add to cart...");
        WebElement result = driver.findElement(By.xpath("//img[@src='/get_product_picture/4']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(result));
        //Assert.assertEquals(false,ExpectedConditions.visibilityOfAllElements(result),"Khong tim thay product can tim");
        action.moveToElement(result).build().perform();
        //System.out.println("...Hover to the image");
        WebElement addTC = driver.findElement(By.xpath("//a[@data-product-id='4' and @class='btn btn-default add-to-cart']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(addTC));
        //Assert.assertEquals(false,ExpectedConditions.visibilityOfAllElements(addTC),"Khong tim thay button add to cart");
        action.click(addTC).build().perform();
        //System.out.println("...Click Add to cart");
        WebElement successButton = driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(successButton));
        //Assert.assertEquals(false,ExpectedConditions.visibilityOfAllElements(successButton),"Add to cart khong thanh cong");
        action.click(successButton).build().perform();
    }
    
    @Test
    public void test4() throws Exception {
        System.out.println("4====Go to cart...");
        WebElement cart = driver.findElement(By.xpath("//a[@href='/view_cart']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(cart));
        //Assert.assertEquals(true,ExpectedConditions.visibilityOfAllElements(cart),"Go to Cart khong thanh cong");
        action.click(cart).build().perform();
        //System.out.println("...Go to cart success");
        
        
    }
    
    @Test
    public void test5() throws Exception {
        System.out.println("4====Checking cart...");
        WebElement item = driver.findElement(By.xpath("//*[contains(text(),'Women > Dress')]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(item));
        
    }

    @AfterTest
    public void closeTest() throws Exception {
        System.out.println("====Automation Test DONE====");
        driver.close();
    }
}
