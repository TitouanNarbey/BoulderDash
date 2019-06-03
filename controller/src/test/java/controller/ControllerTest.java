package controller;

import static org.junit.Assert.*;

import java.util.Observable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import contract.IModel;
import contract.IView;
import entity.Direction;
import entity.HelloWorld;
import entity.Map;

public class ControllerTest {


	private static IModel model2;
	private static IView view2;

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

//	@Test
//	public void testController() {
//		try {
//
//			model2.getMap().setNextPlayerDirection(Direction.TOP);
//		}catch (Exception e) {
//			if(e != null)
//			{
//				fail(" : ControllerTest#orderPerform() is not ok.");
//			}
//
//		}
//		int expected = 1;
//		assertEquals(expected, 1);
//	}

	@Test
	public void testControl() {

	}

//	@Test
//	public void testOrderPerform() {
//		Controller fakecontroller = new Controller(view2, model2);
//
//		try {
//
//			fakecontroller.orderPerform(ControllerOrder.Z);
//		}
//		catch (Exception e) {
//			if(e != null)
//			{
//				fail(" : ControllerTest#orderPerform() is not ok.");
//			}
//		}
//		int expected = 1;
//		assertEquals(expected, 1);
//	}

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

		class FakeView implements IView{

			@Override
			public void printMessage(String message) {
				// TODO Auto-generated method stub

			}

		}
	}
}
