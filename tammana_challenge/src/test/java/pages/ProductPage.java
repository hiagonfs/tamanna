package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends MainPage {

	private List<Double> prices = new ArrayList<Double>();

	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[2]/div[1]/div[2]/div/div[2]/div/div[4]/div/div[2]/button")
	private WebElement addInCart;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[2]/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div[2]/button[1]")
	private WebElement selectSize;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/header/div[1]/div/nav/div[3]/a[2]/div/button")
	private WebElement shoppingBag;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/p")
	private WebElement priceProduct;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/header/div[3]/div/div")
	private WebElement confirmationMessage;

	public void addPriceInList(double price) {
		prices.add(price);
	}

	public void isConfirmationMessageVisible() {
		waitByElement(confirmationMessage);
	}

	public void addProductInCart() {
		scrollPage();
		waitByElement(addInCart);
		addInCart.click();
	}

	public void clickInSize() {
		waitByElement(selectSize);
		selectSize.click();
	}

	public void clickInShoppingBag() {
		waitByElement(shoppingBag);
		shoppingBag.click();
	}

	public double capturePriceProduct() {
		String price = priceProduct.getText().replaceAll("[^0-9.]", "");
		return new Double(price);
	}

	public List<Double> getListPrices() {
		return this.prices;
	}

	public double sumOfPrices() {
		return prices.stream().mapToDouble(Double::doubleValue).sum();
	}

}
