package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage(BaseClass.getDriver());

    @Given("User is on the Swag Labs login page")
    public void user_is_on_login_page() {
        loginPage.openLoginPage();
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @And("User clicks the login button")
    public void user_clicks_login_button() {
        // Already handled inside login() method; if needed, split logic.
    }

    @Then("User should see the {string} title on the home page")
    public void user_should_see_home_page_title(String expectedTitle) {
        String actualTitle = loginPage.getHomeTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch after login.");
    }

    @Then("An error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch.");
    }

    @And("User logs out of the application")
    public void user_logs_out_of_application() {
        loginPage.clickMenu();
        loginPage.clickLogout();
    }

    @Then("User should be redirected to login page with {string} title")
    public void user_should_be_redirected_to_login_page(String expectedTitle) {
        String actualTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Login page title mismatch.");
    }
}
