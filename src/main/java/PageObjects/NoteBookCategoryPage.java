package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoteBookCategoryPage extends BasePage {


    @FindBy(css = "[name='menu_categories_left'] .m-cat-l-i:nth-child(3) li:nth-child(3)")
    private WebElement priceRange;

    public NoteBookCategoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver,this);
    }


    public FilterResultsPage clickOnPriceRange() {
        priceRange.click();
        return new FilterResultsPage(driver, wait);
    }
}
