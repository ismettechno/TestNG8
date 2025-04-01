package Gun03;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra url deki success yazısını doğrulayınız.
 */


import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// Buradaki test parametre beklediğindne SADECE XML den çalıştırılabilir
public class _05_ContactUsParameterPD extends BaseDriverParameter {

//    @Parameters({"mesaj","mesaj2"})// xml deki parametre adı aynı olmak zorunda
//    void contactUs(String gelenMesaj,String m2){

    @Test
    @Parameters("mesaj") // xml de ki ile name ile aynı olmalı
    public void contactUs(String gelenMesaj){
        WebElement contactUsBtn=driver.findElement(By.linkText("Contact Us"));
        contactUsBtn.click();

        WebElement enquiryArea=driver.findElement(By.id("input-enquiry"));
        enquiryArea.sendKeys(gelenMesaj);
        MyFunc.Bekle(2);

        WebElement submitBtn=driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();

        System.out.println("önce url="+driver.getCurrentUrl());
        wait.until(ExpectedConditions.urlContains("success")); // wait kullanmasını biliyoruz
        System.out.println("sonra url="+driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }

}
