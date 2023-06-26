package it.polito.tdp.genes.model;

public class Genes implements Comparable<Genes>{
	
	private String geneId;
	private String essential;
	private int chromosome;
	
	public Genes(String geneId, int chromosome) {
		super();
		this.geneId = geneId;
		this.chromosome = chromosome;
	}

	public String getGeneId() {
		return geneId;
	}

	public void setGeneId(String geneId) {
		this.geneId = geneId;
	}

	public String getEssential() {
		return essential;
	}

	public void setEssential(String essential) {
		this.essential = essential;
	}

	public int getChromosome() {
		return chromosome;
	}

	public void setChromosome(int chromosome) {
		this.chromosome = chromosome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geneId == null) ? 0 : geneId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Genes g = (Genes) obj;
		if(this.getGeneId().compareTo(g.getGeneId())==0){
			return true;
		}else {
			return false;
		}
		/*if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genes other = (Genes) obj;
		if (geneId == null) {
			if (other.geneId != null)
				return false;
		} else if (!geneId.equals(other.geneId))
			return false;
		return true;*/
	}

	@Override
	public String toString() {
		return this.geneId;
	}

	@Override
	public int compareTo(Genes o) {
		return this.getGeneId().compareTo(o.getGeneId());
	}


	
	

}
