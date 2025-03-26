package Gun01;

import Utility.BaseDriver;
import org.testng.annotations.Test;

public class _05_Enable_2 extends BaseDriver {

    @Test
    public void Test1()
    {
        System.out.println("Test 1");
        driver.get("https://www.facebook.com/");
    }

    @Test(enabled = false)  // bu test şimdilik çalışmayacak devre dışı, ignore yapıldı
    public void Test2()
    {
        System.out.println("Test 2");
    }

    @Test
    public void Test3()
    {
        System.out.println("Test 3");
        driver.get("https://www.google.com/");
    }

}
