package com.raha.profile.auth;

import com.raha.profile.BaseIntegTest;
import com.raha.profile.auth.dtos.LoginDto;
import com.raha.profile.user.entity.UserEntity;
import com.raha.profile.user.repository.UserRepository;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.raha.profile.utility.UrlMappings.LOGIN;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegTest extends BaseIntegTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void clearDatabase() {
        userRepository.deleteAll();
    }

    @Test
    public void success_login_user() {
        createUser("ali", "1000");
        var loginDto = LoginDto.builder()
                .userName("ali")
                .password("1000")
                .build();

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(loginDto)
                .post(LOGIN)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("userId", notNullValue())
                .body("accessToken", notNullValue())
                .body("refreshToken", notNullValue())
                .body("accessExpiration", equalTo(10))
                .body("refreshExpiration", equalTo(12))
        ;
    }

    @Test
    public void fail_login_user_when_user_name_is_incorrect() {
        createUser("mohammad", "1000");
        var loginDto = LoginDto.builder()
                .userName("ali")
                .password("1000")
                .build();

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(loginDto)
                .post(LOGIN)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

    private void createUser(String userName, String password) {
        var user = new UserEntity(userName, password);
        userRepository.save(user);
    }
}
