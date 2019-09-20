package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetInTheSite {

    private InputLoginAndPasswordInFullVersion inputLoginAndPasswordInFullVersion;

    public GetInTheSite(InputLoginAndPasswordInFullVersion inputLoginAndPasswordInFullVersion) {
        this.inputLoginAndPasswordInFullVersion = inputLoginAndPasswordInFullVersion;
    }

    public void getIn(WebDriver driver, String numTel) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/header/nav[1]/div/ul[2]/li[4]/a/span")).click();
        Thread.sleep(3000);//вход
        inputLoginAndPasswordInFullVersion.input(driver, numTel);

    }
}
