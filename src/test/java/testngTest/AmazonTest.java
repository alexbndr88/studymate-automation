package testngTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AmazonTest {

    @BeforeSuite
    public static void before() {
        System.out.println(" before suite");
    }
   @Test
   public void amazonTest1(){
        System.out.println("test 1 amazon");
    }
    @Test
    public void amazonTest2(){
        System.out.println("test 2 amazon");
    }

    @Test
    public void amazonTest3(){
        System.out.println("test 3 amazon");
    }
}
