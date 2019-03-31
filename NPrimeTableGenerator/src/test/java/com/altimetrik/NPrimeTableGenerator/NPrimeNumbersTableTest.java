package com.altimetrik.NPrimeTableGenerator;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NPrimeNumbersTableTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	public void test() {
		NPrimeNumbersTable.main(new String[] { "2" });
		assertEquals("******************************************************\n"+
				     "***** Welcome to Prime numbers table generator *****\n"+
				     "******************************************************\n"+
				     "OK you want prime number table for 2 prime numbers.\n"+
				     "2      | 3      | \n"+
				     "4      | 6      | \n"+
				     "6      | 9      | \n"+
				     "8      | 12     | \n"+
				     "10     | 15     | \n"+
				     "12     | 18     | \n"+
				     "14     | 21     | \n"+
				     "16     | 24     | \n"+
				     "18     | 27     | \n"+
				     "20     | 30     | \n", 
				     outContent.toString());
	}
	
	@Test
	public void testNegativeTableSize() {
		NPrimeNumbersTable.main(new String[] { "-2" });
		assertEquals("******************************************************\n"+
				     "***** Welcome to Prime numbers table generator *****\n"+
				     "******************************************************\n"+
				     "OK you want prime number table for -2 prime numbers.\n"+
				     "Table size should be greater than 0\n", 
				     outContent.toString());
	}
	
	@Test
	public void testForTenPrimeNumbers() {
		NPrimeNumbersTable.main(new String[] { "10" });
		assertEquals("******************************************************\n"+
				     "***** Welcome to Prime numbers table generator *****\n"+
				     "******************************************************\n"+
				     "OK you want prime number table for 10 prime numbers.\n"+
				     "2      | 3      | 5      | 7      | 11     | 13     | 17     | 19     | 23     | 29     | \n"+
				     "4      | 6      | 10     | 14     | 22     | 26     | 34     | 38     | 46     | 58     | \n"+
				     "6      | 9      | 15     | 21     | 33     | 39     | 51     | 57     | 69     | 87     | \n"+
				     "8      | 12     | 20     | 28     | 44     | 52     | 68     | 76     | 92     | 116    | \n"+
				     "10     | 15     | 25     | 35     | 55     | 65     | 85     | 95     | 115    | 145    | \n"+
				     "12     | 18     | 30     | 42     | 66     | 78     | 102    | 114    | 138    | 174    | \n"+
				     "14     | 21     | 35     | 49     | 77     | 91     | 119    | 133    | 161    | 203    | \n"+
				     "16     | 24     | 40     | 56     | 88     | 104    | 136    | 152    | 184    | 232    | \n"+
				     "18     | 27     | 45     | 63     | 99     | 117    | 153    | 171    | 207    | 261    | \n"+
				     "20     | 30     | 50     | 70     | 110    | 130    | 170    | 190    | 230    | 290    | \n", 
				     outContent.toString());
	}

}
