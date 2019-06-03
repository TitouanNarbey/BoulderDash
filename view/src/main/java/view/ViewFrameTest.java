package view;

import static org.junit.Assert.assertTrue;

import java.util.Observable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import entity.HelloWorld;
import entity.Map;
import view.ViewFrame;

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
		
		assert fakeview.getModel()!= model2;
		System.out.println("je sais pas");
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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void loadHelloWorld(String code) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Observable getObservable() {
			// TODO Auto-generated method stub
			return new Observable();
		}

		@Override
		public void loadMap(int code) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Map getMap() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
	}
	
	
}
