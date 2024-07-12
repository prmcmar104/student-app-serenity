package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

/**
 * Created by Jay
 */
public class TagsTest extends TestBase {

    @Test
    public void invalidMethod(){
        SerenityRest.given()
                .when()
                .post("/list")
                .then()
                .statusCode(405)
                .log().all();
    }

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
