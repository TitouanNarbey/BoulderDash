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
		
	
//	public void testGetWidth() {
		
//		Random r = new Random();
//		int low = 1;
//		int high = 199;
//		int expected = r.nextInt(high-low) + low;
//		
//		Map t = new Map(200,1);
//		Map tp = new Map(1,200);
//		
//		assertEquals$(expected, Map.getWidth(t));
////		 assertFalse("La map est trop grande", Map.getWidth());
		 
		 } 

}
