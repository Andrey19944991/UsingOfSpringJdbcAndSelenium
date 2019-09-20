package spring;

import configuration.ApplicationConfig;
import configuration.DbConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import util.*;
import java.sql.*;



@SpringBootApplication
public class CheckPartOfXXLBonus {

    public static final String numTel="9533509710";

    public static void main(String[] args) throws InterruptedException, SQLException {

        SpringApplication.run(CheckPartOfXXLBonus.class);

        String art="9413"; //бумага
        String countBonus="42"; // СКОЛЬКО ПОТРАТИТЬСЯ

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //Создадим необходимые бины
        WebDriver driver1 = context.getBean("webDriver", ChromeDriver.class);
        WebDriverWait webDriverWait=context.getBean("webDriverWait",WebDriverWait.class);
        MyClick myClick = context.getBean("myClick", MyClick.class);
        OpenGoogleChrome openGoogleChrome = context.getBean("openGoogleChrome",OpenGoogleChrome.class);
        GetInTheSite getInTheSite = context.getBean("getInTheSite", GetInTheSite.class);
        InputLoginAndPasswordInFullVersion inputLoginAndPasswordInFullVersion = context.getBean(
                "inputLoginAndPasswordInFullVersion", InputLoginAndPasswordInFullVersion.class);
        ClearningBasketFromTheMainPage clearningBasketFromTheMainPage = context.getBean(
                "clearningBasketFromTheMainPage",ClearningBasketFromTheMainPage.class);
        ParseCost parseCost = context.getBean("parseCost",ParseCost.class);
        BuyProductOnArt buyProductOnArt = context.getBean("buyProductOnArt", BuyProductOnArt.class);
        Actions actions = new Actions(driver1);

        ApplicationContext context1 = new AnnotationConfigApplicationContext(DbConfig.class);

        JdbcTemplate jdbcTemplate = context1.getBean("jdbcTemplate",JdbcTemplate.class);

        //Необходимые бины выше мы создали

        //Откроем гугл хром

        openGoogleChrome.openFullVersion(driver1);

        myClick.clickOnXPath(driver1,"//*[@id=\"load-cities\"]");

        myClick.clickOnXPath(driver1,"//*[@id=\"primary-subjects\"]/li[4]/a");//СПб и ЛО

        myClick.clickOnXPath(driver1,"//*[@id=\"subj-cities-18413\"]/li[1]/a");//СПБ

        getInTheSite.getIn(driver1,numTel);

        clearningBasketFromTheMainPage.cleanBasket(driver1,myClick);

        myClick.clickOnXPath(driver1,"/html/body/div[1]/div/header/nav[1]/div/ul[2]/li[3]/span");//личный кабинет

        String initialBonus=driver1.findElement(By.xpath("/html/body/div[1]/div/header/nav[1]/div/ul[2]/" +
                "li[3]/ul/li[1]/div/div/div[2]/ul/li[2]/div/span/span[1]")).getText();

        System.out.println("initial count of bonuses = "+initialBonus);

        buyProductOnArt.buyProd(driver1,art);

        while (driver1.findElements(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/div[4]/div/div/div[2]/" +
                "div[2]/span[2]")).isEmpty()){}
        Thread.sleep(1500);
        String mainCost=parseCost.parse(driver1,"/html/body/div[1]/div/div/div/section/div[1]/div[4]/div/" +
                "div/div[2]/div[2]/span[2]");

        System.out.println("mainCost = "+mainCost);

        while (driver1.findElements(By.xpath("/html/body/div[1]/div/div/div/section/div[1]/div[4]/div/div/" +
                "div[2]/a[1]")).isEmpty()){}

        JavascriptExecutor executor1 = (JavascriptExecutor)driver1;
        executor1.executeScript("arguments[0].click();", driver1.findElement(By.xpath("/html/body/div[1]/div/div/" +
                "div/section/div[1]/div[4]/div/div/div[2]/a[1]")));

        //оформить заказ

        while (driver1.findElements(By.xpath("//*[@id=\"contractor28249528\"]")).isEmpty()){}//Тестовой акк

        driver1.findElement(By.xpath("//*[@id=\"contractor28249528\"]")).click();//Тестовой акк

        myClick.clickOnXPath(driver1,"/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[1]/main/div[2]/div/div/" +
                "div[1]/div[2]/div/div[1]/div[4]/div[1]");

        while (driver1.findElements(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[1]/" +
                "main/div[2]/div/div/div[2]/div[6]/div/div/div/div/div/ul/li[2]/div[1]/div[1]/div[1]/div")).isEmpty()){}

        driver1.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[1]/" +
                "main/div[2]/div/div/div[2]/div[6]/div/div/div/div/div/ul/li[2]/div[1]/div[1]/div[1]/div")).click();


        while (driver1.findElements(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/aside/div/" +
                "div[4]/div/div/div[2]/div/a/span")).isEmpty()){}
        driver1.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/aside/div/" +
                "div[4]/div/div/div[2]/div/a/span")).click(); //Заберу отсюда

        while (driver1.findElements(By.xpath("//*[contains(@placeholder,'Количество бонусов')]")).isEmpty()){}

        driver1.findElement(By.xpath("//*[contains(@placeholder,'Количество бонусов')]")).sendKeys(countBonus);

        myClick.clickOnXPath(driver1,"/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/aside/div/div[4]/div[2]/" +
                "div/div[2]/button");//применить

        Thread.sleep(2000);
        String code = jdbcTemplate.queryForObject("select code from user_phone_verification where phone="+numTel,
                String.class);


        Thread.sleep(10000);


        driver1.findElement(By.xpath("//*[contains(@placeholder,'Введите код из SMS')]")).sendKeys(code);

        myClick.clickOnXPath(driver1,"/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/aside/div/div[4]/div[3]/" +
                "div/div[2]/button");//применить


        while (driver1.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/aside/" +
                "div/div[6]/div[2]")).getText().contains(mainCost)){}

        myClick.clickOnXPath(driver1,"/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div[2]/aside/div/div[8]/button");


        myClick.clickOnXPath(driver1,"/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div/main/" +
                "div[2]/div/div/div/div[1]/div[2]/a/div");//оплачу при получении

        String newCost=parseCost.parse(driver1,"/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[1]/aside/" +
                "div/div[4]/div[2]");

        System.out.println("new cost = "+newCost);

        if(Integer.parseInt(mainCost)>Integer.parseInt(newCost)){
            System.out.println("Бонусы списались");
        }
        else {
            System.out.println("Бонусы не списались");
        }


        myClick.clickOnXPath(driver1,"/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div/main/" +
                "div[3]/div/div/div[4]/div/div/button");

        while (driver1.findElements(By.xpath("//*[@id=\"order_id\"]")).isEmpty()){}

        String order=driver1.findElement(By.xpath("//*[@id=\"order_id\"]")).getText().substring(8);

        myClick.clickOnXPath(driver1,"/html/body/div[1]/div/header/nav[1]/div/ul[2]/li[3]/span");//лич каб

        while (driver1.findElements(By.xpath("/html/body/div[1]/div/header/nav[1]/div/ul[2]/li[3]/ul/li[1]/div/" +
                "div/div[2]/ul/li[2]/div/span/span[1]")).isEmpty()){}

        String nextBonus=parseCost.parse(driver1,"/html/body/div[1]/div/header/nav[1]/" +
                "div/ul[2]/li[3]/ul/li[1]/div/div/div[2]/ul/li[2]/div/span/span[1]");

        if(Integer.parseInt(nextBonus)==(Integer.parseInt(initialBonus)-Integer.parseInt(countBonus))){
            System.out.println("Бонусы списались из личного кабинета");
        }
        else {
            System.out.println("Бонусы из личного кабинета не списались");
        }

        myClick.clickOnXPath(driver1,"/html/body/div[1]/div/header/nav[1]/div/ul[2]/li[3]/ul/li[2]/a");//заказы

        myClick.clickOnXPath(driver1,"//*[@id=\"order_"+order+"\"]/div/div/a");

        while (driver1.findElements(By.xpath("//*[@id=\"cancelOrderDetail\"]")).isEmpty()){}

        JavascriptExecutor executor2 = (JavascriptExecutor)driver1;
        executor1.executeScript("arguments[0].click();", driver1.findElement(By.xpath("//*[@id=\"cancelOrderDetail\"]")));

        myClick.clickOnXPath(driver1,"//*[@id=\"form_yes-no\"]/div[3]/div/button[1]");

        while (!driver1.getPageSource().contains(order)){}

        if(driver1.getPageSource().contains(order)){
            System.out.println("Заказ удален");
        }
        else
            System.out.println("Заказ не удален");

        myClick.clickOnXPath(driver1,"/html/body/div[1]/div/header/nav[1]/div/ul[2]/li[3]/span");
        Thread.sleep(2000);
        while (!driver1.findElement(By.xpath("/html/body/div[1]/div/header/nav[1]/div/ul[2]/li[3]/ul/" +
                "li[1]/div/div/div[2]/ul/li[2]/div/span/span[1]")).getText().equals(initialBonus)){
            driver1.navigate().refresh();
            myClick.clickOnXPath(driver1,"/html/body/div[1]/div/header/nav[1]/div/ul[2]/li[3]/span");
        }

        System.out.println("Бонусы вернулись");

        driver1.close();
        driver1.quit();


    }
}
