package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilterResultsPage extends BasePage {

    public FilterResultsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    By reviews = By.cssSelector(".g-rating-reviews");

    public int getMaxReview() {
        List<WebElement> allReviews = driver.findElements(reviews);

        int i = 0;
        for (WebElement el : allReviews) {
            if (!el.getText().equals("Оставить отзыв") && !el.getText().equals("Залишити відгук")) {
                int reviewNumber = Integer.parseInt(el.getText().replaceAll("[^0-9]", ""));
                if (i < reviewNumber) {
                    i = reviewNumber;
                }
            }
        }
        return i;
    }

    public ProductPage openResultWithMaxReview() {
        int maxReviewNumber = getMaxReview();
        String itemWithMaxReviewLink = String.format("//span[contains(@class,'g-rating') and contains(text(),'%d')]/../../../.." +
                "//*[contains(@class, 'g-i-tile-i-title')]/a", maxReviewNumber);
        driver.findElement(By.xpath(itemWithMaxReviewLink)).click();
        return new ProductPage(driver,wait);
    }
}
