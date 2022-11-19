package introToTestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAnnotations {
    //NOTE: if you have more than one same annotation, they will be running
    //according to their name in ascending order
    @BeforeSuite
    void beforeSuite2(){
        System.out.println("Before Suite Annotation - 2");
    }
        // Suite: is made of one or more test
    @BeforeSuite
    void beforeSuite1(){
        System.out.println("Before Suite Annotation - 1");
    }
    // Test: is made of one or more classes
    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test Annotation");
    }
    @AfterTest
    void afterTest(){
        System.out.println("After Test Annotation");
    }

    @AfterClass
    void afterClass(){
        System.out.println("After Class Annotation");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("Before Class Annotation");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method Annotation");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("After Method Annotation");
    }

    @BeforeGroups("group1")
    void beforeGroup(){
        System.out.println("Before Group 1");
    }

    @AfterGroups("group1")
    void afterGroup(){
        System.out.println("After Group 1");
    }

    @Test(description = "Test 4",dependsOnGroups = "group1")
    void test4(){
        System.out.println("Test Annotation - 4");
        System.out.println("Priority 1");
    }

    @Test(description = "Test 1",groups = "group1")
    void test1(){
        System.out.println("Test Annotation - 1");
        Assert.assertEquals(1,1);
        System.out.println("Priority: 2");
    }

    @Test(description = "Test 3", groups = {"group1"},dependsOnMethods = "test1")
    void test3(){
        System.out.println("Test Annotation - 3");
        Assert.assertEquals(1,1);
    }

    @Test(description = "Test 2", enabled = true /*, expectedExceptions = IOException.class*/, invocationCount = 10)
    void test2(){
        System.out.println(" Test Annotation - 2");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("After Suite Annotation");
    }
}
