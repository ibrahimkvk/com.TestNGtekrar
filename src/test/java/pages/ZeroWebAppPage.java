package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebAppPage {
    public ZeroWebAppPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="signin_button")
    public WebElement sigInButonu;

    @FindBy(id="user_login")
    public WebElement userButonu;

    @FindBy(id="user_password")
    public WebElement userPassword;

    @FindBy(name="submit")
    public WebElement submitButonu;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingButonu;

    @FindBy(id="pay_bills_link")
    public WebElement payBillLinkButtonu;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement pfcButonu;

    @FindBy(id="pc_currency")
    public WebElement pcCurrencyButonu;
}
