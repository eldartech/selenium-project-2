package introToTestNG.testNgParameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name = "dp-name")
    public Object[][] dpMethod(){
        return new Object[][]{
                {"First Value"},
                {"Second Value"},
                {"Third Value"}
        };
    }

    @Test(dataProvider = "dp-name")
    void test1(String value){
        System.out.println("Passed Parameter is: "+value);
    }

    @Test(dataProvider = "Customer Info",dataProviderClass = TestData.class)
    void test2(String name,String lastName,int id){
        System.out.println("Name: "+name);
        System.out.println("LastName: "+lastName);
        System.out.println("ID: "+id);
    }
}
/*
1. Create @DataProvider and provide a name attribute
         A. create a public method, which will return Object[][]
         B. return new Object[][]{{data1},{data2}}
2. In order to pass test data from data provider, you  have to specify the dataProvider attribute in @Test annotation
    Note: in case if your DataProvider is located in different class, you will have to also specify the dataProviderClass
    attribute
    A. Create variables in test method parameter depending on how many values are passed in inner array of Data Provider
 */

















