package view;

import static org.junit.Assert.assertNotNull;

import java.util.Observable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import entity.HelloWorld;
import entity.Map;

public class ViewFrameTest {
	
	boolean GetModel;
	ViewFrameTest test;
	private static IModel model2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		model2 = new FakeModel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testViewFrameIModel() {
		
	}

	@Test
	public void testViewFrameIModelGraphicsConfiguration() {
		
	}

	@Test
	public void testViewFrameIModelString() {
		
	}

	@Test
	public void testViewFrameIModelStringGraphicsConfiguration() {
		
	}

	@Test
	public void testSetController() {
		
	}

	@Test
	public void testGetModel() {
		
		ViewFrame fakeview = new ViewFrame(model2);
		
		assertNotNull(fakeview.getModel());
		System.out.println(" : ViewFrameTest#testGetModel() is ok.");
		//assertTrue(model2.getMap());
		
	}

	@Test
	public void testPrintMessage() {
		
	}

	@Test
	public void testKeyTyped() {
		
	}

	@Test
	public void testKeyPressed() {
		
	}

	@Test
	public void testKeyReleased() {
		
	}

	class FakeModel implements IModel{
		
		


		@Override
		public HelloWorld getHelloWorld() {
			return null;
		}

		@Override
		public void loadHelloWorld(String code) {
			
		}

		@Override
		public Observable getObservable() {
			return new Observable();
		}

		@Override
		public void loadMap(int code) {
			
		}

		@Override
		public Map getMap() {
			return new Map();
		}
		
		
		
	}
	
	
}