package com.example.ui;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldTest {

    @Test
    public void myFirstTestCase() {
        System.setProperty("webdriver.chrome.driver", "c:\\selenium\\libs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }
}