package application;

import java.util.*;

public class entreprise {
	String nomE;
	double Salaire;
	Map<Integer, Salaire> salari� = new TreeMap<Integer,Salaire>();
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
	public Map<Integer, Salaire> getSalari�() {
		return salari�;
	}
	public void setSalari�(Map<Integer, Salaire> salari�) {
		this.salari� = salari�;
	}
	public entreprise(String nomE, Map<Integer, Salaire> listSalari�) {
		super();
		this.nomE = nomE;
		this.salari� = listSalari�;
	}  

}
