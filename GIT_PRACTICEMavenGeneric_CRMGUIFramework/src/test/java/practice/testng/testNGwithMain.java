package practice.testng;

import org.testng.annotations.Test;

public class testNGwithMain {

	public void himethod()
	{
		System.out.println("hi");
	}
	public static void hellomethod()
	{
		System.out.println("hello");
	}
	@Test
	public void createContactTest()
	{
		System.out.println("execute createContactTest");
	}
	public static void main(String[] args) {
		testNGwithMain obj=new testNGwithMain();
		obj.himethod();
		hellomethod();
		

	}

}
