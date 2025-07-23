package stepDefinitions;

import org.testng.Assert;
import io.qameta.allure.Step;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.ConfigReader;
import base.BaseClass;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage(BaseClass.getDriver());

    @Given("User is on the Swag Labs login page")
    @Step("Navigating to Swag Labs login page")
    public void navigateToLoginPage() {
        BaseClass.getDriver().get(ConfigReader.get("baseUrl"));
    }

    @When("User logs in with valid credentials")
    @Step("Logging in with valid credentials from config")
    public void loginWithValidCredentials() {
        String username = ConfigReader.get("validUsername");
        String password = ConfigReader.get("validPassword");
        loginPage.login(username, password);
    }

    @When("User enters username {string} and password {string}")
    @Step("Logging in with username: {0} and password: {1}")
    public void loginWithDynamicCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("User should see the expected title on home page")
    @Step("Validating homepage title")
    public void validateHomePageTitle() {
        String expectedTitle = ConfigReader.get("expectedTitle");
        Assert.assertEquals(loginPage.getHomeTitle(), expectedTitle, "Home page title mismatch!");
    }

    @Then("An error message {string} should be displayed")
    @Step("Validating displayed error message: {0}")
    public void validateDynamicErrorMessage(String expectedError) {
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Error message mismatch!");
    }
}
