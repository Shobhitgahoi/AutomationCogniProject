package pages;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.Utility;

public class LoginPage extends BasePage<LoginPage> {
	
	ExcelDataReader excelreader=new ExcelDataReader();
	@AndroidFindBy(id="sign_in_button")
	private MobileElement ALLOW_SIGNIN;
	
	
	@AndroidFindBy(className="android.widget.EditText")
	private MobileElement EMAIL_ADDRESS;
	
	@AndroidFindBy(xpath="//*[@text='Amazon password']")
	private MobileElement PASSWORD_FIELD;
	
	@AndroidFindBy(xpath="//*[@resource-id='continue']")
	private MobileElement CONTINUE_BTN;
	
	@AndroidFindBy(className="android.widget.Button")
	private MobileElement SIGN_IN_BTN;
	
	
	public LoginPage(AppiumDriver driver) {
		super(driver);
	}
	
	
	/**
	 * @author Shobhit Gahoi
	 *
	 *  login 
	 * @return LoginPage
	 * @tag  @return
	 */
	public LoginPage selectSigninButton() {
		clickAfterFindingElement(ALLOW_SIGNIN);
		try {
			testReporter.log(LogStatus.PASS, "Clicking Sign in Button...",  testReporter.addScreenCapture(Utility.captureScreenshot(driver, screenShotPath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return this;
	}
	
	/**
	 * @author Shobhit Gahoi
	 *
	 *	Set Email Address
	 * @return LoginPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public LoginPage setEmailAddress() throws Exception {
		waitForElementToBeDisplayed(EMAIL_ADDRESS);
		clickAfterFindingElement(EMAIL_ADDRESS);
		String emailaddress=excelreader.readingData("sheet1",1, 0);
		setvalues(EMAIL_ADDRESS, emailaddress);
		try {
			testReporter.log(LogStatus.PASS, "Entering Email Id Button...",  testReporter.addScreenCapture(Utility.captureScreenshot(driver, screenShotPath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	/**
	 * @author Shobhit Gahoi
	 *
	 *	Click on Continue button
	 * @return LoginPage
	 * @tag  @return
	 */
	public LoginPage selectContinue() {
		clickAfterFindingElement(CONTINUE_BTN);
		
		try {
			testReporter.log(LogStatus.PASS, "Clicking Continue Button...",  testReporter.addScreenCapture(Utility.captureScreenshot(driver, screenShotPath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * @author Shobhit Gahoi
	 *
	 *	Enter the password
	 * @return LoginPage
	 * @tag  @return
	 * @tag  @throws Exception
	 */
	public LoginPage setPassword() throws Exception {
		waitForElementToBeDisplayed(PASSWORD_FIELD);
		String password=excelreader.readingData("sheet1",1, 1);
		setvalues(PASSWORD_FIELD, password);
		
		try {
			testReporter.log(LogStatus.PASS, "Entering Password Button...",  testReporter.addScreenCapture(Utility.captureScreenshot(driver, screenShotPath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
	
	
	/**
	 * @author Shobhit Gahoi
	 *
	 * Click on Sign in button
	 * @return ProductSearchPage
	 * @tag  @return
	 */
	public ProductSearchPage selectSignIn() {
		clickAfterFindingElement(SIGN_IN_BTN);
		return new ProductSearchPage(getDriver());
	}
	

}
