package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
import pages.ProductPage;
import pages.ShopWomenPage;
import pages.ShoppingCartPage;
import utils.UtilWebDriver;

public class PriceSteps {

	private MainPage mainPage = new MainPage();
	private ShopWomenPage shopWomenPage = new ShopWomenPage();
	private ProductPage productPage = new ProductPage();
	private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

	@Given("I visit the Tammana website")
	public void i_visit_the_tammana_website() {
		mainPage.getMainPage();
	}

	@When("I click on female category")
	public void i_click_on_female_category() {
		mainPage.getShopWomenPage();
	}

	@When("select first product")
	public void select_any_product() {
		shopWomenPage.selectFirstItem();
	}

	@When("select size")
	public void select_size_xs() {
		productPage.clickInSize();
	}

	@When("add the product in cart")
	public void add_the_product_in_cart() {
		productPage.addProductInCart();
		double price = productPage.capturePriceProduct();
		productPage.addPriceInList(price);
	}

	@When("return to previous page")
	public void return_to_previous_page() {
		productPage.isConfirmationMessageVisible();
		productPage.clickBackButton();
		shopWomenPage.clickBackButton();
	}

	@When("I click on male category")
	public void i_click_on_male_category() {
		mainPage.getShopMenPage();
	}

	@When("I click on the shopping cart")
	public void i_click_on_the_shopping_cart() throws InterruptedException {
		// productPage.clickInShoppingBag();
		productPage.isConfirmationMessageVisible();
		UtilWebDriver.getDriver().get("https://www.tamanna.com/cart");
	}

	@Then("the price shown must be the sum of all selected products and total items in cart must equal two")
	public void the_price_shown_must_be_the_sum_of_all_selected_products() {
		shoppingCartPage.waitSubTotalVisible();
		double sum = productPage.sumOfPrices();
		double subtTotal = shoppingCartPage.getSubtotal();
		assertTrue(sum == subtTotal);
		assertEquals(2, productPage.getListPrices().size());
		UtilWebDriver.close();
	}

}
