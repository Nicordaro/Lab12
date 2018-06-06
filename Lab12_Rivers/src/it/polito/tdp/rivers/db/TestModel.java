package it.polito.tdp.rivers.db;

import it.polito.tdp.rivers.model.River;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		RiversDAO rdao = new RiversDAO();
		River river = rdao.getAllRivers().get(0);
		model.initializeDates(river);
		model.initializeFlows(river);
		//
		// System.out.println(model.getFirstDate(river));
		// System.out.println(model.getLastDate(river));
		// System.out.println(model.getDates().size());
		//
		// System.out.println(model.getAvgFlow(river));
		for (River r : rdao.getAllRivers()) {
			model.initializeFlows(r);
			System.out.println(r.getFlowAvg());
		}
	}

}
