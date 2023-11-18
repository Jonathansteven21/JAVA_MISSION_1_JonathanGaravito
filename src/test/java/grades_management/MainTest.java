package grades_management;

import org.junit.Test;

import static grades_management.Main.askForStudentsNumber;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

public class MainTest {


    @Test
    public void testAskForStudentsNumber() {
        System.out.println("Test: function AskForStudentsNumber");
        String input = "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = askForStudentsNumber();
        assertEquals(3, result);

    }




}
