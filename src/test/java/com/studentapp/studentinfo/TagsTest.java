package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.annotations.WithTags;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {

    @WithTag("studentfeature:NEGATIVE")
    @Title("Provide a 405 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod(){
        SerenityRest.given()
                .when()
                .post("/list")
                .then()
                .statusCode(405)
                .log().all();
    }

    @WithTags({
            @WithTag("studentfeature:POSITIVE"),
            @WithTag("studentfeature:SMOKE"),
    })
    @Title("This test will verify if status code of 200 is returned for GET request")
    @Test
    public void verifyIfStatusCodeIs200(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @WithTags({
            @WithTag("studentfeature:NEGATIVE"),
            @WithTag("studentfeature:SMOKE"),
    })
    @Title("This test will provide an error code 400 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource(){
        SerenityRest.given()
                .when()
                .get("/list123")
                .then()
                .statusCode(400)
                .log()
                .all();
    }

}
