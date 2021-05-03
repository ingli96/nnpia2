package com.example.ui;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class UserTest {

    private WebDriver driver;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void cleanup(){
        if(driver !=null)
            driver.quit();
    }

    @Test
    public void editIdTest() throws InterruptedException{
        driver.get("http://localhost:8080/users");

        driver.findElement(new By.ByXPath("/html/body/div/p/a")).click();
        Thread.sleep(500);
        driver.findElement(new By.ByXPath("//*[@id='firstName']")).sendKeys("Name");
        Thread.sleep(500);
        driver.findElement(new By.ByXPath("/html/body/form/input[3]")).click();
        Thread.sleep(500);
        String nameInList = driver.findElement(new By.ByXPath("/html/body/div/div/table/tbody/tr/td[2]")).getText();
        Thread.sleep(500);
        driver.findElement(new By.ByXPath("/html/body/div/div/table/tbody/tr/td[4]/a")).click();
        Thread.sleep(500);
        String nameInUpdate = driver.findElement(new By.ByXPath("//*[@id=\"firstName\"]")).getAttribute("value");

        Thread.sleep(500);
        Assertions.assertEquals(nameInList, nameInUpdate);
        driver.findElement(new By.ByXPath("/html/body/header/nav/ul/li[1]/a")).click();
        Thread.sleep(500);
        driver.findElement(new By.ByXPath("/html/body/div/div/table/tbody/tr/td[5]/a")).click();
        driver.close();
    }

}
