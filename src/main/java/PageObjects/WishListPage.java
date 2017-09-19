package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage extends BasePage{


    @FindBy(css = ".g-i-tile-i-title a")
    private WebElement desirableProductLink;

    public WishListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public String getProductNameInWishList() {
        return this.desirableProductLink.getText();
    }
}
