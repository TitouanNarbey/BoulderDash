package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MapTest {

	
	boolean IsOutOfBound;
	int id;
	MapTest border;
	
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
		fail("Not yet implemented");
	}

	
	@Test
	public void borderExists() {
//		int expected = id;
//		assertEquals(expected, border.id);
//		System.out.println("Border does exists.");
	}
	
	@Test
	public void testGetWidth() {
		 try {
		Map t = new Map(40,56);
		t.getEntity(300,300);
		 }
		 
		 catch(Exception e) {
			 System.out.println("Error, Out of bound exception.");
		 }
		
		
		
		
//        int width = 56;
//        int high = 40;
//     
//        Map t = new Map(56,40);
//
//        public 
//        assertEquals(expected, Map.getWidth(t));
////         assertFalse("La map est trop grande", Map.getWidth());

         }

         }
	
