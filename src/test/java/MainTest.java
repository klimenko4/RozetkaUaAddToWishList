import PageObjects.MainPage;
import PageObjects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{

 public final static String userEmail = "pdqvbhad@10mail.org";
 public final static String userPass = "12345678A";



    @Test
    public void addPopularProductTWishList() {
        MainPage mainPage = new MainPage(driver, wait);
        ProductPage productPage = new ProductPage(driver,wait);



        String beforeAddToWishlistProductName = mainPage.open()
                .openLoginPopupPage()
                .loginAs(userEmail,userPass)
                .openNotebookCategory()
                .clickOnPriceRange()
                .openResultWithMaxReview()
                .getProductName()
                .trim();

        String productInWishList = productPage.addProductToWishList()
                .openWishListPage()
                .getProductNameInWishList()
                .trim();

        Assert.assertEquals(productInWishList,beforeAddToWishlistProductName);

    }

}
