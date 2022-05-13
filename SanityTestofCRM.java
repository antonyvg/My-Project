package Project.Script;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMprojectConstants.Constants1;
import Project.Page.ContactPage;
import Project.Page.HomePage;
import Project.Page.LoginPage;
import Project.Utilities.ExcelUtilities;

public class SanityTestofCRM extends BasePageofCRM {
	LoginPage obj;
	HomePage home;
	ContactPage con;

	@Test(dataProvider = "validUserValidPass", priority = 0)
	public void validUserValidPass(String name1, String pass1) throws InterruptedException {

		obj = new LoginPage(driver);
		System.out.println("username is " + name1);
		obj.username(name1);
		obj.password(pass1);
		obj.sum();
		obj.submit();

		String tit = driver.getTitle();
		System.out.println(tit);
		SoftAssert s = new SoftAssert();
		s.assertEquals(Constants1.Titile1, tit);
		s.assertAll();

	}

	@Test(priority = 1)
	public void homeLogin() throws InterruptedException {
		home = new HomePage(driver);
		home.quoteClick();

		String tit = driver.getTitle();
		System.out.println(tit);
		SoftAssert s = new SoftAssert();
		s.assertEquals(Constants1.Titile1, tit);
		s.assertAll();
	}

	@Test(priority = 2)
	public void contSelect() throws InterruptedException {
		con = new ContactPage(driver);

		con.contact();

		String a = driver.getCurrentUrl();
		System.out.println(a);

		SoftAssert s = new SoftAssert();
		s.assertNotEquals(Constants1.HomepageURL, a);
		s.assertAll();
	}

	@DataProvider
	public Object[][] validUserValidPass() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "validuservalidpass");
		return data;
	}

}
