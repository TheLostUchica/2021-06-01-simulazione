package it.polito.tdp.genes.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.genes.model.Coppie;
import it.polito.tdp.genes.model.Genes;


public class GenesDao {
	
	HashMap<String, Genes> IdMap;
	
	/*public List<Genes> getAllGenes(){
		String sql = "SELECT DISTINCT GeneID, Essential, Chromosome FROM Genes";
		List<Genes> result = new ArrayList<Genes>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Genes genes = new Genes(res.getString("GeneID"), 
						res.getString("Essential"), 
						res.getInt("Chromosome"));
				result.add(genes);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	public List<Genes> getVertex(){
		
		String sql = "SELECT GeneID,Chromosome FROM genes WHERE Essential=\"Essential\"";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			
			IdMap = new HashMap<String, Genes>();
			
			while (res.next()) {
				Genes g = new Genes(res.getString("GeneID"), res.getInt("Chromosome"));
				IdMap.put(g.getGeneId(), g);
			}
			
			conn.close();
			return new LinkedList<Genes>(IdMap.values());
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Coppie> getCoppie(){
		
		String sql = "SELECT GeneID1, GeneID2, Expression_Corr "
				+ "FROM interactions "
				+ "WHERE GeneID1<>GeneID2 "
				+ "AND GeneID1 IN (SELECT GeneID FROM genes WHERE Essential=\"Essential\") "
				+ "AND GeneID2 IN (SELECT GeneID FROM genes WHERE Essential=\"Essential\") ";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			
			List<Coppie> result = new LinkedList<>();
				
			while (res.next()) {
				Coppie c = new Coppie(IdMap.get(res.getString("GeneID1")),IdMap.get(res.getString("GeneID2")),Math.abs(res.getDouble("Expression_Corr")));
				result.add(c);
			}
			
			conn.close();
			return result;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	


	
}
