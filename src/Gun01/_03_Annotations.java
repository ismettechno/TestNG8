package Gun01;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class _03_Annotations {

    @Test
    public void Test1(){
        System.out.println("test 1 çalıştı");
    }

    @Test
    public void Test2(){
        System.out.println("test 2 çalıştı");
    }

    @BeforeClass
    public void onceCalistirilacaklar(){ System.out.println("Driver start ve bütün başlangıç işlemleri çalıştır");}

    @AfterClass
    public void testbitinceCalisakalar(){ System.out.println("test bitince calışması gerekenler çalıştı");}

}
