package application;

import java.util.*;

public class entreprise {
	String nomE;
	double Salaire;
	Map<Integer, Salaire> salariť = new TreeMap<Integer,Salaire>();
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	public double getSalaire() {
		return Salaire;
	}
	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	public Map<Integer, Salaire> getSalariť() {
		return salariť;
	}
	public void setSalariť(Map<Integer, Salaire> salariť) {
		this.salariť = salariť;
	}
	public entreprise(String nomE, Map<Integer, Salaire> listSalariť) {
		super();
		this.nomE = nomE;
		this.salariť = listSalariť;
	}  

}
