package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.UtilWebDriver;

public class MainPage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[2]/div[1]/a/div/div[2]/button")
	private WebElement iconShopWomen;
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[2]/main/div/div[2]/div[2]/a/div/div[2]/button")
	private WebElement iconShopMen;

	public MainPage() {
		PageFactory.initElements(UtilWebDriver.getDriver(), this);
	}

	public void getMainPage() {
		UtilWebDriver.getDriver().get("https://www.tamanna.com/");
	}

	public void getShopWomenPage() {
		iconShopWomen.click();
	}

	public void getShopMenPage() {
		waitByElement(iconShopMen);
		iconShopMen.click();
	}

	public void clickBackButton() {
		UtilWebDriver.getDriver().navigate().back();
	}

	public void scrollPageByElement(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) UtilWebDriver.getDriver());
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollPage() {
		JavascriptExecutor js = ((JavascriptExecutor) UtilWebDriver.getDriver());
		js.executeScript("window.scrollBy(0,500);");
	}

	public WebElement waitByElement(WebElement element) {
		return new WebDriverWait(UtilWebDriver.getDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

}
