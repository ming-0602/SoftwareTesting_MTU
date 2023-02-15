import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class RobotPrivateTest {
    @Test//accesing a private member test age member
    public void testageMember() throws Exception{
        System.out.println("testageMember");
        Robot target = new Robot("robbie", 5);
        Class secretClass = target.getClass();

        //get the field age
        Field f = secretClass.getDeclaredField("age");

        //make it accessible
        f.setAccessible(true);

        System.out.println("The value in f(age) is " + f.get(target));

        int result = f.getInt(target);

        assertEquals(5, result);
    }

    @Test//access a private member test setAge method
    public void testsetAgeMethod() throws Exception{
        System.out.println("setAgeMethod");
        //setup new robot
        Robot target = new Robot("robbie" , 3);

        //get the setAge method details
        Method method = Robot.class.getDeclaredMethod("setAge", int.class);

        //make the method assessible
        method.setAccessible(true);

        //invoke(call) the method setage with value 7
        method.invoke(target, 7);

        //access the field age and check its value is set to 7
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("age");

        f.setAccessible(true);

        int result = f.getInt(target);
        System.out.println("The value in f(age) is "+ f.get(target));
        assertEquals(7, result);

    }
}