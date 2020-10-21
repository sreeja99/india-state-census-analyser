package com.capgemini.statecensusanalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.capgemini.statecensusanalyzer.CensusAnalyserException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	public int loadCensusData(String censusDataPath) throws CensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(censusDataPath));
			CsvToBeanBuilder<IndiaStateCensus > csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaStateCensus .class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaStateCensus> censusCSVIterator = csvToBean.iterator();
			int numOfEnteries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEnteries++;
				censusCSVIterator.next();
			}
			return numOfEnteries;
		} catch(Exception e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_EXCEPTION);
		}
	}
	public int loadCodeData(String CodeDataPath) throws CensusAnalyserException{
		try {
			Reader reader = Files.newBufferedReader(Paths.get(CodeDataPath));
			CsvToBeanBuilder<CSVStates> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStates.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStates> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStates> codeCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while(codeCSVIterator.hasNext()) {
				numOfEntries++;
				codeCSVIterator.next();
			}
			return numOfEntries;
		} catch(Exception e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CODE_FILE_EXCEPTION);
		}
	}
	
}

