package org.teipir.softeng.models;

import java.util.Date;

public class Dromologio {

	private String anaxwrisi;
	private String proorismos;
	private Date wra;
	private double kanonikiTimi;
	private double foititikiTimi;

	public String getAnaxwrisi() {
		return anaxwrisi;
	}

	public void setAnaxwrisi(String anaxwrisi) {
		this.anaxwrisi = anaxwrisi;
	}
	
	public Date getWra() {
		return wra;
	}
	
	public void setWra(Date wra) {
		this.wra = wra;
	}
	
	public String getProorismos() {
		return proorismos;
	}
	
	public void setProorismos(String proorismos) {
		this.proorismos = proorismos;
	}

	public double getKanonikiTimi() {
		return kanonikiTimi;
	}

	public void setKanonikiTimi(double kanonikiTimi) {
		this.kanonikiTimi = kanonikiTimi;
	}

	public double getFoititikiTimi() {
		return foititikiTimi;
	}

	public void setFoititikiTimi(double foititikiTimi) {
		this.foititikiTimi = foititikiTimi;
	}
	
}
