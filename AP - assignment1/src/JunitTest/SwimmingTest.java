package JunitTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Swimming;

public class SwimmingTest {

	Swimming s = new Swimming(null, null, null);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testComputeTime() {
		s.computeTime();
		assertTrue(s.computeTime() > 0 && s.computeTime() <= 200);
	}

}
