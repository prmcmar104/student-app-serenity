package com.studentapp.cucumber.steps;

import com.studentapp.studentinfo.StudentSteps;
import com.studentapp.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay Vaghani
 */
public class MyStepdefs {

    static ValidatableResponse response;

    static String email = null;
    static String firstName = null;
    static String lastName = null;
    static int studentId;

    @Steps
    StudentSteps steps;

    @When("User sends a GET request to list endpoint")
    public void userSendsAGETRequestToListEndpoint() {
        response = steps.getAllStudentInfo();
    }

    @Then("User must get back a valid status code {int}")
    public void userMustGetBackAValidStatusCode(int statusCode) {
        response.statusCode(statusCode);
    }

    @When("I create a new student by providing the information firstName {string} lastName {string} email {string} programme {string} courses {string}")
    public void iCreateANewStudentByProvidingTheInformationFirstNameLastNameEmailProgrammeCourses(String _firstName, String _lastName, String _email, String programme, String courses) {
        List<String> courseList = new ArrayList<>();
        courseList.add(courses);
        firstName = TestUtils.generateFirstName() + _firstName;
        lastName = TestUtils.generateLastName() + _lastName;
        email = TestUtils.generateEmail();
        steps.createStudent(firstName, lastName, email, programme, courseList).statusCode(201);
    }

    @Then("I verify that the student with {string} is created")
    public void iVerifyThatTheStudentWithIsCreated(String _email) {
        HashMap<String, Object> studentMap = steps.getStudentInfoByEmail(email);
        Assert.assertThat(studentMap, hasValue(email));
        studentId = (int) studentMap.get("id");
    }

    @Given("Student application is running")
    public void studentApplicationIsRunning() {
    }

    @And("I update the student with information firstName {string} lastName {string} email {string} programme {string} courses {string}")
    public void iUpdateTheStudentWithInformationFirstNameLastNameEmailProgrammeCourses(String _firstName, String _lastName, String _email, String programme, String courses) {
        List<String> courseList = new ArrayList<>();
        courseList.add(courses);
        firstName = "Updated" + _firstName;
        steps.updateStudent(studentId, firstName, lastName, email, programme, courseList).statusCode(200);
    }

    @Then("The student with firstName {string} is updated successfully")
    public void theStudentWithFirstNameIsUpdatedSuccessfully(String _firstName) {
        HashMap<String, Object> studentMap = steps.getStudentInfoByFirstName(firstName);
        Assert.assertThat(studentMap, hasValue(firstName));
    }

    @And("I delete the student that created with firstName {string}")
    public void iDeleteTheStudentThatCreatedWithFirstName(String _firstName) {
        steps.deleteStudent(studentId).statusCode(204);
    }

    @Then("The student deleted successfully from the application")
    public void theStudentDeletedSuccessfullyFromTheApplication() {
        steps.getStudentById(studentId).statusCode(404);
    }
}
