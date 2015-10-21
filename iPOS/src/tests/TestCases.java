package tests;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.common.ExtentManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import base.BaseMethods;
import base.GlobalVariables;
import pageObjects.LoginPage;


public class TestCases {
	public static WebDriver driver;
	
	public  Assertion hardAssert = new Assertion(); 
	public  SoftAssert softAssert = new SoftAssert(); 
	private ExtentReports extent = BaseMethods.getInstance();
	 
//	@BeforeClass
//	public void beforefclass() throws Exception {		
//	
//	}
	@BeforeMethod
	public void beforeMethod() throws Exception {		
		driver= BaseMethods.GetDriver("chrome");  
		driver.manage().window().maximize();        
       BaseMethods.driver.navigate().to("http://" + GlobalVariables.iPOSServer + "/iPOS/Web/Login.aspx"); 
	}
	
	@AfterMethod
	public void AfterMethod() throws Exception {
		 
		driver.quit();		
      
	}
	
	@AfterClass
	public void AfterClass() throws Exception {	 
	
       extent.flush();    
       //  terminates extent and clears the underlying stream
        extent.close();
	}
	
	@Test

 public  void test1() throws InterruptedException, IOException { //throws InterruptedException {
	 ExtentTest test = extent.startTest("Test 1", "Login by RH");			
	 LoginPage page = PageFactory.initElements(driver, LoginPage.class);
	 // enter user name in text box
	 test.log(LogStatus.INFO, "User name", "Entering user name in user name field");     
     BaseMethods.KeyInElement(page.UserNameText, "rh");   
     test.log(LogStatus.INFO, "Password", "Entering password in password field");
     BaseMethods.KeyInElement(page.PasswordText, "rh1"); 
     test.log(LogStatus.WARNING, "click on login button", "clicking  on login button");
     BaseMethods.ClickElement(page.LoginButton);
     Thread.sleep(2000);
     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(screenshotFile, new File("C:\\Screenshots\\Test1_CP1.png"));     
     Thread.sleep(2000);
     test.log(LogStatus.INFO, "Snapshot below: "+ test.addScreenCapture("C:\\Screenshots\\Test1.png"));  
     Thread.sleep(2000);
     test.log(LogStatus.INFO, "VideoCapute below: "+ test.addScreencast("C:\\Work\\VideoCapture\\301014_1150.wmv"));
     Thread.sleep(3000);
     System.out.println("User name and password entered successfully");   
//     test.log(LogStatus.ERROR, "testing error ", "error log");
//     test.log(LogStatus.ERROR, "testing error ", "error log");
     test.log(LogStatus.PASS, "StepName", "PASS Details");
     extent.endTest(test);
//     BaseMethods.SwitchFrame(driver,"topFrame");            
//     BaseMethods.ClickElement(page.Create);           
//     BaseMethods.SwitchFrame(driver,"mainFrame");
//     TableUtilities.TableToXML(driver,"Raised By");
     
//     System.out.println("\t" + TableUtilities.GetTable("Created Date").getAttribute("class"));
//     WebElement AddItem=BaseMethods.GetElement(driver,(By.id("ibAdd")));
//     BaseMethods.ClickElement(AddItem);
////     hardAssert.assertTrue(false);
//     softAssert.assertTrue(false);;
//     
//	 BaseMethods.SwitchWindow(driver,"Req Creation", 2);	
//     BaseMethods.SwitchFrame(driver,"REQAddLineBody");
//     BaseMethods.ClickElement(page.ItemCode_mag);   
//	 BaseMethods.SwitchWindow(driver,"SelectionItem", 3);
//     BaseMethods.KeyInElement(BaseMethods.GetElement( driver,By.id("xgvItems_DXFREditorcol0_I")), "CFEE1");
// 	Thread.sleep(2000);
//     WebElement caption = BaseMethods.GetElement(driver,By.xpath("//td[contains(text(),'CFEE1')]"));
//     BaseMethods.DoubleClickElement(caption);// driver.FindElement(By.Id("xgvItems_DXDataRow0")));
//     BaseMethods.SwitchWindow(driver,"Req Creation", 2);      
//     BaseMethods.SwitchFrame(driver,"REQAddLineBody");
//     BaseMethods.WaitForElement(driver,By.xpath("//span[contains(text(),'Item Code')]"), 3);
//     BaseMethods.ClickElement(page.Supplier_mag);   
//	 BaseMethods.SwitchWindow(driver,"Approved Suppliers", 3);	
////	 Thread.sleep(5000);
//     BaseMethods.KeyInElement(BaseMethods.GetElement(driver,By.id("xgvSuppliers_DXFREditorcol0_I")), "81006");     //xgvSuppliers_DXFREditorcol0_I
//	Thread.sleep(2000);	
//     WebElement datacell = BaseMethods.GetElement(driver,By.xpath("//td[contains(text(),'81006')]"));     
//     BaseMethods.DoubleClickElement(datacell);
//     BaseMethods.SwitchWindow(driver,"Req Creation", 2);
//     BaseMethods.SwitchFrame(driver,"REQAddLineBody");  

//     //SelectContract
//     WebElement co_img = BaseMethods.GetElement(driver,By.id("SelectContract"));   
//     BaseMethods.ClickElement(co_img);
//    TableUtilities.TableToXML(driver,"Raised By");
//     System.out.println("\t" + TableUtilities.GetTable(driver,"Created Date").getAttribute("class"));
     //BaseMethods.TakeScreenShot();
//     softAssert.assertAll();
		 
	}	   
	
	@Test
	 public void test2() throws InterruptedException, IOException { //throws InterruptedException {		
		ExtentTest test = extent.startTest("Test 2", "Login by SS");		
		 LoginPage page = PageFactory.initElements(driver, LoginPage.class);	
	     BaseMethods.KeyInElement(page.UserNameText, "ss");            
	     BaseMethods.KeyInElement(page.PasswordText, "ss1");           
	     BaseMethods.ClickElement(page.LoginButton);
	     System.out.println("User name and password entered successfully");    
	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile, new File("C:\\Screenshots\\Test2_CP1.png"));
		 Thread.sleep(2000);
		test.log(LogStatus.INFO, "Snapshot below: "+ test.addScreenCapture("C:\\Screenshots\\Test2_CP1.png"));   	     
	     Thread.sleep(2000); 
//	    extent.(LogStatus.PASS, "Snapshot below: " ,"./Test2_CP1.png","C:\\Screenshots\\Test2_CP1.png"); 
	    
	     extent.endTest(test);
//	     BaseMethods.SwitchFrame("mainFrame");;
//	     BaseMethods.SwitchFrame("topFrame");            
//	     BaseMethods.ClickElement(page.Create);           
//	     BaseMethods.SwitchFrame("mainFrame");
//	     BaseMethods.WaitForElement(By.id("ibAdd"), 10);
//	     BaseMethods.ClickElement(page.AddItem);
//	    
//		 BaseMethods.SwitchWindow("Req Creation", 2);	
//	     BaseMethods.SwitchFrame("REQAddLineBody");
//	     BaseMethods.ClickElement(page.ItemCode_mag);   
//		 BaseMethods.SwitchWindow("SelectionItem", 3);
//	     BaseMethods.KeyInElement(BaseMethods.FindElement( By.id("xgvItems_DXFREditorcol0_I")), "SVR2");
//	     Thread.sleep(2000);	
//	     WebElement caption = BaseMethods.FindElement(By.xpath("//td[contains(text(),'SVR2')]"));
//	     BaseMethods.DoubleClickElement(caption);// driver.FindElement(By.Id("xgvItems_DXDataRow0")));
//	     BaseMethods.SwitchWindow("Req Creation", 2);
//		
//	     BaseMethods.SwitchFrame("REQAddLineBody");
//	     BaseMethods.WaitForElement(By.xpath("//span[contains(text(),'Item Code')]"), 3);
//	     BaseMethods.ClickElement(page.Supplier_mag);   
//		 BaseMethods.SwitchWindow("Approved Suppliers", 3);	
//	     BaseMethods.KeyInElement(BaseMethods.FindElement(By.id("xgvSuppliers_DXFREditorcol0_I")), "81004");     
//		Thread.sleep(2000);	
//	     WebElement datacell = BaseMethods.FindElement(By.xpath("//td[contains(text(),'81004')]"));     
//	     BaseMethods.DoubleClickElement(datacell);
	    
			           
		}	   

}
