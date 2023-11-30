package tests.day014_testNGFramework;

import org.testng.annotations.Test;

public class C01_TestNG_priority {
        /*
        TestNG test method'larini isim sirasina gore calistirir
        priority degeri verilen method'lar priority degeri kucukten buyuge dogru calisir
        esit olan priority degerlerinde harf sirasina gore calisir
        eger priority degeri yazmazsak priority=0 kabul edilir
     */

    @Test (priority = 3)
    public void ilktest() {

        System.out.println("birinci test calisti");
    }


    @Test (priority = 4)
    public void ikincitest() {

        System.out.println("ikinci test calisti");
    }


    @Test(priority = 1)
    public void ucuncutest() {

        System.out.println("ucuncu test calisti");
    }
}
