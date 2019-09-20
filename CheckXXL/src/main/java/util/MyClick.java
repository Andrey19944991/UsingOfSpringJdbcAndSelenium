package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyClick {

    private WebDriverWait webDriverWait;


    public MyClick(WebDriverWait webDriverWait){
        this.webDriverWait=webDriverWait;
    }

    public void clickOnXPath(WebDriver driver, String path){
        while (driver.findElements(By.xpath(path)).isEmpty()){}
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(path))).click();
    }

    public void clickOnClassName(String name){
    }

    public void sendOnXPath(String path, String message){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path))).sendKeys(message);
    }

    public void sendOnId(String id, String message){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).sendKeys(message);
    }

    public void sendOnName(String name, String message){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(name))).sendKeys(message);
    }


}
