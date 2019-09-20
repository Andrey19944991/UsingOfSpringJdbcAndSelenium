package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloseIframe {
    public void close(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.className("sp-fancybox-iframe")));
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//*[contains (@id, 'icon-close-button')]"));
        closeButton.click();
        Thread.sleep(3000);
    }
}
