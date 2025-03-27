package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Assertions {

    @Test
    public void equalsOrnek(){
        String s1="Merhaba";
        String s2="Merhaba1";

        // AEM   OBA
        // Actual(oluşan), Expected(Beklenen), Hata Açıklama Mesajı
        Assert.assertEquals(s1,s2,"Oluşan la beklenen aynı değil");
    }

    @Test
    public void NotEqualsOrnek(){
        String s1="Merhaba";
        String s2="Merhaba";

        Assert.assertNotEquals(s1,s2,"Oluşan la beklenen eşit");
    }

    @Test
    public void TrueOrnek(){
        String s1="Merhaba";
        String s2="Merhaba";

        Assert.assertTrue(s1.equals(s2),"Oluşan la beklenen aynı değil");
    }

    @Test
    public void TrueOrnek2(){
        int s1=5;
        int s2=5;

        Assert.assertTrue(s1==s2,"Oluşan la beklenen aynı değil");
    }

    @Test
    public void NullOrnek(){
        String s1=null;

        Assert.assertNull(s1,"beklenen değer null değil");
    }

    @Test
    public void FalseOrnek(){
        int s1=5;
        int s2=5;

        Assert.assertFalse(s1==s2,"Oluşan la beklenen eşit");
    }

    @Test
    public void DirectFail(){
        int a=56;

        if (a > 10)
            Assert.fail();    //Assert.assertTrue(a<=10,"a 10 dan büyük");
    }




}
