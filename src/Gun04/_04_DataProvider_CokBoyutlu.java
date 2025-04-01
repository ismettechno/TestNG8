package Gun04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _04_DataProvider_CokBoyutlu {

    @Test(dataProvider = "datalarim")
    public void LoginTest(String username, String password)
    {
        System.out.println(username+" "+password);
    }

    @DataProvider
    Object[][] datalarim()
    {
        Object[][] datalar={
                {"ismet","1234" },
                {"mehmet","5678" },
                {"İbrahim","44444" },
                {"Rıfat","5555" },
        };

        return datalar;
    }


}
