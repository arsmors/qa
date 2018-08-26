package rest;

import com.google.common.collect.Lists;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import model.ListResponse;
import model.Message;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public class RestAssuredTest {
    private String token = getAuthToken();

    @Before
    public void setUpOnce() throws Exception {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    public String getAuthToken() {
        String token = given().formParam("token", "1223d44")
                .post("http://api/login")
                .then()
                .statusCode(200)
                .body("status", is(200))
                .body("data.last_name", is("Smith"))
                .extract().body()
                .jsonPath().getString("data.access_token");
        return token;
    }

    @Test
    public void testProfileGet() {
        given().header("Authorization", token)
                .when().get("http://api/me")
                .then()
                .statusCode(200)
                .body("data.email", is("example@email.com"));
    }

    @Test
    public void testProfileUpdate() {
    }


    @Test
    public void testMessagesList() {
        // messages list
        int messageId = given().header("Authorization", token)
                .when().get("http://i/messages?limit=20")
                .then()
                .statusCode(200)
                .body("data.id", is(Lists.newArrayList(7, 5, 4)))
                .body("data[1].id", is(5))
                .extract().body().jsonPath().getInt("data[1].id");

        // handle invitation, accept
        given().header("Authorization", token)
                .formParam("action", "accept")
                .when().post("http:///api/messages/{id}/invitation", messageId)
                .then()
                .statusCode(200)
                .body("data.message", is("You will attend"));

        // handle invitation, decline
        given().header("Authorization", token)
                .formParam("action", "decline")
                .when().post("http://i/messages/{id}/invitation", messageId)
                .then()
                .statusCode(200)
                .body("data.message", is("You will not attend"));

        // messages read
        given().header("Authorization", token)
                .when().post("http://ssages/read")
                .then()
                .statusCode(200)
                .body("data.message", is("Messages are read"));

    }

    @Test
    public void testListProper() {
        ListResponse response = given().header("Authorization", token)
                .when().get("http:///api/messages?limit=20")
                .then()
                .statusCode(200)
                .body("data.id", is(Lists.newArrayList(7, 5, 4)))
                .body("data[1].id", is(5))
                .extract().as(ListResponse.class);

        List<Message> messages = response.getData().stream()
                .filter(Message::isIs_event)
                .collect(toList());
//                .findFirst();
        if (messages.isEmpty()) {
            fail("True is event messages not found");
        }
        for (Message message : messages) {
            given().header("Authorization", token)
                    .formParam("action", "accept")
                    .when().post("http://.com/api/messages/{id}/invitation", message.getId())
                    .then()
                    .statusCode(200)
                    .body("data.message", is("You will attend"));
        }

    }

    @Test
    public void testNewsList() {
        given().header("Authorization", token)
                .when().get("http://om/api/news?=limit=20")
                .then()
                .statusCode(200)
                .body("data[4].payload.id", is(10))
                .body("data[4].payload.title", is ("Arsens poll 1-2"));
    }

    @Test
    public void testNewsHandleVote() {
    }

    @Test
    public void testCoursesList() {
    }

    @Test
    public void testAwardsList() {
    }

    @Test
    public void testDiplomasList() {
    }

    @Test
    public void testCertificatesList() {
    }
}
