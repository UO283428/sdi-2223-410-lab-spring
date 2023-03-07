package com.uniovi.notaneitor.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView{
    static public void fillLoginForm(WebDriver driver, String userp, String passwordp) {
        WebElement user = driver.findElement(By.name("username"));
        user.click();
        user.clear();
        user.sendKeys(userp);
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys(passwordp);
        //Pulsar el boton de Alta.
        By login = By.className("btn");
        driver.findElement(login).click();
    }
}
