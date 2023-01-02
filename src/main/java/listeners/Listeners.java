package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReporter;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Listeners implements ITestListener, Connection.Base {

    WebDriver driver = null;
    ExtentReports extentReport = ExtentReporter.getExtentReport();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

    public Listeners() throws FileNotFoundException {
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();

        extentTest = extentReport.createTest(testName);
        extentTestThread.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String testName = result.getName();
        //extentTest.log(Status.PASS,testName+" got passed");
        extentTestThread.get().log(Status.PASS,testName+" got passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testMethodName = result.getName();

        //extentTest.fail(result.getThrowable());
        extentTestThread.get().fail(result.getThrowable());

        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        String screenshotFilePath = takeScreenshot(testMethodName,driver);
        extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);

    }

    private String takeScreenshot(String testMethodName, WebDriver driver) {
        return testMethodName;
    }

    @Override
    public void onTestSkipped(ITestResult result) {


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {


    }

    @Override
    public void onStart(ITestContext context) {


    }

    @Override
    public void onFinish(ITestContext context) {

        extentReport.flush();

    }

    @Override
    public URL url() {
        return null;
    }

    @Override
    public Connection.Base url(URL url) {
        return null;
    }

    @Override
    public Connection.Method method() {
        return null;
    }

    @Override
    public Connection.Base method(Connection.Method method) {
        return null;
    }

    @Override
    public String header(String name) {
        return null;
    }

    @Override
    public List<String> headers(String name) {
        return null;
    }

    @Override
    public Connection.Base header(String name, String value) {
        return null;
    }

    @Override
    public Connection.Base addHeader(String name, String value) {
        return null;
    }

    @Override
    public boolean hasHeader(String name) {
        return false;
    }

    @Override
    public boolean hasHeaderWithValue(String name, String value) {
        return false;
    }

    @Override
    public Connection.Base removeHeader(String name) {
        return null;
    }

    @Override
    public Map<String, String> headers() {
        return null;
    }

    @Override
    public Map<String, List<String>> multiHeaders() {
        return null;
    }

    @Override
    public String cookie(String name) {
        return null;
    }

    @Override
    public Connection.Base cookie(String name, String value) {
        return null;
    }

    @Override
    public boolean hasCookie(String name) {
        return false;
    }

    @Override
    public Connection.Base removeCookie(String name) {
        return null;
    }

    @Override
    public Map<String, String> cookies() {
        return null;
    }
}