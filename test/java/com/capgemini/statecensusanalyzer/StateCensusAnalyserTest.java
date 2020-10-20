package com.capgemini.statecensusanalyzer;
import com.capgemini.statecensusanalyzer.CensusAnalyserException;
import static org.junit.Assert.*;

import org.junit.Test;
import com.capgemini.statecensusanalyzer.CensusAnalyserException;
public class StateCensusAnalyserTest {
	private static final String CENSUS_DATA_PATH ="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusData.csv";
	private static final String CENSUS_DATA_PATH_Invalid_Delimiter="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusDataInvalidDelimiter.csv"; 
	private static final String CENSUS_DATA_PATH_Invalid_Header="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusDataInvalidHeader.csv";
	private StateCensusAnalyser stateCensusAnalyser;
	@Test
	public void givenCsvFileReturnNumberOfEntries() throws CensusAnalyserException {
		int numOfEntries=stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH);
		assertEquals(29, numOfEntries);
	}
	@Test
	public void givenIncorrectCsvFilePathThrowCustomException() throws CensusAnalyserException {
		try {
			stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH+"123");
		}catch(CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_PATH, e.type);
		}
	}
	@Test
	public void givenIncorrectDelimiter_ThrowsCustomExceptionOfTypeInalidDelimiter(){
		try {
			System.out.println(stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH_Invalid_Delimiter));
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_DELIMITER, e.type);
		}
	}
	
	@Test
	public void givenIncorrectHeader_ThrowsCustomExceptionOfTypeInvalidHeader(){
		try {
			System.out.println(stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH_Invalid_Header));
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_HEADER, e.type);
		}
	}

}
