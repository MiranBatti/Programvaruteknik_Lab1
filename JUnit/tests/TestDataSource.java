package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hig.DataSource;

public class TestDataSource {

	DataSource ds;
	
	@Before
	public void setUp() throws Exception {
		ds = new DataSourcesss();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		assertEquals(ds.getName(), "Actual Name");
	}

	@Test
	public void testGetUnit() {
		ds.getUnit();
	}
	
	@Test
	public void testGetData() {
		
	}
}
