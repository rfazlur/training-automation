package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {
    @Test
    public void testSuccessLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // step untuk membuka browser dan halaman website
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs");

        // step untuk login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);

        // validasi login sukses
        driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
        Thread.sleep(1000);

        driver.close();
        driver.quit();
    }
}
