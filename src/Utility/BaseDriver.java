package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriver {
    public static Logger LogTutma= LogManager.getLogger(); // Logları ekleyeceğim nesneyi başlattım.

    // aşağısını SDET8 den aldık
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void Setup()
    {
        LogTutma.info("Log Tutma işlemi başladı");
        // seleniumdaki static yani başlangıç kısımlar konacak
        driver=new ChromeDriver();

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti

        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        LogTutma.info("Başlangıç değişkenleri driver,wait,log tanımlandı ve başlatıldı");
        LoginTest();
    }

    public void LoginTest()
    {
        System.out.println("Login Test başladı");
        LogTutma.info("Login Test başladı");
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
        LogTutma.info("Login Testi tamamlandı");
    }


    @AfterClass
    public void TearDown()
    {
        // seleniumdaki BekleKapat
        MyFunc.Bekle(3);
        driver.quit();  // bütün açılmış windowları kapatır
        LogTutma.info("Driver kapatıldı");

        //if (hata oldu ise)
        LogTutma.warn("Driver kapatılamadı.");
    }

    @BeforeMethod
    public void BeforeMetod()
    {
        LogTutma.info("Metod başladı");

        LogTutma.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
    }

    @AfterMethod
    public void AfterMetod(ITestResult sonuc) // tesin sonuç ve isim bilgisini olduğu değişkeni
    {
        LogTutma.info(sonuc.getName()+",  Metod Bitti"+" Sonuc="+ (sonuc.getStatus()==1 ? "Passed" : "Failed") );

        LogTutma.warn("WARN : Metod bitti, hata oluşmuş olsa idi bu şekilde eklenebilir.Bir if kontrolü ile");
    }


}
