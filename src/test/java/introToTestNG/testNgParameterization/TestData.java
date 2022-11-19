package introToTestNG.testNgParameterization;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "Customer Info")
    public Object[][] getData(){
        return new Object[][]{
                {"David","Johnson",1234},
                {"Sarah","Johnson",2524},
                {"John","Doe",3452}
        };
    }
}
