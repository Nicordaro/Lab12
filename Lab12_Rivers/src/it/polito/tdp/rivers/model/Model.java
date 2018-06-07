package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	RiversDAO dao;
	List<River> rivers;
	List<Flow> flows;

	public Model() {
		dao = new RiversDAO();
		rivers = new ArrayList<>(dao.getAllRivers());
		flows = new ArrayList<>(dao.getAllFlows());

		for (River r : rivers) {
			for (Flow f : flows) {
				if (f.getRiver().equals(r)) {
					r.getFlows().add(f);
					f.setRiver(r);
				}
			}
		}
	}

	public List<River> getAllRivers() {

		return rivers;
	}

	public LocalDate getFirstDate(River river) {
		List<LocalDate> dates = dao.getDates(river);
		Collections.sort(dates);
		return dates.get(0);
	}

	public LocalDate getLastDate(River river) {
		List<LocalDate> dates = dao.getDates(river);
		Collections.sort(dates);
		return dates.get(dates.size() - 1);
	}

	public double getAvgFlow(River river) {
		int numMeas = river.getFlows().size();
		double sum = 0;
		for (Flow f : river.getFlows()) {
			sum += f.getFlow();
		}
		Double Avg = sum / numMeas;
		river.setFlowAvg(Avg);
		return river.getFlowAvg();
	}

}
