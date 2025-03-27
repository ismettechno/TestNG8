package Gun02;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_SubscribeNewsLetter extends BaseDriver {
    /*
    Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone olunuz(YES)  , işlemin başarılı olduğunu kontrol ediniz.
     */

    @Test
    public void SubscribeFunctionYes()
    {
        WebElement newsLetterLink=driver.findElement(By.linkText("Newsletter"));
        newsLetterLink.click();

        WebElement subscribeYes=driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
        subscribeYes.click();

        WebElement continueButton=driver.findElement(By.xpath("//*[@value='Continue']"));
        continueButton.click();

        WebElement msgLabel=driver.findElement(By.cssSelector("[class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }

}
