package com.example.ui;

import com.example.Controller.model.Article;
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
import org.springframework.context.annotation.Import
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@SpringBootTest(classes = IngliApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Import(Creator.class)
public class ArticleTest {

    private WebDriver driver;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    Creator creator;

    @BeforeAll
    static void init(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
    }

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        articleRepository.deleteAll();
    }

    @AfterClass
    public void cleanup(){
        if(driver !=null)
            driver.quit();
    }

    @Test
    public void articleList() throws InterruptedException{

        creator.saveEntities(
            new Article(title: "title1"),
            new Article(title: "title2"),
            new Article(title: "title3"),
        )

        driver.get("http://localhost:8080/articles");

        Assert.assertEquals("title1", driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr/td[text()='title1']")).text)
        Assert.assertEquals("title2", driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr/td[text()='title2']")).text)
        Assert.assertEquals("title3", driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr/td[text()='title3']")).text)
    }


}
