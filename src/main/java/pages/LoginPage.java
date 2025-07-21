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

    // Locators
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    @FindBy(className = "app_logo")
    private WebElement homePageTitle;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    // Actions

    @Step("Open the login page")
    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Login with username: {username} and password: {password}")
    public void login(String username, String password) {
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    @Step("Get error message text")
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    @Step("Get home page title text")
    public String getHomeTitle() {
        return homePageTitle.getText();
    }

    @Step("Get login page title")
    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    @Step("Click on menu button")
    public void clickMenu() {
        click(menuButton);
    }

    @Step("Click on logout link")
    public void clickLogout() {
        click(logoutLink);
    }
}
