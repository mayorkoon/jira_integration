package com.demo.project;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.io.File;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.demo.utility.JiraCreateIssue;
public class HomePage {

    private WebDriver driver;

    private String baseUrl;


@BeforeClass(alwaysRun = true)

    public void setUp() throws Exception {

    //File chromedriverExecutable = new File("driver/chromedriver.exe");

    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    //options.addArguments("headless");
    //System.setProperty("webdriver.chrome.driver", chromedriverExecutable.getAbsolutePath());

    driver = new ChromeDriver(options);

    baseUrl = "https://www.browserstack.com/";

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

    @JiraCreateIssue(isCreateIssue=true)
    @Test(enabled = true)
    public void verifyHomepageHeaderText() throws Exception {
    driver.get(baseUrl);
    WebElement  el = driver.findElement(By.xpath("//h1[1]"));
    assertEquals(el.getText(),"Browser Testing Made Easy","Wrong header text displayed in Homepage");

 }
    @JiraCreateIssue(isCreateIssue=true)
    @Test(enabled = true)
    public void verifyHomePageLogo() throws Exception {
    driver.get(baseUrl);
    WebElement el = driver.findElement(By.id("logo"));
    assertEquals(el.getText(),"The browserstack logo not displaying in home pagesdf");
}


    @AfterClass(alwaysRun=true)

    public void tearDown()throws Exception{

    driver.quit();
}

}