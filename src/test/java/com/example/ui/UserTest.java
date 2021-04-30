package com.example.ui;

import com.example.Controller.model.User;
import com.example.dao.UserRepository;
import com.example.datafactory.UserTestDataFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeClass;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import(UserTestDataFactory.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    private WebDriver driver;

    @Autowired
    UserTestDataFactory userTestDataFactory;

    @Test
    public void getUserByNameLikeTest() {
        userTestDataFactory.saveUser();

        User userInDb = userRepository.findUserByFirstNameLike("est");
        Assertions.assertTrue(userInDb.getFirstName() == "Test Name");
    }


//    @BeforeClass
//    public void init(){
//        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void editIdTest() throws InterruptedException{
//
//
//        // Test na vytvoreni uzivatele
//        driver.get("http://localhost:8080/users");
//
//        driver.findElement(new By.ByXPath("/html/body/div/p/a")).click();
//        Thread.sleep(500);
//        driver.findElement(new By.ByXPath("//*[@id='firstName']")).sendKeys("Name");
//        Thread.sleep(500);
//        driver.findElement(new By.ByXPath("/html/body/form/input[3]")).click();
//        Thread.sleep(500);
//        String nameInList = driver.findElement(new By.ByXPath("/html/body/div/div/table/tbody/tr/td[2]")).getText();
//        Thread.sleep(500);
//        driver.findElement(new By.ByXPath("/html/body/div/div/table/tbody/tr/td[4]/a")).click();
//        Thread.sleep(500);
//        String nameInUpdate = driver.findElement(new By.ByXPath("//*[@id=\"firstName\"]")).getAttribute("value");
//
//        Thread.sleep(500);
//        Assertions.assertEquals(nameInList, nameInUpdate);
//        driver.findElement(new By.ByXPath("/html/body/header/nav/ul/li[1]/a")).click();
//        Thread.sleep(500);
//        driver.findElement(new By.ByXPath("/html/body/div/div/table/tbody/tr/td[5]/a")).click();
//        driver.close();
//    }

}
