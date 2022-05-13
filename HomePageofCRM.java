package Project.Script;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMprojectConstants.Constants1;
import Project.Page.ContactPage;
import Project.Page.HomePage;
import Project.Page.LoginPage;

public class HomePageofCRM extends BasePageofCRM {

	HomePage home;

	@Test(priority = 6)
	public void homeLogin() throws InterruptedException {
		home = new HomePage(driver);
		home.quoteClick();

		String tit = driver.getTitle();
		System.out.println(tit);
		SoftAssert s = new SoftAssert();
		s.assertEquals(Constants1.Titile1, tit);
		s.assertAll();
	}

	@Test(priority = 7)
	public void homeDrop() throws InterruptedException {
		home = new HomePage(driver);
		home.quoteDrop1();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 8)
	public void homeDrop1() throws InterruptedException {
		home = new HomePage(driver);
		home.quoteDrop2();

		String c = driver.getCurrentUrl();

		SoftAssert s = new SoftAssert();
		s.assertNotEquals(Constants1.ContactURL, c);
		s.assertAll();
	}

	@Test(priority = 9)
	public void quoteSelect() throws InterruptedException {
		home = new HomePage(driver);
		home.quoteMove();

		String c = driver.getCurrentUrl();

		SoftAssert s = new SoftAssert();
		s.assertNotEquals(Constants1.ContactURL, c);
		s.assertAll();
	}

	@Test(priority = 10)
	public void invoiceSelect() throws InterruptedException {
		home = new HomePage(driver);
		home.invoice();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 11)
	public void invoiceDrop() throws InterruptedException {
		home = new HomePage(driver);
		home.invoiceDrop();

		SoftAssert s = new SoftAssert();

		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 12)
	public void invocSelect() throws InterruptedException {
		home = new HomePage(driver);
		home.invoicMove();

		String c = driver.getCurrentUrl();

		SoftAssert s = new SoftAssert();
		s.assertNotEquals(Constants1.ContactURL, c);
		s.assertAll();
	}
}
