package Utilities;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.xerces.impl.xpath.XPath;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Node;



//Write Selenium Web Driver Test Result To XML File
//
//
//In some cases, test engineers need to export or save Selenium WebDriver test result in XML file format.  In this example below, I will explain how to write test results as a xml file. 
//
//in this example, the test result is written as a file named "TestResult.xml". 
//
//Login Test Case:
//
//1. Go to http://www.seleniummaster.com/seleniummastertestapp/index.php
//2. Enter "test" in the Username field
//3. Enter "XXXX" in the Password filed
//4. Click on the Login button
//5. Verify that the text "Selenium Test" is present.
//
//Step 1: on Eclipse, create a Java Project called SeleniumMasterLoginTestXmlExport. Add a package named com.seleniummaster.testresultXmlproject and then add three classes as listed below:
//•LoginTest class (this is a TestNG class)
//•TestCases class (this class has object definition for test cases like test case id, test case name and test case status
//•TestResultXmlUtility class (this class creates xml file)
	

	
	//	Step 2: write the code in the TestCases.java class

	

	
//	Step 3: write the following code in the TestResultXmlUtility.java class







	public class XMLUtilities {
	  
	private static DocumentBuilderFactory factory;
	private static DocumentBuilder builder;
	private static Document doc;
	  /**
	   * @param args
	   * @throws ParserConfigurationException 
	   */
	  public void WriteToXml() throws ParserConfigurationException {
	  Date timeStamp = new Date();
	    try{
	  //define an empty document
	     factory = DocumentBuilderFactory.newInstance();
	    builder = factory.newDocumentBuilder();
	    doc = builder.newDocument();
	    //root element
	    Element testReportElement=doc.createElement("TestReport");
	    testReportElement.setAttribute("time", timeStamp.toString());
	    doc.appendChild(testReportElement);
	    //Test Cases Element
	    Element testCasesElement=doc.createElement("TestCases");
	    testReportElement.appendChild(testCasesElement);
	    //For each test case object add a Test Case Element in the xml file
	   
	    Element Row0=doc.createElement("Row0");
	    testReportElement.appendChild(Row0);
//	    testCaseElement.setAttribute("id", "1");
//	    testCasesElement.appendChild(testCaseElement);
//	    // Name element
	    Element Col0 = doc.createElement("Col0");
	    Row0.appendChild(Col0);
	    Col0.appendChild(doc.createTextNode("Requisition Number"));
	    
	    
//	    testCasesElement.appendChild(name);
	    // Test Result  element
//	    Element testResult = doc.createElement("TestResult");
//	    testResult.appendChild(doc.createTextNode(a.getTestCaseResultStatus()));
//	    testCasesElement.appendChild(testResult);
	  
	    // write the content into xml file
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	          transformer.setOutputProperty(OutputKeys.METHOD,"xml");
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("C:\\TEMP\\TESTJAVA.xml"));
	     
	        // Output to console for testing
	        // StreamResult result = new StreamResult(System.out);
	     
	        transformer.transform(source, result);
	     
	        System.out.println("File saved!");
	     
	       } catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	        } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	        }
	      }
	  
	  
	  
	  // To read from XML file	  

/*
 http://seleniummaster.com/sitecontent/index.php/java-tutorial/java-xml/289-read-xml-file-in-java
 
  Read XML File in Java
In Java, using DocumentBuilderFactory, DocumentBuilder,XpathFactory and Xpath, you can read a xml document. In this example below, we read the "Name" tag under the "Test" node with attribute id. See the example below. 
	
	   <?xml version="1.0" encoding="UTF-8" standalone="no"?>
	  <TestCases>
	    <Testid="1">
	      <Name>Login</Name>
	      <TestModule>Login Dashboard</TestModule>
	      <TestType>Smoke Test</TestType>
	      <TestExecution>Manual</TestExecution>
	    </Test>
	  </TestCases> 
	  
	  */
	   
	 // ReadXmlFile.java (write the code below)
	  
/*	  package com.example.xml;
	  import javax.xml.parsers.DocumentBuilder;
	  import javax.xml.parsers.DocumentBuilderFactory;
	  import javax.xml.parsers.ParserConfigurationException;
	  import java.io.File;
	  import java.io.IOException;
	  import javax.xml.xpath.XPath;
	  import javax.xml.xpath.XPathConstants;
	  import javax.xml.xpath.XPathExpressionException;
	  import javax.xml.xpath.XPathFactory;
	  import org.w3c.dom.Document;
	  import org.w3c.dom.Node;
	  import org.xml.sax.SAXException;

*/
	
	  public static void main(String[] args)
	    {
	        System.out.println(ReadFile("TestCases.xml","1"));
	    }

	            public static String ReadFile(String fileName,String id)
	        {

	                String testinput = null;
	                String projectPath=System.getProperty("user.dir");
	                System.out.println(projectPath);
	                File fXmlFile = new File(projectPath+File.separator+fileName);
	                System.out.println(fXmlFile);
	                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = null;
	            try {
	                dBuilder = dbFactory.newDocumentBuilder();
	            } catch (ParserConfigurationException e) {
	                e.printStackTrace();
	            }
	            Document doc= null;
	            try {
	                doc = dBuilder.parse(fXmlFile);
	            } catch (SAXException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	                javax.xml.xpath.XPath xPath =  XPathFactory.newInstance().newXPath();
	                String expression = String.format("/TestCases/Test[@id='"+id+"']/Name");
	                System.out.println(expression);
	            Node node = null;
	            try {
	                node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
	            } catch (XPathExpressionException e) {
	                e.printStackTrace();
	            }
	            testinput = node != null ? (node.getTextContent()) : "cannot read the test case xml file";
	                return testinput;
	                
	             
	                
	                // testing git 2
	                
	                //testing git 3

	        }

	  }

	 
	
	



