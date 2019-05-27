package TestCase;

import java.io.IOException;
import Common.CommonMethods;

import org.apache.maven.plugins.annotations.Parameter;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import Utilities.TestBase;
import jxl.common.Assert;

public class TS01_Login extends TestBase {

	
	
//@BeforeMethod
public void preCondition () throws IOException {
		
		su.openBrowser("chrome");
		su.openURL("https://accounts.globalgarner.com");
	}
	
//@Test
public void TC_01_verify_user_login() {
		
		
		//su.enterText(lp.txt_email, "itravadi@gmail.com");
		//su.enterText(lp.txt_password, "global916");
		//su.click(lp.btnLogin);
	cm.userLogin("itravadi@gmail.com", "global916");
		
	}
	
	
@Test
public void TC_02_Recharge() {
	
	su.openBrowser("chrome");
	su.openURL("https://recharge.globalgarner.com/");
	cm.userLogin("itravadi@gmail.com", "global916");
	su.mouseHover(rp.mobile_postpaid);
	su.click(rp.mobile_postpaid);
	su.selctByText(rp.operator_selection, "IDEA Postpaid");
	su.enterText(rp.mobile_number, "9824422402");
	su.enterText(rp.amount, "100");
	}


}