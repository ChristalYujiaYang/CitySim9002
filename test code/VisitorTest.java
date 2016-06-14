
import org.junit.Assert;
import org.junit.Test;


public class VisitorTest {

	@Test
	public void testGetNum1() {
		Visitor v = new Visitor(); 
		v.num=1;
        Assert.assertEquals(1, v.getNum());  
	}
	
	@Test
	public void testGetNum2() {
		Visitor v = new Visitor(); 
		v.num=5;
        Assert.assertEquals(5, v.getNum());  
	}

	@Test
	public void testGetIdentify1() {
		Visitor v = new Visitor(); 
		v.identify="Student";
        Assert.assertEquals("Student", v.getIdentify()); 
	}

	@Test
	public void testGetIdentify2() {
		Visitor v = new Visitor(); 
		v.identify="Blogger";
        Assert.assertEquals("Blogger", v.getIdentify()); 
	}
}
