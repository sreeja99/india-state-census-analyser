package com.capgemini.statecensusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCensus {
	@CsvBindByName(column = "State")
	private String stateName;
	@CsvBindByName(column = "Population")
	private long population;
	@CsvBindByName(column = "DensityPerSqKm")
	private int density;
	@CsvBindByName(column = "AreaInKm")
	private int area;
	@Override
	public String toString() {
		return "IndiaStateCensus [stateName="+stateName+",population="+population+",area="+area+",density="+density+"]";
	}
}
