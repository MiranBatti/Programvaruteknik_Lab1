package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import hig.DataCollectionBuilder;
import hig.DataSource;
import hig.DataSourceImpl;
import hig.Resolution;

public class TestDataSource {

	DataSource ds;
	DataSource ds1;
	DataSource ds2;
	DataCollectionBuilder dcb;
	
	@Before
	public void setUp() throws Exception {
		
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
	
			final LocalDate dt1 = LocalDate.parse("2014-11-23", dtf);	
			ds1 = new DataSourceImpl(dt1, 3.2);
			final LocalDate dt2 = LocalDate.parse("2014-11-24", dtf);	
			ds2 = new DataSourceImpl(dt2, 4d);
		
		
		dcb = new DataCollectionBuilder(ds1, ds2, Resolution.DAY);
		
		
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
		System.out.println(ds1.getData());
	}
	@Test
	public void testMatch(){
		
		System.out.println(dcb.getResult());
		
	}
}
