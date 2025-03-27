package Gun02;

import Utility.BaseDriver;
import Utility.WebTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _05_EditAccount extends BaseDriver {

    /*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */

    @Test
    public void EditAccount(){
        WebElement editLink=driver.findElement(By.linkText("Edit Account"));
        editLink.click();

        WebElement txtFirstName=driver.findElement(By.id("input-firstname"));
        txtFirstName.clear();
        txtFirstName.sendKeys("ismet 3");

        WebElement txtLastName=driver.findElement(By.id("input-lastname"));
        txtLastName.clear();
        txtLastName.sendKeys("temur 3");

        WebElement btnSubmit=driver.findElement(By.cssSelector("[value='Continue']"));
        btnSubmit.click();

        WebTool.SuccessMessageValidation();
    }



}
