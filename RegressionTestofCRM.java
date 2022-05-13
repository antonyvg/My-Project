package Project.Script;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMprojectConstants.Constants1;
import Project.Page.ContactPage;
import Project.Utilities.ExcelUtilities;

public class RegressionTestofCRM extends BasePageofCRM{
	ContactPage con;
	
	@Test(priority = 3)
	public void contSel() throws InterruptedException {
		con = new ContactPage(driver);

		con.contactDetails();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 4)
	public void scrollPage() throws InterruptedException {
		con = new ContactPage(driver);

		con.checkBoxees();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(dataProvider = "contactDetails1", priority = 5)
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
	@DataProvider
	public Object[][] contactDetails1() throws Exception {

		Object[][] data = ExcelUtilities.excelRead(Constants1.ExcelPaths, "details1");
		return data;
	}

}
