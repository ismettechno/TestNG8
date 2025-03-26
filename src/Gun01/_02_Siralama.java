package Gun01;

import org.testng.annotations.Test;

public class _02_Siralama {

    @Test(priority = 1)
    public void DriverIslemleriniYap(){
        System.out.println("Driver Başlat çalıştı");
    }

    @Test(priority = 2)
    public void WebsitesiniAc(){
        System.out.println("WebsitesiniAc çalıştı");
    }

    @Test(priority = 3)
    public void LoginTestiniYap(){
        System.out.println("LoginTestiniYap çalıştı");
    }

    @Test(priority = 4)
    public void DriverKapat(){
        System.out.println("Driver Kapat çalıştı");
    }

}
