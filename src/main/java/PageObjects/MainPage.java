package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {



    public static final String homePageUrl = "https://rozetka.com.ua/";

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "signin")
    private WebElement signInButton;

    @FindBy(css = "#m-main-ul li:nth-child(1) a")
    private WebElement noteBookAndPcCategoryItem;

    @FindBy(css = ".f-menu-cols .f-menu-sub:nth-child(1) a")
    private WebElement noteBookCategorySubItem;

    public MainPage open() {
        driver.get(homePageUrl);
        return this;
    }

    public LoginPopupPage openLoginPopupPage() {
        this.signInButton.click();

        return new LoginPopupPage(driver, wait);
    }



    public NoteBookCategoryPage openNotebookCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(this.noteBookAndPcCategoryItem).build().perform();
        wait.until(ExpectedConditions.visibilityOf(noteBookCategorySubItem));
        this.noteBookCategorySubItem.click();

        return new NoteBookCategoryPage(driver, wait);
    }
}
