package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ClearningBasketFromTheMainPage {

    public  void cleanBasketInMobileVersion(WebDriver driver, MyClick myClick) throws InterruptedException {
        Thread.sleep(1000);

    }


    public void cleanBasket(WebDriver driver, MyClick myClick) throws InterruptedException {
        Thread.sleep(3000);
        if(driver.findElement(By.xpath("//*[@id=\"bottom-cart\"]/span[3]")).getText().equals("Пока пусто")){
            System.out.println("Корзина пуста");

        }
        else {

            myClick.clickOnXPath(driver,"//*[@id=\"bottom-cart\"]/span[1]");// корзина

            while (driver.findElements(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/div[1]/div/div[2]/" +
                    "button")).isEmpty()){}

            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/" +
                    "div[1]/div/div/div/section/div[1]/div[1]/div/div[2]/button")));

            driver.switchTo().alert().accept();

            Thread.sleep(3000);

            while (driver.findElements(By.xpath("/html/body/div[1]/div/header/nav[2]/div/div/div[1]/div/a")).isEmpty()){}

            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/" +
                    "div[1]/div/header/nav[2]/div/div/div[1]/div/a")));

            System.out.println("Корзина пуста");

        }

    }
}
