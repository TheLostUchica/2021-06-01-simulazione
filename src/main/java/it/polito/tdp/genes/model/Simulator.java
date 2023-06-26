package it.polito.tdp.genes.model;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;

import org.jgrapht.*;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.genes.model.Event.tipo;

public class Simulator {
	
	Genes g;
	int ing;
	
	Queue<Event> queue;
	Graph<Genes, DefaultWeightedEdge> grafo;
	int time;
	Model model;
	TreeMap<Genes, Integer> map;
	int fine;
	
	public Simulator(Genes g, int ing, Model model) {
		this.g = g;
		this.ing = ing;
		this.model = model;
		grafo = model.getgrafo();
		time = 1;
		queue = new PriorityQueue<>();
		fine = 36;
		map = new TreeMap<Genes, Integer>();
	}
	
	public void init() {
		for(int i = 1; i<=ing; i++) {
			queue.add(new Event(tipo.INIZIO, g, 1));
		}
		for(Genes g : this.grafo.vertexSet()) {
			map.put(g, 0);
		}
	}
	
	public void run() {
		while(!queue.isEmpty() && time<=fine) {
			process(queue.poll());
		}
	}
	
	private void process(Event e) {
		System.out.println(e.toString());
		time = e.getTime();
		
		switch(e.getTipo()) {
		
		case INIZIO:
			
			map.put(e.getG(), map.get(e.getG())+1);
			
			queue.add(new Event(tipo.FINE, e.getG(), time+1));
			
			break;
			
		case FINE:
			
			map.put(e.getG(), map.get(e.getG())-1);
			
			double d = Math.random();
			
			if(d<0.3) {
				queue.add(new Event(tipo.INIZIO, e.getG(), time));
			}else {
				
				Genes gi = this.scegli(e.getG());
				System.out.println(gi.toString());
				
				queue.add(new Event(tipo.INIZIO, gi, time));
				
			}
			
			break;
		}
	}
	
	private Genes scegli(Genes gi) {
		
		double somma = 0;
		
		for(Vicini v : model.getVicini(gi)) {
			somma +=v.getPeso();
		}
		
		double d = Math.random();
		Genes g = null;
		
		for(Vicini v : model.getVicini(gi)) {
			double cum = 0;
			double p = v.getPeso()/somma;
			cum += p;
			if(d>=cum-p && d<cum) {
				g = v.getG();
			}
		}
		
		return g;
	}
	
	public int geting() {
		return this.ing;
	}
	
	public TreeMap<Genes, Integer> mappa(){
		return this.map;
	}

}
