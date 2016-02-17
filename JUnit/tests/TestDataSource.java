package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import hig.DataCollectionBuilder;
import hig.DataSource;
import hig.DataSourceImpl;
import hig.Resolution;

public class TestDataSource {

	DataSource ds;
	DataSourceImpl dataSourceA;
	DataSourceImpl dataSourceB;
	DataCollectionBuilder dataBuilder;
	DateTimeFormatter dtf; //( ͡° ͜ʖ ͡°)

	@Before
	public void setUp() throws Exception {
		dataSourceA = new DataSourceImpl("Temperature", "C");
		dataSourceB = new DataSourceImpl("Sprint Marathon", "Km");
		dataBuilder = new DataCollectionBuilder(dataSourceA, dataSourceB, Resolution.DAY);
	}

	@Test
	public void testName() {
		assertEquals(dataSourceA.getName(), "Temperature");
		assertEquals(dataSourceB.getName(), "Sprint Marathon");
		assertEquals(dataBuilder.getTitle(), "Temperature, Sprint Marathon");
	}

	@Test
	public void testGetUnit() {
		//System.out.println(ds1.getUnit());
		assertEquals("C", dataSourceA.getUnit());
		assertEquals("Km", dataSourceB.getUnit());
	}

	//@Test
	public void testGetData() {
		Map<LocalDate, Double> map = ds.getData();
		
		dataSourceA.setValue(LocalDate.of(2015, 01, 02), Double.MAX_VALUE);
		dataSourceA.setValue(LocalDate.of(2016, 11, 24), Double.MIN_VALUE);
		
		dataSourceB.setValue(LocalDate.of(1777, 07, 07), 0d);
		dataSourceB.setValue(LocalDate.of(2013, 2, 23), -7.7);
		dataSourceB.setValue(LocalDate.of(2014, 8, 8), 6d);
		
		assertEquals(0d, map.get(LocalDate.of(1777, 07, 07)), 0d);
		assertEquals(-7.7, map.get(LocalDate.of(2013, 2, 23)), 0d);
		assertEquals(6d, map.get(LocalDate.of(2014, 8, 8)), 0d);
		assertEquals(Double.MAX_VALUE, map.get(LocalDate.of(2015, 01, 02)), 0d);
		assertEquals(Double.MIN_VALUE, map.get(LocalDate.of(2016, 11, 24)), 0d);
	}
	
	//@Test
	public void testMatch(){
		dataSourceA.setValue(LocalDate.of(2014, 11, 18), 8d);
		dataSourceB.setValue(LocalDate.of(2014, 11, 03), 2d);
		System.out.println(dataBuilder.getResult());
	}
	
	@Test
	public void testSetValue(){
		dataSourceA.setValue(LocalDate.of(2014, 11, 18), 8d);
		dataSourceA.setValue(LocalDate.of(2014, 11, 12), 4d);
		dataSourceA.setValue(LocalDate.of(2014, 10, 22), 1.4);
		dataSourceA.setValue(LocalDate.of(2014, 11, 20), 7d);
		
		dataSourceB.setValue(LocalDate.of(2014, 11, 03), 2d);
		dataSourceB.setValue(LocalDate.of(2014, 11, 11), 1d);
		dataSourceB.setValue(LocalDate.of(2014, 11, 12), 9d);
		dataSourceB.setValue(LocalDate.of(2014, 11, 05), 12d);
		
		System.out.println(dataBuilder.getResult());
		
		for(Entry<LocalDate, Double> ds : dataSourceA.getData().entrySet()) {
			System.out.println("ds1 " + ds.getValue());
		}
		for(Entry<LocalDate, Double> ds : dataSourceB.getData().entrySet()) {
			System.out.println("ds2 " + ds.getValue());
		}
	}
	
//	@Test
	public void testWeek() {
		dataSourceA.setValue(LocalDate.of(2016, 1, 4), 3d);
		assertEquals("2016-W1", dataSourceA.getName());
	}
}
