package Common;
import Utilities.TestBase;
public class CommonMethods extends TestBase{

	
	public void userLogin(String userName, String password) {
		su.enterText(lp.txt_email, userName);
		su.enterText(lp.txt_password, password);
		su.click(lp.btnLogin);
	}
}
