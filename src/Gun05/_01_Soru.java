package Gun05;

/*
  Senaryo;
  1- Brands menusune gidiniz.
  2- Burada her bir markanın üstünde yer alan harf ile başladığını doğrulayınız

  WebElement element=driver.findElement(By.id("btn"));// elementi tum sayafada ara

  Webelement altElement=element.findElement(By.classname("new"));  // yukarıdaki alınan elementin içinde
                                                                   // arar

  harfler= [id='content'] > h2
  markalar = [id='content'] > div

*/


import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_Soru extends BaseDriver {

    @Test
    public void BrandsTest()
    {
        WebElement brandsLink=driver.findElement(By.linkText("Brands"));
        brandsLink.click();

        List<WebElement> harfler=driver.findElements(By.cssSelector("[id='content'] > h2"));
        List<WebElement> markalar=driver.findElements(By.cssSelector("[id='content'] > div"));

        for (int i = 0; i < harfler.size(); i++) {
            System.out.println("harfler.get(i).getText() = " + harfler.get(i).getText());

            //marka bloklarındaki div leri alarak markalara tek tek ulaşabildim, list olarak
            List<WebElement> harfinMarkalari= markalar.get(i).findElements(By.tagName("div"));
             
            for (WebElement marka: harfinMarkalari) {
                System.out.println("marka.getText() = " + marka.getText());

                //markalar harfle mi başlıyor
                Assert.assertEquals(harfler.get(i).getText().charAt(0),
                                    marka.getText().charAt(0),
                                    "Marka harfle başlamıyor"
                                    );
            }
        }
    }

// TODO: aynı soruyu  https://www.ebay.com/n/all-brands bu sitesinden test edelim. %100

}
