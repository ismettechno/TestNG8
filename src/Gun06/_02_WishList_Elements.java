package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _02_WishList_Elements {

    public _02_WishList_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//div[@class='caption'] / h4")
    public List<WebElement> productNameList;

    @FindBy(xpath = "//*[@data-original-title='Add to Wish List']")
    public List<WebElement> wishButtons;

    @FindBy(xpath= "//a[@id='wishlist-total']")
    public WebElement wishListLink;

    @FindBy(css = "[class='text-left'] a")
    public List<WebElement> wishNameList;

}
