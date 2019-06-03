package entity;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	
	}
	
//From Github
	@Test
	public void testGetWidth() {
		 try {
		Map t = new Map(40,56);
		t.getEntity(300,300);
		 }
		 
		 catch(Exception e) {
			 System.out.println("Error, Out of bound exception.");
		 }
		
	

		 
		 } 
	@Test
    public void testSize() 
	{
         
		Map t = new Map(40,56);
		t.setHeight(-3);
		
		assert t.getHeight()>=1;
		assert t.getWidth()>=1;
	}
}
