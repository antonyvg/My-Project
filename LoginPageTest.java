package Project.Script;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMprojectConstants.Constants1;
import Project.Page.ContactPage;
import Project.Page.HomePage;
import Project.Page.LoginPage;
import Project.Utilities.ExcelUtilities;
import jxl.common.Assert;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class LoginPageTest extends BasePageofCRM {

	LoginPage obj;

	@Test(dataProvider = "invalidUserInvalidPass", priority = 0)
	public void invalidUserInvalidPass(String name1, String pass1) throws Exception {

		obj = new LoginPage(driver);
		System.out.println("username is " + name1);

		obj.username(name1);
		obj.password(pass1);
		obj.sum();
		obj.submit();
		String tit = driver.getTitle();

		SoftAssert s = new SoftAssert();
		s.assertEquals(Constants1.Titile, tit);
		s.assertAll();

	}

	@Test(dataProvider = "invalidUservalidPass", priority = 1)
	public void invalidUservalidPass(String name1, String pass1) throws Exception {

		obj = new LoginPage(driver);

		System.out.println("username is " + name1);
		obj.username(name1);
		obj.password(pass1);
		obj.sum();
		obj.submit();

		String tit = driver.getTitle();

		SoftAssert s = new SoftAssert();
		s.assertEquals(Constants1.Titile, tit);
		s.assertAll();

	}

	@Test(dataProvider = "validUserInvalidPass", priority = 2)
	public void validUserInvalidPass(String name1, String pass1) throws InterruptedException {

		obj = new LoginPage(driver);
		System.out.println("username is " + name1);
		obj.username(name1);
		obj.password(pass1);
		obj.sum();
		obj.submit();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();

	}

	@Test(priority = 3)
	public void blankUserPass() throws InterruptedException {

		obj = new LoginPage(driver);
		System.out.println("its blank");
		obj.sum();
		obj.submit();

		String tit = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(Constants1.Titile, tit);
		s.assertAll();

	}

	@Test(dataProvider = "forgotUserDetails", priority = 4)
	public void forgotUser(String mailid) throws InterruptedException {

		obj = new LoginPage(driver);
		System.out.println("mailid is " + mailid);
		obj.forgot(mailid);

		String tit = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(Constants1.Titile, tit);
		s.assertAll();

	}

	@Test(dataProvider = "validUserValidPass", groups = { "Sanity Test" }, priority = 5)
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

	@DataProvider
	public Object[][] invalidUserInvalidPass() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "invaliduserinvalidpass");
		return data;
	}

	@DataProvider
	public Object[][] invalidUservalidPass() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "invaliduservalidpass");
		return data;
	}

	@DataProvider
	public Object[][] validUserInvalidPass() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "vailduserinvalidpass");
		return data;
	}

	@DataProvider
	public Object[][] forgotUserDetails() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "forgot");
		return data;
	}

	@DataProvider
	public Object[][] validUserValidPass() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "validuservalidpass");
		return data;
	}

}
