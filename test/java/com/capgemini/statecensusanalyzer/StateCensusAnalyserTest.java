package com.capgemini.statecensusanalyzer;
import com.capgemini.statecensusanalyzer.CensusAnalyserException;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import com.capgemini.statecensusanalyzer.CensusAnalyserException;
public class StateCensusAnalyserTest {
	private static final String CENSUS_DATA_PATH ="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusData.csv";
	private static final String CENSUS_DATA_PATH_Invalid_Delimiter="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusDataInvalidDelimiter.csv"; 
	private static final String CENSUS_DATA_PATH_Invalid_Header="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusDataInvalidHeader.csv";
	private static final String STATE_CODE_PATH="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCode.csv";
	private static final String STATE_CODE_PATH_Invalid_Header="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCodeInvalidHeader.csv";
	private static final String STATE_CODE_PATH_Invalid_Delimiter="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCodeInvalidDelimiter.csv";
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
	@Test
	public void givenCodeCSVFile_ReturnsCorrectNoOfEntries() throws CodeAnalyserException, IOException {
		int noOfEntries = stateCensusAnalyser.loadCodeData(STATE_CODE_PATH);
		assertEquals(37, noOfEntries);
	}
	@Test 
	public void givenIncorrectStateCodeCSVClassType_ThrowsCodeAnalyserExceptionOfTypeInvalidClassType() {
		try {
			stateCensusAnalyser.loadCodeData(STATE_CODE_PATH);
		} catch (CodeAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CodeAnalyserException.ExceptionType.INVALID_CLASS_TYPE, e.type);
		}
	}
	@Test 
	public void givenIncorrectStateCodeCSVDelimiter_ThrowsCodeAnalyserExceptionOfTypeInvalidDelimiter() throws IOException {
		try {
			stateCensusAnalyser.loadCodeData(STATE_CODE_PATH_Invalid_Delimiter);
		} catch (CodeAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CodeAnalyserException.ExceptionType.INVALID_DELIMITER, e.type);
		}
	}
	
	@Test
	public void givenIncorrectStateCodeCSVHeader_ThrowsCodeAnalyserExceptionOfTypeInvalidHeader() throws IOException{
		try {
			System.out.println(stateCensusAnalyser.loadCodeData(STATE_CODE_PATH_Invalid_Header));
		} catch (CodeAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CodeAnalyserException.ExceptionType.INVALID_HEADER, e.type);
		}
	}

}
