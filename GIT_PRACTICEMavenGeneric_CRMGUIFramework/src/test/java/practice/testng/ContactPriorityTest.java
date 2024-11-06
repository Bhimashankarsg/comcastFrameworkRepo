package practice.testng;

import org.testng.annotations.Test;
public class ContactPriorityTest {
@Test(priority=-10)
public void createContactTest()
{
	
	
	System.out.println("execute createContactTest- HDFC");
}

@Test(priority=2)
public void modifyContactTest()
{
	System.out.println("execute modifyContactTest- HDFC-- ICICI");
}

@Test(priority=-3)
public void deleleteContactTest()
{
	System.out.println("execute deleleteContactTest  ICICI");
}
}
