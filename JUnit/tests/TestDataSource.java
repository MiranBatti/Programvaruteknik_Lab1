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

			
		ds1 = new DataSourceImpl(LocalDate.of(2014, 11, 06), 3d);
		
		ds2 = new DataSourceImpl(LocalDate.of(2014, 11, 06), 8d);

		dcb = new DataCollectionBuilder(ds1, ds2, Resolution.MONTH);


		


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
		ds1.setValue(LocalDate.of(2014, 11, 18), 8d);
		ds1.setValue(LocalDate.of(2014, 11, 12), 4d);
		ds1.setValue(LocalDate.of(2014, 11, 22), 1d);
		
		ds2.setValue(LocalDate.of(2014, 11, 03), 2d);
		ds2.setValue(LocalDate.of(2014, 11, 11), 1d);
		ds2.setValue(LocalDate.of(2014, 11, 12), 9d);
//		ds1.setValue(LocalDate.parse("2014-11-18", dtf), 7d);
//		ds1.setValue(LocalDate.parse("2014-11-22", dtf), 1d);
//		ds2.setValue(LocalDate.parse("2014-11-22", dtf), 2d);
//		ds2.setValue(LocalDate.parse("2014-11-26", dtf), 5d);

	//	System.out.println(ds2.getData());
		
		System.out.println(dcb.getResult());
		for(Entry<LocalDate, Double> ds : ds1.getData().entrySet()) {
		System.out.println("ds1 " + ds.getValue());
		}
		for(Entry<LocalDate, Double> ds : ds2.getData().entrySet()) {
		System.out.println("ds2 " + ds.getValue());
		}
		

	

	}
}
