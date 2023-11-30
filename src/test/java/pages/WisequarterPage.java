package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WisequarterPage {
    public WisequarterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='elementskit-btn  whitespace--normal'])[2]")
    public WebElement LMSButon;

    @FindBy(id="username")
    public WebElement usernameButton;

    @FindBy(id="password")
    public WebElement passwordButton;

    @FindBy(id="loginbtn")
    public WebElement logInButton;

    @FindBy(tagName = "h2")
    public WebElement wellcomeBackYaziElement;

    @FindBy(xpath="//div[@class='alert alert-danger']")
    public WebElement gecersizYaziElemeti;
}
