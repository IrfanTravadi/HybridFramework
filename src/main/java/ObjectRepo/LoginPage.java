package ObjectRepo;

import org.openqa.selenium.By;

public class LoginPage {

	public By txt_email = By.id("username");
	public By txt_password = By.name("password");
	public By btnLogin = By.xpath("/html/body/div[2]/div/div/div[2]/div/form/div[4]/button");
}