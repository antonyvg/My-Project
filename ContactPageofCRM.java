package Project.Script;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMprojectConstants.Constants1;
import Project.Page.ContactPage;
import Project.Page.HomePage;
import Project.Page.LoginPage;
import Project.Utilities.ExcelUtilities;

import org.testng.annotations.DataProvider;

public class ContactPageofCRM extends BasePageofCRM {

	ContactPage con;

	@Test(priority = 13, groups = { "Sanity Test" })
	public void contSelect() throws InterruptedException {
		con = new ContactPage(driver);

		con.contact();

		String a = driver.getCurrentUrl();
		System.out.println(a);

		SoftAssert s = new SoftAssert();
		s.assertNotEquals(Constants1.HomepageURL, a);
		s.assertAll();
	}

	@Test(priority = 14)
	public void contDrop() throws InterruptedException {
		con = new ContactPage(driver);

		con.contactDrop();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 15)
	public void contSel() throws InterruptedException {
		con = new ContactPage(driver);

		con.contactDetails();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 16)
	public void contBack() throws InterruptedException {
		con = new ContactPage(driver);

		con.back();

		String a = driver.getCurrentUrl();

		SoftAssert s = new SoftAssert();
		s.assertNotEquals(Constants1.HomepageURL, a);
		s.assertAll();
	}

	@Test(priority = 17)
	public void contDrop1() throws InterruptedException {
		con = new ContactPage(driver);

		con.contactDrop1();

		String b = driver.getCurrentUrl();
		System.out.println(b);
		SoftAssert s = new SoftAssert();
		s.assertNotEquals(Constants1.ContactURL, b);

		s.assertAll();
	}

	@Test(priority = 18)
	public void select() throws InterruptedException {
		con = new ContactPage(driver);

		con.saveClick();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 19)
	public void scrollPage() throws InterruptedException {
		con = new ContactPage(driver);

		con.checkBoxees();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(dataProvider = "contactDetails1", priority = 20)
	public void contactDetailsAdd1(String name1, String last1, String comp1, String mail1, String phne1, String web1)
			throws InterruptedException {
		con = new ContactPage(driver);

		con.firstName(name1);
		con.lastName(last1);
		con.compName(comp1);
		con.mailDetails(mail1);
		con.phoneNum(phne1);
		con.webDetails(web1);

		con.saveClick();
		con.back();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();

	}

	@Test(dataProvider = "contactDetails2", priority = 21)
	public void contactDetailsAdd2(String name1, String last1, String comp1, String mail1, String phne1, String web1)
			throws InterruptedException {
		con = new ContactPage(driver);

		con.firstName(name1);
		con.lastName(last1);
		con.contactDrop1();
		con.compName(comp1);
		con.mailDetails(mail1);
		con.phoneNum(phne1);
		con.webDetails(web1);
		con.checkBoxees();

		con.saveClick();
		con.back1();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();

	}

	@Test(priority = 22)
	public void seacrhCompany() throws InterruptedException {
		con = new ContactPage(driver);

		con.contactSearch();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 23)
	public void viewCompany() throws InterruptedException {
		con = new ContactPage(driver);

		con.viewDetails();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 24)
	public void editCompany() throws InterruptedException {
		con = new ContactPage(driver);

		con.editDetails();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@DataProvider
	public Object[][] contactDetails1() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "details1");
		return data;
	}

	@DataProvider
	public Object[][] contactDetails2() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "details2");
		return data;
	}

}
