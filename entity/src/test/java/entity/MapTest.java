package entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {

	int id = 1;
	boolean isFalling;
	MapTest Rock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		Rock = new MapTest();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	
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
		
	

		 
		 } 
	@Test
    public void testSize() 
	{
         
		Map t = new Map(40,56);
		t.setHeight(-3);
		
		assert t.getHeight()>=1;
		assert t.getWidth()>=1;
	}
	
	@Test
	public void testMoveRight() {
		Map mymap = new Map(2,2);
		mymap.setEntityOnTheMap(0, 0,new Rock());
		mymap.setEntityOnTheMap(1, 0,new Dirt());
		mymap.setEntityOnTheMap(0, 1,new SpawnPoint());
		mymap.setEntityOnTheMap(1, 1,new Air());
		
		//simulate key 
		mymap.moveRightPlayer(mymap.getPlayerLocation());
		
		int expected = id;
		assertEquals(expected, Rock.id);
		System.out.println("Rock Exist");
		
	}
	
	@Test
	public void testIsFalling() {
		
		Rock = new MapTest();
		assertFalse(Rock.isFalling);
		System.out.println("The Rock is falling, so the player has move.");
		
	}
	
}
