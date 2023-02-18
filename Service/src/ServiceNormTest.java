import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceNormTest {

    @Test
    void getStuffWithLengthLessThanFive() {

        Repository repository = new Repository();
        Service service = new Service(repository);


        List<String> stuff = service.getStuffWithLengthLessThanFive();


        // Validate the response
        Assertions.assertNotNull(stuff);
        Assertions.assertEquals(2, stuff.size());

    }




}