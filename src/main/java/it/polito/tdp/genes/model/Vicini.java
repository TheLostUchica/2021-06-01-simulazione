package it.polito.tdp.genes.model;

public class Vicini implements Comparable<Vicini>{
	
	Genes g;
	double peso;
	
	public Vicini(Genes g, double peso) {
		super();
		this.g = g;
		this.peso = peso;
	}
	
	public Genes getG() {
		return g;
	}
	public double getPeso() {
		return peso;
	}
	@Override
	public int compareTo(Vicini o) {
		return (int)(o.getPeso()-this.getPeso());
	}

	@Override
	public String toString() {
		return "Vicini [g=" + g.toString() + ", peso=" + peso + "]";
	}
	
	
	
	

}
