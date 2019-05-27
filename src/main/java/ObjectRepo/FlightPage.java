package ObjectRepo;

import org.openqa.selenium.By;

public class FlightPage {

	
	public By from_city = By.xpath("//span[@id='react-select-2--value']//div[@class='Select-placeholder'][contains(text(),'Select Airport')]");
	public By from_city_selection = By.cssSelector(".Select-option");
	public By to_city = By.xpath("//span[@id='react-select-3--value']//div[@class='Select-placeholder'][contains(text(),'Select Airport')]");
	public By to_city_selection = By.cssSelector(".Select-option");
	
}
