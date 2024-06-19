/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package lab6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Administrator
 */
public class Lab6NGTest {

    private static WebDriver driver;

    @BeforeClass
    public static void init() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/products");
    }

    @Test
    public void testInput() throws Exception {
        System.out.println("Input search value");
        WebElement searchbox = driver.findElement(By.id("search_product"));
        searchbox.sendKeys("Stylish Dress");
    }

    @Test
    public void testSearch() throws Exception {
        System.out.println("Click search button");
        WebElement searchbox = driver.findElement(By.id("submit_search"));
        searchbox.click();
    }
    
    @AfterTest
    public void closeTest() throws Exception {
        driver.close();
    }
}
