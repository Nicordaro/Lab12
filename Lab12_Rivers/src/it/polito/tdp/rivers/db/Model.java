package it.polito.tdp.rivers.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;

public class Model {
	private RiversDAO rdao;
	private List<LocalDate> dates;
	private List<Flow> flows;

	public Model() {
		rdao = new RiversDAO();
		dates = new ArrayList<>();
		flows = new ArrayList<>();
	}

	public List<River> getAllRivers() {
		return rdao.getAllRivers();
	}

	public void initializeDates(River river) {
		dates.clear();
		dates.addAll(rdao.getDates(river));
		Collections.sort(dates);
	}

	public LocalDate getFirstDate(River river) {
		return dates.get(0);
	}

	public LocalDate getLastDate(River river) {
		return dates.get(dates.size() - 1);
	}

	public List<LocalDate> getDates() {
		return dates;
	}

	public void initializeFlows(River river) {
		flows.clear();
		flows.addAll(rdao.getFlows(river));
	}

	public double getAvgFlow(River river) {
		double sum = 0;
		for (Flow f : this.flows) {
			sum += f.getFlow();
		}

		return sum / this.dates.size();

	}

	public void addMedia() {
		for (River r : this.getAllRivers()) {
			r.setFlowAvg(this.getAvgFlow(r));
		}
	}

}
