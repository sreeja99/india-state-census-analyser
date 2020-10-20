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
	public int loadCensusData(String CensusDatePath) throws CensusAnalyserException {
		try {
		Reader reader =Files.newBufferedReader(Paths.get(CensusDatePath));
		CsvToBeanBuilder<IndiaStateCensus> csvToBeanBuilder= new CsvToBeanBuilder<IndiaStateCensus>(reader);
		try {
			csvToBeanBuilder.withType(IndiaStateCensus.class);
		}
		catch(IllegalStateException e) {
			throw new CensusAnalyserException("Wrong class type", ExceptionType.INVALID_CLASS_TYPE);
		}
		csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
		CsvToBean<IndiaStateCensus> csvToBean=csvToBeanBuilder.build();
		BufferedReader br=new BufferedReader(new FileReader(CensusDatePath));
		String  line="";
		int ctr=0;
		while((line=br.readLine())!=null){
			if(!(line.contains(",")))
				throw new CensusAnalyserException("Invalid Delimiter", ExceptionType.INVALID_DELIMITER);
			if(ctr==0) {
				String[] headers=line.split(",");
				if(!(headers[0].equals("State")&&headers[1].equals("Population")&&headers[2].equals("AreaInSqKm")&&headers[3].equals("DensityPerSqKm")))
        			throw new CensusAnalyserException("Invalid headers", ExceptionType.INVALID_HEADER);
        		ctr++;
			}
			
		}
		br.close();
		Iterator<IndiaStateCensus> censusIterator= csvToBean.iterator();
		int numOfEntries=0;
		while(censusIterator.hasNext()) {
			numOfEntries++;
			IndiaStateCensus censusData=censusIterator.next();
			System.out.println(censusData);
		}
		return numOfEntries;
		}
		catch(IOException e) {
			throw new CensusAnalyserException("Invalid file location", ExceptionType.INVALID_FILE_PATH);
		}
		
	}
}
