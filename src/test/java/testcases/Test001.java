package testcases;

import org.testng.annotations.Test;

public class Test001 extends Basetest
{
	@Test
	public void firsttest() throws InterruptedException
	{
		fp.selectlocality();
		fp.selectspecialty();
		
		sp.storyselection();
		Thread.sleep(2000);
		sp.selectexp();
		Thread.sleep(2000);
		sp.selectfees();
		Thread.sleep(5000);
		sp.selectavailability();
		Thread.sleep(3000);
		sp.selectrelevance();
		Thread.sleep(3000);
		sp.printdocname();
		
	}
	
}
