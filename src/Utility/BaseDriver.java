package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseDriver {

    // aşağısını SDET8 den aldık
    public static WebDriver driver;

    @BeforeClass
    public void Setup()
    {
        // seleniumdaki static yani başlangıç kısımlar konacak
        driver=new ChromeDriver();

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti

        LoginTest();
    }


    public void LoginTest()
    {
        System.out.println("Login Test başladı");
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        MyFunc.Bekle(2);

        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("testng1@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("123qweasd");

        WebElement loginBtn=driver.findElement(By.xpath("//*[@value='Login']"));
        loginBtn.click();

        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        Assert.assertTrue(driver.getTitle().equals("My Account"), "Login olunamadı");

        System.out.println("Login Test bitti");
    }


    @AfterClass
    public void TearDown()
    {
        // seleniumdaki BekleKapat
        MyFunc.Bekle(3);
        driver.quit();  // bütün açılmış windowları kapatır
    }


}
