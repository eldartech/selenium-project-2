package introToTestNG.testNgParameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Param {
    @Parameters({"star1","star2","star3"})
    @Test
    void test(String param1,String param2,String param3){
        System.out.println("first param: "+param1);
        System.out.println("Second param:"+param2);
        System.out.println("Third param: "+param3);
    }
}

/*
1. parameter tag in xml file in test level or suite level
    A. provide name attribute
    B. provide value attribute
2. in test class provide @Parameters
    A. provide the name of the parameter form xml file in @Parameters annotation's parameter as argument
    B in test method provide variable(s) for parameter(s)



 */
