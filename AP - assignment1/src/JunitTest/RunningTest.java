package JunitTest;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Running;

public class RunningTest {

	Running r = new Running(null, null, null);

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
		r.computeTime();
		assertTrue(r.computeTime() > 0 && r.computeTime() <= 20);
	}

}
