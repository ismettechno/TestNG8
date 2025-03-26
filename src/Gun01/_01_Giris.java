package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {

//   public static void main(String[] args) {
//        driverIslemleriniYap();
//        websitesiniAc();
//        LoginTestiniYap()
//        DriverKapat();
//   }

//      @Test JUnit Test i
//      public void Test1()
//      {
//          driverIslemleriniYap();
//          websitesiniAc();
//          LoginTestiniYap()
//          Assert test test
//          DriverKapat();
//      }
    // alafabetik sırada çalıştı

    @Test
    public void DriverIslemleriniYap(){
        System.out.println("Driver Başlat çalıştı");
    }

    @Test
    public void WebsitesiniAc(){
        System.out.println("WebsitesiniAc çalıştı");
    }

    @Test
    public void LoginTestiniYap(){
        System.out.println("LoginTestiniYap çalıştı");
    }

    @Test
    public void DriverKapat(){
        System.out.println("Driver Kapat çalıştı");
    }


}
