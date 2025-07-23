package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	private WebElement usernameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMessage;

	@FindBy(css = ".app_logo")
	private WebElement homeTitle;

	@Step("Logging in with username: {0} and password: {1}")
	public void login(String username, String password) {
		sendKeys(usernameInput, username);
		sendKeys(passwordInput, password);
		click(loginButton);
	}

	@Step("Getting login error message")
	public String getErrorMessage() {
		return getText(errorMessage);
	}

	@Step("Getting home page title")
	public String getHomeTitle() {
		return getText(homeTitle);
	}

	@Step("Getting login page title")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
}
