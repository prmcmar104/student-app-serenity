package com.studentapp.studentinfo;

import com.studentapp.constants.EndPoints;
import com.studentapp.testbase.TestBase;
import net.serenitybdd.annotations.Manual;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Jay
 */
//@RunWith(SerenityRunner.class)
public class FirstSerenityTest extends TestBase {

    @Test
    public void getAllStudents(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void thisIsFailingTest() {
        SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_STUDENT)
                .then().log().all().statusCode(201);
    }

    @Ignore
    @Test
    public void thisIsASkipped(){

    }

    @Manual
    @Test
    public void thisIsManualTest(){

    }

    @Test
    public void thisIsATestWithError(){
        System.out.println("This is an Error " + (5/0));
    }

    @Test
    public void thisIsCompromised() throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }

    @Title("This test will get the information of all students")
    @Test
    public void test001() {
        SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_STUDENT)
                .then().log().all().statusCode(200);
    }

}
