package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParseCost {

    public String parse(WebDriver driver, String address){
        char[] priceAndCurr = driver.findElement(By.xpath(address)).getText().replaceAll("\\s+", "")
                .toCharArray();
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : priceAndCurr) {
            if (!Character.isDigit(c)) {
                break;
            }
            sb.insert(pos,c);
            pos++;
        }
        return sb.toString();
    }

    public String parseOnClassName(WebDriver driver, String name){
        char[] priceAndCurr = driver.findElement(By.className(name)).getText().replaceAll("\\s+", "")
                .toCharArray();
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : priceAndCurr) {
            if (!Character.isDigit(c)) {
                break;
            }
            sb.insert(pos,c);
            pos++;
        }
        return sb.toString();
    }



}
