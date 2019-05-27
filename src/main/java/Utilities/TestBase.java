package Utilities;
import Common.CommonMethods;
import ObjectRepo.FlightPage;
import ObjectRepo.LoginPage;
import ObjectRepo.RechargePage;
import Utilities.TestBase;


public class TestBase {
	public static CommonMethods cm = new CommonMethods();
	
	public static ExcelUtilis eu = new ExcelUtilis();
	public static SeleUtilis su = new SeleUtilis();
	public static LoginPage lp = new LoginPage();
	public static RechargePage rp = new RechargePage();
	public static FlightPage fp = new FlightPage ();
	
}




