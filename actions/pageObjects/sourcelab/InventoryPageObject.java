package pageObjects.sourcelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.InventoryPageUI;

public class InventoryPageObject extends BasePage {
	private WebDriver driver;

	public InventoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String itemText) {
		waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN_LIST);
		selectDropdownByText(driver, InventoryPageUI.SORT_DROPDOWN_LIST, itemText);
	}

	public boolean isProductNameSortedAscending() {

		List<WebElement> productNamesElement = getElements(driver, InventoryPageUI.ALL_PRODUCT_NAMES);

		List<String> productNamesText = new ArrayList<String>();
		
		List<String> productNamesTextClone = new ArrayList<String>();

		for (WebElement productName : productNamesElement) {
			productNamesText.add(productName.getText());
			productNamesTextClone.add(productName.getText());
		}

		Collections.sort(productNamesTextClone);

		return productNamesText.equals(productNamesTextClone);
	}

	public boolean isProductNameSortedDecending() {

		List<WebElement> productNamesElement = getElements(driver, InventoryPageUI.ALL_PRODUCT_NAMES);

		List<String> productNamesText = new ArrayList<String>();
		
		List<String> productNamesTextClone = new ArrayList<String>();

		for (WebElement productName : productNamesElement) {
			productNamesText.add(productName.getText());
			productNamesTextClone.add(productName.getText());
		}

		Collections.sort(productNamesTextClone);

		Collections.reverse(productNamesTextClone);

		return productNamesText.equals(productNamesTextClone);
	}

	public boolean isProductPriceSortedAscending() {
		List<WebElement> productPriceElement = getElements(driver, InventoryPageUI.ALL_PRODUCT_PRICE);

		List<Float> productPriceFloat = new ArrayList<Float>();

		List<Float> productPriceFloatClone = new ArrayList<Float>();
		
		for (WebElement productPrice : productPriceElement) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$",""));
			productPriceFloat.add(productPriceNumber);
			productPriceFloatClone.add(productPriceNumber);
		}
		
		Collections.sort(productPriceFloatClone);

		return productPriceFloat.equals(productPriceFloatClone);
	}

	public boolean isProductPriceSortedDecending() {
		List<WebElement> productPriceElement = getElements(driver, InventoryPageUI.ALL_PRODUCT_PRICE);

		List<Float> productPriceFloat = new ArrayList<Float>();
		
		List<Float> productPriceFloatClone = new ArrayList<Float>();

		for (WebElement productPrice : productPriceElement) {
			Float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$",""));
			productPriceFloat.add(productPriceNumber);
			productPriceFloatClone.add(productPriceNumber);
		}
		
		Collections.sort(productPriceFloatClone);
		Collections.reverse(productPriceFloatClone);
		
		return productPriceFloat.equals(productPriceFloatClone);
	}

}
