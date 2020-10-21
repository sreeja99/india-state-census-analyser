package com.capgemini.statecensusanalyzer;
import com.capgemini.statecensusanalyzer.CensusAnalyserException;

import junit.framework.Assert;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.capgemini.statecensusanalyzer.CensusAnalyserException;
public class StateCensusAnalyserTest {
	private static final String CENSUS_DATA_PATH ="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusData.csv";
	private static final String CENSUS_DATA_PATH_Invalid_Delimiter="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusDataInvalidDelimiter.csv"; 
	private static final String CENSUS_DATA_PATH_Invalid_Header="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCensusDataInvalidHeader.csv";
	private static final String STATE_CODE_PATH="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCode.csv";
	private static final String STATE_CODE_PATH_Invalid_Header="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCodeInvalidHeader.csv";
	private static final String STATE_CODE_PATH_Invalid_Delimiter="C:\\Users\\HP\\.eclipse\\org.eclipse.tips.state\\statecensusanalyzer\\src\\main\\java\\com\\capgemini\\statecensusanalyzer\\files\\IndiaStateCodeInvalidDelimiter.csv";
	private StateCensusAnalyser stateCensusAnalyser;
	@Before
	public void init() {
		stateCensusAnalyser = new StateCensusAnalyser();
	}
	@Test
	public void givenCensusCSVFile_ReturnsCorrectNoOfEntries() throws CensusAnalyserException {
		try {
    		StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
    		int numOfRecords = censusAnalyser.loadCensusData(CENSUS_DATA_PATH);
    		Assert.assertEquals(29,numOfRecords);
	} catch (CensusAnalyserException e) { 	
	}
	}
	@Test
	public void  givenIncorrectStateCSVFilePath_ThrowsCensusAnalyserException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadCensusData(CENSUS_DATA_PATH+"389748");
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_EXCEPTION, e.type);
		}
	}
	
	@Test
	public void givenIncorrectCSVClassType_ThrowsCensusAnalyserException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadCensusData(CENSUS_DATA_PATH );
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_EXCEPTION, e.type);
		}
	}
	
	@Test
	public void givenIncorrectDelimiter_ThrowsCensusAnalyserException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadCensusData(CENSUS_DATA_PATH_Invalid_Delimiter);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_EXCEPTION, e.type);
		}
	}
	
	@Test
	public void givenIncorrectHeader_ThrowsCensusAnalyserException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadCensusData(CENSUS_DATA_PATH_Invalid_Header);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_EXCEPTION, e.type);
		}
	}
	@Test
    public void  givenCodeCSVFile_ReturnsCorrectNoOfEntries() {
        try {
            StateCensusAnalyser codeAnalyser = new StateCensusAnalyser();
            int numOfRecords = codeAnalyser.loadCodeData(STATE_CODE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { 	
        }
    }
	@Test
	public void  givenIncorrectStateCodeCSVFilePath_ThrowsCodeAnalyserException() {
		try {
			StateCensusAnalyser codeAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			codeAnalyser.loadCodeData(STATE_CODE_PATH+"47287");
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CODE_FILE_EXCEPTION, e.type);
		}
	}
	@Test
	public void givenIncorrectStateCodeCSVClassType_ThrowsCodeAnalyserException() {
		try {
			StateCensusAnalyser codeAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			codeAnalyser.loadCodeData(STATE_CODE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CODE_FILE_EXCEPTION, e.type);
		}
	}
	@Test
	public void givenIncorrectDelimiter_ThrowsCodeAnalyserException() {
		try {
			StateCensusAnalyser codeAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			codeAnalyser.loadCodeData( STATE_CODE_PATH_Invalid_Delimiter);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CODE_FILE_EXCEPTION, e.type);
		}
	}
	@Test
	public void givenIncorrectHeader_ThrowsCodeAnalyserException() {
		try {
			StateCensusAnalyser codeAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			codeAnalyser.loadCodeData( STATE_CODE_PATH_Invalid_Header);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CODE_FILE_EXCEPTION, e.type);
		}
	}
}