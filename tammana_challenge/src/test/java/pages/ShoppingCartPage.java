package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage extends MainPage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")
	private WebElement price1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[3]/div/div/p[1]")
	private WebElement price2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/p[2]")
	private WebElement subTotal;
	
	public Double getSubtotal() {
		String sbTotalConvert = subTotal.getText().replaceAll("[^0-9.]", "");
		return new Double(sbTotalConvert);
	}

	public void waitSubTotalVisible() {
		waitByElement(subTotal);
	}

}
