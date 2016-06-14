import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CitySim9002Test {

	@Mock
	Visitor mockedVisitor = Mockito.mock(Visitor.class);
	CitySim9002 mockedCitySim = Mockito.mock(CitySim9002.class);
	
	@Before
	public void setUp() throws Exception {
		// If you use @Mock, you need to do this
		MockitoAnnotations.initMocks(mockedVisitor);
		MockitoAnnotations.initMocks(mockedCitySim);
		
	}

	@After
	public void tearDown() throws Exception {
		// any necessary teardown - none needed here
	}	
	
	// test checkInteger method
	//find out whether this method will give true when input is an integer
	@Test
	public void testCheckInteger1() {
		String a="1";
		CitySim9002 input=new CitySim9002();
		assertTrue(input.checkInteger(a));
	}
	
	// test checkInteger method
	//find out whether this method will give false when input is not an integer
	@Test
	public void testCheckInteger2() {
		String a="a";
		CitySim9002 input=new CitySim9002();
		assertFalse(input.checkInteger(a));
	}
	
	// test checkInteger method
	//find out whether this method will give false when inputs are two integers
	//or there are non-integers in the input
	@Test
	public void testCheckInteger3() {
		String a="2 4";
		CitySim9002 input=new CitySim9002();
		assertFalse(input.checkInteger(a));
	}

	//test LikeOrNot method
	//this method should return false if any visitor is going to left the city
	//there is no need to test whether visitor class is correct or not
	//as a result, we could mock visitor class and use mockedVisitor instead
	@Test
	public void testLikeOrNot1() {
		CitySim9002 likeness=new CitySim9002();
		assertFalse(likeness.likeOrNot(mockedVisitor, "left the city"));
	}

	//test LikeOrNot method
	//if the visitor is a student and he or she is going to The Cathedral of Learning
	//this method should return false
	//we do not want to test setIdentify or getIdentify method is this unit test
	//so we could use stub to make the visitor to be a student
	@Test
	public void testLikeOrNot2() {
		CitySim9002 likeness=new CitySim9002();
		Visitor a=new Visitor();
		Mockito.when(a.getIdentify()).thenReturn("Student");
		assertFalse(likeness.likeOrNot(a, "The Cathedral of Learning"));
	}
	
	//test LikeOrNot method
	//if the visitor is a professor, he or she should like Squirrel Hill
	//as a result, we set the visitor as a professor and this method should return true
	@Test
	public void testLikeOrNot3() {
		CitySim9002 likeness=new CitySim9002();
		Visitor a=new Visitor();
		a.setIdentify("Professor");
		assertTrue(likeness.likeOrNot(a, "Squirrel Hill"));
	}
	
	//test print method
	//if the visitor is a student and he or she is going to The Cathedral of Learning
	//this method should print out this visitor did not like the place
	//there is no need to test setIdentify and getIdentify method as well as visitor class
	//so we use stub method and mockedVisitor in the test
	@Test
	public void testPrint1() {
		CitySim9002 print=new CitySim9002();
		Mockito.when(mockedVisitor.getIdentify()).thenReturn("Student");
		assertEquals(print.print(mockedVisitor,null,"The Cathedral of Learning"), "Visitor "+mockedVisitor.getNum()+" did not like The Cathedral of Learning.");
	}

	//test print method
	//if the visitor is a Professor and he or she is going to The Point
	//this method should print out this visitor did like the place
	//there is no need to test setIdentify and getIdentify method as well as visitor class
	//so we use stub method and mockedVisitor in the test
	@Test
	public void testPrint2() {
		CitySim9002 print=new CitySim9002();
		Mockito.when(mockedVisitor.getIdentify()).thenReturn("Professor");
		assertEquals(print.print(mockedVisitor,null,"The Point"), "Visitor "+mockedVisitor.getNum()+" did like The Point.");
	}
	
	//test print method
	//if the visitor did not like the place, the method should print out did not like that place
	//in this test, we do not care about what is the identity of the visitor and where he or she is going to
	//so we mocked the visitor and use stub method to give false no matter what will give by the likeOrNot method
	@Test
	public void testPrint3() {
		CitySim9002 print=new CitySim9002();
		Mockito.when(mockedVisitor.getNum()).thenReturn(1);
		Mockito.when(mockedCitySim.likeOrNot(mockedVisitor, null)).thenReturn(false);
		assertEquals(print.print(mockedVisitor,null,"The Cathedral of Learning"), "Visitor "+mockedVisitor.getNum()+" did not like The Cathedral of Learning.");
	}
	
}
