package Gun06;

/*
    Senaryo ;
    1- Siteye gidiniz..
    2- "ipod" ürününü aratınız.
    3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
    4- Daha sonra WishList e tıklatınız
    5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
    (POM olmadan çözünüz)
 */

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends BaseDriver {

    @Test
    public void addToWishList() {

        WebElement searchBox=driver.findElement(By.name("search"));
        searchBox.sendKeys("ipod"+ Keys.ENTER);

        List<WebElement> productNameList=driver.findElements(By.xpath("//div[@class='caption'] / h4"));

        int rndSayi= MyFunc.RandomSayiVer(productNameList.size()); // 0,1,2,3 -> 4 e kadar
        String  selectedProductName=productNameList.get(rndSayi).getText();

        List<WebElement> wishButtons=driver.findElements(By.xpath("//*[@data-original-title='Add to Wish List']"));
        wishButtons.get(rndSayi).click();

        WebElement wishListLink=driver.findElement(By.xpath("//a[@id='wishlist-total']"));
        wishListLink.click();

        // Wish List ekranda , ekrandaki ürünlerin listesini alalım
        List<WebElement> wishNameList=driver.findElements(By.cssSelector("[class='text-left'] a"));

        boolean bulundu=false;

        for(WebElement e: wishNameList)
            if (e.getText().equals(selectedProductName))
               bulundu=true;

        Assert.assertTrue(bulundu, "WishListe eklenen ürün listede bulunamadı");

    }



}








