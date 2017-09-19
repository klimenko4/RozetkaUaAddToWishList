package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{


    @FindBy(name = "towishlist")
    private WebElement toWishlistButton;


    @FindBy(id = "wishlist")
    private WebElement openWishListButton;

    @FindBy(css = ".detail-title")
    private WebElement productName;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver,this);
    }


    public ProductPage addProductToWishList(){
        this.toWishlistButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".novisited.sprite-side.detail-wishlist-link.detail-wishlist-added-link")));
        return this;
    }

    public WishListPage openWishListPage(){
        this.openWishListButton.click();
        return new WishListPage(driver, wait);
    }

    public String getProductName() {
        System.out.println(this.productName.getText());
       return this.productName.getText();
    }


}
