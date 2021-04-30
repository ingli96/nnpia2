package com.example.ui;

import com.example.datafactory.UserTestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(UserTestDataFactory.class)
public class UserTest {

    private WebDriver driver;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void editIdTest() throws InterruptedException{
        driver.get("http://localhost:8080/users");

        String idList = driver.findElement(new By.ByXPath("/html/body/div/div/table/tbody/tr/td[1]")).getText();
        Thread.sleep(1000);
        driver.findElement(new By.ByXPath("/html/body/div/div/table/tbody/tr/td[4]/a")).click();
        Thread.sleep(1000);
        String idDetail = driver.findElement(new By.ByXPath("/html/body/form/input[1]")).getAttribute("value");
        Assertions.assertEquals(idList, idDetail);
        driver.close();
    }

}
