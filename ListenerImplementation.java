package CommonUtils;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	ExtentReports report;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("TestScipt execution is started");
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript excution is started",true);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("TestScipt execution is Passed");
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscipt execution is passed", true);
		
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("TestScipt execution is Failed");
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscipt execution is failed"+message);
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("TestScipt execution is Skipped");
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscipt execution is Skipped", true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		System.out.println("To start the execution");		
		//Use ExtentSparkReporter class just to configure extent report
		JavaUtil jutil = new JavaUtil();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Sagar");
		
		//Use ExtentReports to generate extentreport
	    report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Chromeversion", "121");
		report.setSystemInfo("Author", "Sk");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		System.out.println("To finish the execution")
//		Reporter.log("To finish the execution", true);
		report.flush();
	}

}