package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class OpenGoogleChrome {
    public void openMobilVersion(WebDriver driver,ChromeOptions options) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\chekov.a.a\\Desktop\\source\\chromedriver.exe");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        options.addArguments("--incognito");



        driver.manage().window().maximize();
        driver.get("https://m.ulmart.ru/");
        Thread.sleep(3000);
    }
    public void openFullVersion(WebDriver driver) throws InterruptedException{

        driver.manage().window().maximize();
        driver.get("http://www.1.dev.web.ulmart.ru/");
        Thread.sleep(3000);

    }
}
