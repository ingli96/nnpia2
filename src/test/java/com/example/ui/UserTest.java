package com.example.ui;

import com.example.IngliApplication;
import com.example.dao.ArticleRepository;
import com.example.datafactory.Creator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = IngliApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Import(Creator.class)
public class UserTest {

    private WebDriver driver;

    @Autowired
    ArticleRepository articleRepository;

    @BeforeAll
    static void init(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
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
