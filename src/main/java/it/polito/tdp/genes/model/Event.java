package it.polito.tdp.genes.model;

public class Event implements Comparable<Event>{
	
	enum tipo{
		INIZIO,
		FINE
	}
	
	tipo tipo;
	Genes g;
	int time;
	
	
	public Event(it.polito.tdp.genes.model.Event.tipo tipo, Genes g, int time) {
		super();
		this.tipo = tipo;
		this.g = g;
		this.time = time;
	}

	

	public tipo getTipo() {
		return tipo;
	}



	public Genes getG() {
		return g;
	}



	public int getTime() {
		return time;
	}



	@Override
	public int compareTo(Event o) {
		return this.time-o.time;
	}



	@Override
	public String toString() {
		return "Event [tipo=" + tipo + ", g=" + g + ", time=" + time + "]";
	}
	
	

}
