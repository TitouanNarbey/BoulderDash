package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiamondTest {
	
	int id = 1;
	boolean isFalling;
	DiamondTest diamond;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		diamond = new DiamondTest();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiamond() {
		
	}

	@Test
	public void testDestroy() {
		
	}

	@Test
	public void testFall() {
		
	}

	@Test
	public void DiamondExist() {
		
		int expected = id;
		assertEquals(expected, diamond.id);
		System.out.println("Diamond Exist");
		
	}

	@Test
	public void testIsFalling() {
		
		diamond = new DiamondTest();
		assertFalse(diamond.isFalling);
		System.out.println("The diamond is falling.");
		
	}

}
