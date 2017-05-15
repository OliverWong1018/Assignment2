package JunitTest;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Cycling;

public class CyclingTest {

	Cycling c = new Cycling(null, null, null);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// one-time initialization code
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// one-time cleanup code
	}

	@Test
	public void testComputeTime() {
		c.computeTime();
		assertTrue(c.computeTime() > 0 && c.computeTime() <= 800);
	}

}
