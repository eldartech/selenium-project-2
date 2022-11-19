package introToTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGPriority {
    @Test(priority = 3)
    void test1(){
        System.out.println("test 1");
    }

    @Test(priority = 1)
    void test3(){
        System.out.println("test 3");
    }

    @Test(priority = 2)
    void test4(){
        System.out.println("test 4");
        Assert.assertEquals(1,3);
        Assert.assertEquals(1,1);
        Assert.assertTrue("Java".contains("J"));
        Assert.assertEquals("Java","Java");
    }

    @Test(priority = 2)
    void test5(){
        System.out.println("test 5");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("java","Java");
        softAssert.assertTrue(10==11);
        softAssert.assertTrue("Python".startsWith("p"));
        softAssert.assertAll();

    }

    @Test
    void test2(){
        System.out.println("test 2");
    }

}
