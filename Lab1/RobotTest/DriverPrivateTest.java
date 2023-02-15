import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class DriverPrivateTest {
    //setDriverNum
    @Test
    public void testsetdriverNumMethod() throws Exception{
        System.out.println("setDriverNum");
        Driver target = new Driver("robbie", 10000);
        Method method = Driver.class.getDeclaredMethod("setDriverNum", int.class);
        method.setAccessible(true);
        method.invoke(target, 30000);
        Class secretClass = target.getClass();
        Field f = secretClass.getDeclaredField("driverNum");
        f.setAccessible(true);

        int result = f.getInt(target);
        System.out.println("The value in f(age) is "+ f.get(target));
        assertEquals(30000, result);




    }

}