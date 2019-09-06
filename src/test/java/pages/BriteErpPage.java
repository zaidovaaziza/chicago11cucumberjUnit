package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BriteErpPage {

    public BriteErpPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "login")
    public WebElement emailButton;

    @FindBy(id = "password")
    public  WebElement passwordButton;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement loginButton;

    @FindBy(xpath = "(//a[@class='oe_menu_toggler'])[3]")
    public WebElement inventoryTab;

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[18]")
    public WebElement transfersTab;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement importTab;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_import_cancel']")
    public WebElement cancelButton;
}
