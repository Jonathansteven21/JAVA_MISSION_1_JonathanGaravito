package grades_management;

import org.junit.Before;
import grades_management.services.ClassroomService;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


public class ClassroomServiceTest {
    private static ClassroomService classroomService;

    @Before
    public void setUpClass() {
        classroomService = new ClassroomService();
        classroomService.createClassroom(4);
        classroomService.addStudent(0, "STD01", 94, 91, 86, 79);
        classroomService.addStudent(1, "STD02", 67, 81, 79, 59);
        classroomService.addStudent(2, "STD03", 87, 79, 85, 88);
        classroomService.addStudent(3, "STD04", 90, 93, 75, 89);
        classroomService.sortList();
        classroomService.calculateSubjectAvg();
    }

    @Test
    public void testJavaAvgScore() {
        System.out.println("Test: verify getJavaAvgScore");
        assertEquals(84.50, classroomService.getClassroom().getJavaAvgScore(), 0.009);
    }

    @Test
    public void testSqlAvgScore() {
        System.out.println("Test: verify getSqlAvgScore");
        assertEquals(86.00, classroomService.getClassroom().getSqlAvgScore(), 0.009);
    }

    @Test
    public void testMathAvgScore() {
        System.out.println("Test: verify getMathAvgScore");
        assertEquals(81.25, classroomService.getClassroom().getMathAvgScore(), 0.009);
    }

    @Test
    public void testEnglishAvgScore() {
        System.out.println("Test: verify getEnglishAvgScore");
        assertEquals(78.75, classroomService.getClassroom().getEnglishAvgScore(), 0.009);
    }

    @Test
    public void testStudentListSort() {
        System.out.println("Test: verify getStudentsList");
        String[] namesResult = new String[4];
        for (int i = 0; i < 4; i++) {
            namesResult[i] = classroomService.getClassroom().getStudentsList()[i].getName();
        }
        String[] namesExpected = {"STD01","STD04","STD03","STD02"};

        assertArrayEquals(namesExpected, namesResult);
    }
}
