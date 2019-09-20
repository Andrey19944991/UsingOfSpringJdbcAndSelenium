package util;

import org.openqa.selenium.WebDriver;

public class CloseWindow {
    public void closeWin(WebDriver driver){
        driver.close();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }
}
