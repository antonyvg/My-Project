package Project.Script;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Project.Page.LeadsPage;

public class LeadPageofCRM extends BasePageofCRM {
	LeadsPage lead1;

	@Test(priority = 25)
	public void leadSelect() {
		lead1 = new LeadsPage(driver);
		lead1.leadSelect();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 26)
	public void leadDrops1() {
		lead1 = new LeadsPage(driver);
		lead1.leadDrops();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 27)
	public void leadForward() {
		lead1 = new LeadsPage(driver);
		lead1.selectFront();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 28)
	public void leadSelections() {
		lead1 = new LeadsPage(driver);
		lead1.selectItems();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

	@Test(priority = 29)
	public void dataEntering() {
		lead1 = new LeadsPage(driver);
		lead1.enterDatas();

		SoftAssert s = new SoftAssert();
		s.assertNotNull(driver);
		s.assertAll();
	}

}
