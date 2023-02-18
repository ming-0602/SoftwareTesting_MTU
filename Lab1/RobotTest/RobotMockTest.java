import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class RobotMockTest {

    //create mock to create mock for the robotfee class
    @Mock
    RobotFees mockRobotFees;

    //create an instance of the class that will call the mock
    @InjectMocks
    Robot instance = new Robot("robbie", 5);

    @Test
    public void InterfaceTest(){
        System.out.println("getTotalCost");

        //Set up the expected value and return value
        Mockito.when(mockRobotFees.getCost(5)).thenReturn(100.00);
        double expResult = 10100.00;

        double result = instance.getTotalCost(mockRobotFees);

        System.out.println("the result is " + result);
        assertEquals(expResult, result, 0.005);

        //verify that the mock was used correctly
        Mockito.verify(mockRobotFees).getCost(5);
    }
}