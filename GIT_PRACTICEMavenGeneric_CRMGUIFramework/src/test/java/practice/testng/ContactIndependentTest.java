package practice.testng;

import org.testng.annotations.Test;

public class ContactIndependentTest {
@Test
public void createContactTest()
{
	System.out.println("execute createContactTest- HDFC");
}

@Test
public void modifyContactTest()
{
	System.out.println("Execute query insert contact in DB==> ICICI");
	System.out.println("execute modifyContactTest- HDFC-- ICICI");
}

@Test
public void deleleteContactTest()
{
	System.out.println("Execute query insert contact in DB==> ICICI");
	System.out.println("execute deleleteContactTest  UPI");
}
}
