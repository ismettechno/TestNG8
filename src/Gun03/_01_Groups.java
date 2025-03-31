package Gun03;

import org.testng.annotations.*;

public class _01_Groups {
    //@Test(groups = { "group1", "group2" })  çoklu group

    @Test(groups={"Smoke Test"})
    public void Test1() { System.out.println("test1"); }

    @Test(groups = {"Regression"})
    public void Test3() { System.out.println("test3"); }

    @Test(groups = {"Regression"})
    public void Test5() { System.out.println("test5"); }

    @Test(groups = {"Regression"})
    public void Test2() { System.out.println("test2"); }

    @Test(groups={"Smoke Test"})
    public void Test4() { System.out.println("test4"); }

    @Test(groups={"Smoke Test"})
    public void Test6() { System.out.println("test6"); }

    @Test
    public void Test7() { System.out.println("test7"); }

    @BeforeGroups(groups={"Smoke Test", "Regression" })
    public void bGroups() { System.out.println("Before Groups"); }

    @AfterGroups(groups={"Smoke Test", "Regression" })
    public void aGroups() { System.out.println("After Groups"); }

}
