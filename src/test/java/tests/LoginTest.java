package tests;

import org.testng.annotations.Test;

public class LoginTest extends tests.BaseTest {

    @Test(description = "Check that user is logged in with valid credentials")
    public void userShouldLogin() {
        loginSteps
                .login(user, password);
    }

    @Test(description = "Check that user isn't logged in with invalid credentials")
    public void userShouldNotLogin() {
        loginSteps
                .login("ksandrnav@gmail.com", password, "These credentials do not match our records.");
    }
}
