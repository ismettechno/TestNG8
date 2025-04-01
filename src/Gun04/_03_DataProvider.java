package Gun04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider {

    /**
     * Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "datalarim"  bölümü eklenir.
     * Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
     * XML filer file gruplama, pararalel, ve farklı tesleri koordine edip birarada çalıştırmak için kullanılır.
     */

    @Test(dataProvider = "datalarim")
    public void Search(String gelenKelime)
    {
        System.out.println(gelenKelime);
    }


    @DataProvider  // bu metoda dataprovider görevi verildi.
    Object[] datalarim(){ // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
        Object[] aranacaklar={"mac","samsun", "laptop","mouse"};

        return aranacaklar;
    }

}
