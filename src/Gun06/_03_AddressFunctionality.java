package Gun06;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
       (POM olmadan çözünüz)
 */

import Utility.BaseDriver;
import Utility.WebTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _03_AddressFunctionality extends BaseDriver {

    @Test
    void AddAddress()
    {
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAddress=driver.findElement(By.linkText("New Address"));
        newAddress.click();

        WebElement firsName=driver.findElement(By.id("input-firstname"));
        firsName.sendKeys("İsmet");

        WebElement lastname=driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Yılmaz");

        WebElement company=driver.findElement(By.id("input-company"));
        company.sendKeys("Techno Study");

        WebElement address1=driver.findElement(By.id("input-address-1"));
        address1.sendKeys("Necip Fazıl Cad.");

        WebElement address2=driver.findElement(By.id("input-address-2"));
        address2.sendKeys("Dilek Taşı Sk.");

        WebElement city=driver.findElement(By.id("input-city"));
        city.sendKeys("Dilek Taşı Sk.");

        WebElement postCode=driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("12345");

        WebElement webCountry=driver.findElement(By.id("input-country"));
        Select country=new Select(webCountry);
        country.selectByVisibleText("Turkey");

        wait.until(ExpectedConditions.elementToBeClickable(webCountry));

        // Olay yeri inceleme
        WebElement webState=driver.findElement(By.id("input-zone"));
        Select state=new Select(webState);
        //state.selectByVisibleText("Ankara"); // implicitly wait ile sorunsuz çalışır ve expilicit beklemeye ihtiyacı olmaz
        //state.selectByValue("3321"); // implicitly wait ile sorunsuz çalışır ve expilicit beklemeye ihtiyacı olmaz
        state.selectByIndex(7); //implicitly wait ile ortak çalışMIYOR. explicit wait e ihtiyaç duyar


        WebElement continuee= driver.findElement(By.xpath("//input[@type='submit']"));
        continuee.click();

        WebTool.SuccessMessageValidation();
    }

    @Test(dependsOnMethods = {"AddAddress"} )
    void EditAddress()
    {
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        // sonuncu adrese tıklat
        List<WebElement> editAll=driver.findElements(By.linkText("Edit"));
        WebElement sonEdit= editAll.get( editAll.size()-1 );
        sonEdit.click();

        WebElement firsName=driver.findElement(By.id("input-firstname"));
        firsName.sendKeys("İsmet 1");

        WebElement lastname=driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Yılmaz 1");

        WebElement continuee= driver.findElement(By.xpath("//input[@type='submit']"));
        continuee.click();

        WebTool.SuccessMessageValidation();
    }

    @Test(dependsOnMethods = {"EditAddress"})
    void DeleteAddress()
    {
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        // sonuncu adrese tıklat
        List<WebElement> deleteAll=driver.findElements(By.linkText("Delete"));
        WebElement sonDelete= deleteAll.get( deleteAll.size()-1 );
        sonDelete.click();
    }

    // TODO : Yukarıdaki soruyu POM ile çözünüz.
}
