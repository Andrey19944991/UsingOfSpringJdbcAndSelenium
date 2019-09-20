package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputLoginAndPasswordInFullVersion {
    public void input(WebDriver driver, String numTel) throws InterruptedException {
        MyClick myClick=new MyClick(new WebDriverWait(driver,60));

        myClick.clickOnXPath(driver,"//*[@id=\"entranceWay\"]/label[2]");

        myClick.sendOnXPath("//*[@id=\"ctrl4\"]",numTel);

        myClick.sendOnXPath("//*[@id=\"enter_password\"]","Ulmart01");

        String window=driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"captchaElement\"]/div[1]/div/iframe")));
        driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();

        //aria-checked
        WebElement element=driver.findElement(By.id("recaptcha-anchor"));
        while(!element.getAttribute("aria-checked").contains("true")) {
        }
        driver.switchTo().window(window);

        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[6]/div/div/button")).click();


        driver.findElement(By.xpath("//*[@id=\"contractor28249528\"]")).click();


        if(!driver.findElements(By.xpath("//*[@id=\"emailVerificationSuccessBlock\"]/div[2]/a[1]/button")).isEmpty()) {
            myClick.clickOnXPath(driver,"//*[@id=\"emailVerificationSuccessBlock\"]/div[2]/a[1]/button");
        }
    }
}
