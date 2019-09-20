package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BuyProductOnArt {
    public void buyProd(WebDriver driver, String art) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bottom-cart\"]/span[1]/span[1]")).click();//корзина
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/" +
                "section/div/div/div[2]")).click();//добавить товар по артикулу
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/section/div/" +
                "div/div[2]/div/input")).sendKeys(art);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/section/" +
                "div/div/div[2]/div/div")).click();

    }


    public void buyProdForTwoPeople(WebDriver driver, String art) throws InterruptedException {
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//*[@id=\"bottom-cart\"]/span[1]/span[1]")).click();//корзина
        Thread.sleep(2000);
        if(driver.getPageSource().contains("Ваша корзина пуста")){
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/" +
                    "section/div/div/div[2]")).click();//добавить товар по артикулу
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/section/div/" +
                    "div/div[2]/div/input")).sendKeys(art);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/section/" +
                    "div/div/div[2]/div/div")).click();
            //System.out.println("1");
        }
        else {
            //new ClearningBasketFromTheMainPage().cleanBasket(driver,actions);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"bottom-cart\"]/span[1]/span[1]")).click();//корзина
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/" +
                    "section/div/div/div[2]")).click();//добавить товар по артикулу
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/section/div/" +
                    "div/div[2]/div/input")).sendKeys(art);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/section/" +
                    "div/div/div[2]/div/div")).click();
        }
    }
}
