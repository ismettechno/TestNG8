package Gun06;

/*
    Senaryo ;
    1- Siteye gidiniz..
    2- "ipod" ürününü aratınız.
    3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
    4- Daha sonra WishList e tıklatınız
    5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
    (POM ile çözünüz)
 */


import Gun05._04_PlaceOrder_Elementleri;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishList_POM extends BaseDriver {

    @Test
    public void addToWishList() {

        _04_PlaceOrder_Elementleri poe=new _04_PlaceOrder_Elementleri();
        _02_WishList_Elements wle=new _02_WishList_Elements();


        poe.searchBox.sendKeys("ipod"+ Keys.ENTER);

        int rndSayi= MyFunc.RandomSayiVer(wle.productNameList.size());
        String  selectedProductName=wle.productNameList.get(rndSayi).getText();

        wle.wishButtons.get(rndSayi).click();
        wle.wishListLink.click();

        boolean bulundu=false;

        for(WebElement e: wle.wishNameList)
            if (e.getText().equals(selectedProductName))
                bulundu=true;

        Assert.assertTrue(bulundu, "WishListe eklenen ürün listede bulunamadı");

    }



}
