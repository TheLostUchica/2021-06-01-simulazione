package it.polito.tdp.genes.model;

public class Coppie {
	
	Genes g1;
	Genes g2;
	double peso;
	
	public Coppie(Genes g1, Genes g2, double peso) {
		super();
		this.g1 = g1;
		this.g2 = g2;
		if(g1.getChromosome()==g2.getChromosome()) {
			this.peso = peso*2;
		}else {
			this.peso = peso;
		}
	}

	public Genes getG1() {
		return g1;
	}

	public Genes getG2() {
		return g2;
	}

	public double getPeso() {
		return peso;
	}
	
	

}
