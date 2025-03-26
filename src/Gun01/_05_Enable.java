package Gun01;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _05_Enable {

    @Test
    public void Test1()
    {
        System.out.println("Test 1");
        driver.get("https://www.facebook.com/");
    }

    @Test(enabled = false)  // bu test şimdilik çalışmayacak devre dışı, ignore yapıldı
    public void Test2()
    {
        System.out.println("Test 2");
    }

    @Test
    public void Test3()
    {
        System.out.println("Test 3");
        driver.get("https://www.google.com/");
    }

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
    }

    @AfterClass
    public void TearDown()
    {
        // seleniumdaki BekleKapat
        MyFunc.Bekle(3);
        driver.quit();  // bütün açılmış windowları kapatır
    }

}
