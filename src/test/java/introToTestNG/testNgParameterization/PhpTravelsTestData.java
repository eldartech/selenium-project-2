package introToTestNG.testNgParameterization;

import org.testng.annotations.DataProvider;

public class PhpTravelsTestData {

    @DataProvider(name = "credentials")
    public Object[][] getCreds(){
        return new Object[][]{
                {"user@phptravels.com","demouser"},
                {"agent@phptravels.com","demoagent"},
                {"admin@phptravels.com","demoadmin"},
                {"supplier@phptravels.com","demosupplier"}
        };
    }
}
