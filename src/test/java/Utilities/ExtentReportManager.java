package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcase.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener  //or TestListenerAdapter class
	{
		public ExtentSparkReporter sparkReporter;  // UI of the report
		public ExtentReports extent;  //populate common info on the report
		public ExtentTest test; // creating test case entries in the report and update status of the test methods
		public void onStart(ITestContext context) {
			String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/report/myReport"+timeStamp+".html");//specify location of the report
			sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
			sparkReporter.config().setReportName("Finding newbikes"); // name of the report
			sparkReporter.config().setTheme(Theme.DARK);		
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);	
			extent.setSystemInfo("Computer Name","localhost");
			extent.setSystemInfo("Environment","QA");
			extent.setSystemInfo("Tester Name","Harinitha");
			extent.setSystemInfo("os","Windows11");
			extent.setSystemInfo("Browser name","Chrome,Edge");
			
			List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
			}
		}
	 
	 
		public void onTestSuccess(ITestResult result) {
			test = extent.createTest(result.getName()); // create a new entry in the report
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, "TEST CASE PASSED IS  :" + result.getName()); // update status p/f/s
			
			String ss_path= new BaseClass().screenShot(result.getName());
			test.addScreenCaptureFromPath(ss_path);
			logger.info("passed"+ result.getName());
			
		}
	 
		public void onTestFailure(ITestResult result) {
			test = extent.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
			test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
			
			String ss_path=new BaseClass().screenShot(result.getName());
			test.addScreenCaptureFromPath(ss_path);
			logger.info("Failed"+ result.getName());
		}
	 
		public void onTestSkipped(ITestResult result) {
	 
			test = extent.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
			String ss_path=new BaseClass().screenShot(result.getName());
			test.addScreenCaptureFromPath(ss_path);
			logger.info("skipped"+ result.getName());
		}
	 
		
		public void onFinish(ITestContext context) {
			extent.flush();
		}

	}


