package com.eCommerce.test;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.*;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;

public class x {

	public x() {
		// TODO Auto-generated constructor stub
	}
	@Test	
public void gg() throws XmlException, IOException, SoapUIException {	
		// 
				//	A x=new A();
			//Grab the project
		WsdlProject project=new WsdlProject("C:\\Users\\Junghwan Shin\\OneDrive\\바탕 화면\\Udemy\\soapui\\Employee.xml");
		//Grab the Test suite in the project
		WsdlTestSuite testsuite=project.getTestSuiteByName("Testing");
		
		//Grab the testcases present in test suite
		for(int i = 0; i < testsuite.getTestCaseCount(); i++)
		{
			WsdlTestCase testCase = testsuite.getTestCaseAt(i);
			//Run the testcase
			TestRunner runner = testCase.run(new PropertiesMap(), false);
			Assert.assertEquals(Status.FINISHED, runner.getStatus());
			//runner.getStatus()
		}
}	
}
