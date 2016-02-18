package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import hig.DataCollectionBuilder;
import hig.DataSource;
import hig.DataSourceImpl;
import hig.Resolution;

public class TestDataSource {

	DataSource ds;
	DataSourceImpl ds1;
	DataSourceImpl ds2;
	DataCollectionBuilder dcb;
	DateTimeFormatter dtf;

	@Before
	public void setUp() throws Exception {

			
		ds1 = new DataSourceImpl();
		
		ds2 = new DataSourceImpl();

		dcb = new DataCollectionBuilder(ds1, ds2, Resolution.QUARTER);


		


	}

//	@Test
	public void testGetName() {
		assertEquals(ds1.getName(), "Actual Name");
	}

	@Test
	public void testGetUnit() {
		//System.out.println(ds1.getUnit());
	}

	//@Test
	public void testGetData() {
		System.out.println(ds1.getData());
	}
	//@Test
	public void testMatch(){

		System.out.println(dcb.getResult());
	

	}
	@Test
	public void testSetValue(){
		ds1.setValue(LocalDate.of(2014, 12, 18), 8d);
		ds1.setValue(LocalDate.of(2014, 1, 12), 4d);
		ds1.setValue(LocalDate.of(2014, 8, 22), 1.4);
		ds1.setValue(LocalDate.of(2014, 10, 20), 7d);
		
		ds2.setValue(LocalDate.of(2014, 3, 18), 2d);
		ds2.setValue(LocalDate.of(2014, 12, 11), 1d);
		ds2.setValue(LocalDate.of(2014, 7, 12), 9d);
		ds2.setValue(LocalDate.of(2014, 12, 19), 12d);

		System.out.println(dcb.getResult());
		for(Entry<LocalDate, Double> ds : ds1.getData().entrySet()) {
			System.out.println("1 " +ds);
		
		}
		for(Entry<LocalDate, Double> ds : ds2.getData().entrySet()) {
			System.out.println("2 "+ ds);
		
		}
		

	

	}
}
