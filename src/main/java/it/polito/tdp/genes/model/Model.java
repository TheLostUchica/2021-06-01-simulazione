package it.polito.tdp.genes.model;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.*;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;

public class Model {
	
	GenesDao dao;
	Graph<Genes, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new GenesDao();
	}
	
	public void creagrafo() {
		
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, dao.getVertex());
		
		for(Coppie c : dao.getCoppie()) {
			Graphs.addEdgeWithVertices(this.grafo, c.getG1(), c.getG2(), c.getPeso());
		}
	}
	
	public Graph<Genes, DefaultWeightedEdge> getgrafo(){
		return this.grafo;
	}
	
	public List<Vicini> getVicini(Genes gi){
		List<Vicini> V = new LinkedList<>();
		for(Genes g : Graphs.neighborListOf(this.grafo, gi)) {
			V.add(new Vicini(g, this.grafo.getEdgeWeight(this.grafo.getEdge(gi, g))));
		}
		Collections.sort(V);
		return V;
	}
	
	public Simulator sim(Genes g, int i) {
		Simulator sim = new Simulator(g, i, this);
		sim.init();
		sim.run();
		return sim;
	}
	
	
}
