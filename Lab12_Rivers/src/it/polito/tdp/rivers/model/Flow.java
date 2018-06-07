package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Flow implements Comparator<LocalDate> {
	private LocalDate day;
	private double flow;
	private River river;

	public Flow(LocalDate day, double flow, River river) {
		this.day = day;
		this.flow = flow;
		this.river = river;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	@Override
	public String toString() {
		return "Flow [day=" + day + ", flow=" + flow + ", river=" + river + "]";
	}

	public River getRiver() {
		return river;
	}

	public void setRiver(River river) {
		this.river = river;
	}

	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		return o1.compareTo(o2);
	}

}
