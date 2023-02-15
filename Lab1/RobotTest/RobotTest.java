import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    Robot buddy = new Robot("buddy", 5);

    @Test
    public void getName(){
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void isNotWorking(){
        assertFalse(buddy.isWorking());
    }

    @Test
    public void isWorking(){
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void getWorkingMsg() {
        buddy.talkToRobot();
        assertEquals("I am in working mode",buddy.getWorkingMsg());
    }


    //is a fail test Example
    @Test
    @DisplayName("getWorkingMsg Fail catch the Exception")
    public void getWorkingMsgFail() {
        assertThrows(IllegalStateException.class, () -> {
            buddy.getWorkingMsg();
        });

    }


//    @Test
//    public void testName_Fail() {
//        assertThrows(IllegalArgumentException.class, () -> new Robot(""));
//    }


    @Test
    public void waitTillWorking() throws InterruptedException {
        buddy.waitTillWorking();
    }

    @Test
    void timeoutExceeded() throws InterruptedException {
        assertTimeout(ofMillis(10), () -> {
            buddy.waitTillWorking();
        });
    }
}