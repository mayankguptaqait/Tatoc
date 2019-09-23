package com.org.tatoc;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.automation.TestSessionInitiator;

public class AppTest {
	TestSessionInitiator test;

	@BeforeMethod
	public void handleTestMethodName(Method method) {
		test = new TestSessionInitiator(this.getClass().getSimpleName());
		test.launchApplication("http://10.0.1.86/tatoc");
	}

	@Test
	public void taToc() {
		test.HomePage.selectCourseType("Basic Course");
		test.GridGate.selectGreenGrid();
		test.FrameDungeon.changeBoxColourAndProceed();
		test.DragAround.dragBoxToDropBox();
		test.PopUpWindows.launchPopUpWindowAndProceed();
		test.CookieHandling.generateTokenAndSubmit();
	}

	@AfterMethod
	public void closeDriver() throws IOException {
		test.closeBrowserSession();
	}
}
