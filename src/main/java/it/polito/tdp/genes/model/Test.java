package it.polito.tdp.genes.model;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		
		Model model = new Model();
		model.creagrafo();
		LinkedList<Genes> list = new LinkedList<>(model.getgrafo().vertexSet());
		Genes g = list.get(0);
		
		System.out.println("Creato grafo con "+model.getgrafo().vertexSet().size()+" verici e "+model.getgrafo().edgeSet().size()+" archi.\n");
		
		Simulator sim = model.sim(g, 10);
		
		

	}

}
