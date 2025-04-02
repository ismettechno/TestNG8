package Gun05;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _02_SoftAssertVsHardAssert {


    @Test
    public void HardAssert() {
        String s1 = "Merhaba";

        System.out.println("Assert öncesi");
        Assert.assertEquals("Merhaba123", s1, "Beklenen ile oluşan aynı değil");
        System.out.println("Assert sonrası");
    }

    @Test
    public void SoftAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage);  // hata yok
        System.out.println("Soft Assert 1");

        _softAssert.assertEquals("www.facebook.com/profile", strCartPage, "EA aynı değil");  // hata var
        System.out.println("Soft Assert 2");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount,"EA aynı değil"); // hata var
        System.out.println("Soft Assert 3");

        //ben hataları işleme koy deyince , bu noktada hataları aktif etsin, arada kesilmesin
        _softAssert.assertAll(); // hataları işleme koy, yani var ise göster
        System.out.println("soft AssertAll: aktiflik sonrası"); // acaba işlem sonrası yacak mı
    }


}
