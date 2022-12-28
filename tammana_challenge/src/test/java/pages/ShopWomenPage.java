package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShopWomenPage extends MainPage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div[1]/div/div")
	private WebElement banner;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div[4]/div/div/div[2]/div/div/div/ul/li[1]/div/div[1]/div[1]/a")
	private WebElement product1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div[4]/div/div/div[2]/div/div/div/ul")
	private WebElement listOfProducts;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[1]/div[4]/div/div/div[2]/div/div/div/ul/li[1]/div/div[1]/a/span")
	private WebElement item1;

	public List<WebElement> getProducts() {
		List<WebElement> li_All = listOfProducts.findElements(By.tagName("a"));
		return li_All;
	}

	public WebElement selectRandomProduct() {
		Random rand = new Random();
		WebElement randomElement = getProducts().get(rand.nextInt(getProducts().size()));
		return randomElement;
	}

	public void selectFirstItem() {
		waitByElement(banner);
		scrollPageByElement(listOfProducts);
		waitByElement(product1);
		product1.click();
	}

}
