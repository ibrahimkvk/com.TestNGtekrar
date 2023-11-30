package tests.day014_testNGFramework;

import org.testng.annotations.Test;

public class C02_DependOnMethods {

    @Test(dependsOnMethods = "ucuncutest")
    public void ilktest() {

        System.out.println("birinci test calisti");
    }

    @Test (dependsOnMethods ="ilktest")
    public void ikincitest() {

        System.out.println("ikinci test calisti");
    }


    @Test
    public void ucuncutest() {

        System.out.println("ucuncu test calisti");
    }
}
