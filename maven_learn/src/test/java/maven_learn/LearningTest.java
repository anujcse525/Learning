package maven_learn;

import org.junit.Assert;
import org.junit.Test;

import com.anuj.Learning;

import junit.framework.TestCase;

public class LearningTest extends TestCase {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testReturnString() {
		Learning learn = new Learning();
		Assert.assertTrue(learn.returnString().equalsIgnoreCase("hello"));
	}
}
