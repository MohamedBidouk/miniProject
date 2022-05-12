package application;

import java.util.*;

public class entreprise {
	String nomE;
	double Salaire;
	Map<Integer, Salaire> salarié = new TreeMap<Integer,Salaire>();
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
	public Map<Integer, Salaire> getSalarié() {
		return salarié;
	}
	public void setSalarié(Map<Integer, Salaire> salarié) {
		this.salarié = salarié;
	}
	public entreprise(String nomE, Map<Integer, Salaire> listSalarié) {
		super();
		this.nomE = nomE;
		this.salarié = listSalarié;
	}  

}
