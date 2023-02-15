import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class RobotParamTest {
    private String expected;
    private int age;

    @ParameterizedTest
    @CsvSource({"10 , Age ok","20,Age ok", "25,Too old"})//@csvsource can help seperate using ,
    void testcheckageAll(int age, String expected){
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestFile.csv", numLinesToSkip = 1)
    void testcheckageAll2(int age, String expected){
        Robot buddy = new Robot("buddy" , age);
        assertEquals(expected, buddy.checkage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "ParamCheckCost.csv", numLinesToSkip = 1)
    void testcheckcostAll(int age, double expected){
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkCost());
    }











}