package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay
 */
/*@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/resources/testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)*/
public class CreateStudentDataDrivenTest extends TestBase {

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String course1;
    private String course2;

    @Steps
    StudentSteps studentSteps;

    @Title("Data driven test for adding multiple students to the application")
    @Test
    public void createMultipleStudents(){
        List<String> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        studentSteps.createStudent(firstName, lastName, email, programme, courseList).statusCode(201);
    }

}
