//Author is JINZE WANG
package JunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.CompeteResult;
import model.SortByTime;

public class SortByTimeTest {

	SortByTime s = new SortByTime();
	ArrayList<CompeteResult> c = new ArrayList<CompeteResult>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() {

		c.add(new CompeteResult(0, 50));
		c.add(new CompeteResult(0, 60));
		c.add(new CompeteResult(0, 70));

	}

	@After
	public void tearDown() {
	}

	@Test
	public void testCompare() {
		c.sort(s);
		assertTrue(c.get(0).getTime() < c.get(1).getTime() && c.get(1).getTime() < c.get(2).getTime());
	}

}
