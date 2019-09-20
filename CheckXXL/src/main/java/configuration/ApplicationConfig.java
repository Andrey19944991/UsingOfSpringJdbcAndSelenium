package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import util.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"util"})
public class ApplicationConfig {


    @Bean
    public WebDriver webDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chekov.a.a\\Desktop\\source\\chromedriver.exe");
        ChromeOptions options1 = new ChromeOptions();
        options1.addArguments("--incognito");
        options1.addArguments("--disable-notifications");
        options1.addArguments("disable-infobars");
        return new ChromeDriver(options1);
    }

    @Bean
    public WebDriverWait webDriverWait() {
        return new WebDriverWait(webDriver(),60);
    }

    @Bean
    public MyClick myClick(){
        return new MyClick(webDriverWait());
    }

    @Bean
    public OpenGoogleChrome openGoogleChrome(){
        return new OpenGoogleChrome();
    }

    @Bean
    public GetInTheSite getInTheSite(){
        return  new GetInTheSite(inputLoginAndPasswordInFullVersion());
    }

    @Bean
    public InputLoginAndPasswordInFullVersion inputLoginAndPasswordInFullVersion(){
        return  new InputLoginAndPasswordInFullVersion();
    }

    @Bean
    public ClearningBasketFromTheMainPage clearningBasketFromTheMainPage(){
        return new ClearningBasketFromTheMainPage();
    }


    @Bean
    public ParseCost parseCost(){
        return new ParseCost();
    }

    @Bean
    public BuyProductOnArt buyProductOnArt(){
        return new BuyProductOnArt();
    }

}
