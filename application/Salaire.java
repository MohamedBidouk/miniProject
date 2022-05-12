package application;


public class Salaire implements java.lang.Comparable<Salaire>, Comparable<Salaire> {
	protected int matricule;
	protected String nom;
	protected String email;
	protected Double recrutement;
	protected double salaireF;
	
	public Salaire(int matricule, String nom, String email, Double recrutement, double salaireF) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.email = email;
		this.recrutement = recrutement;
		this.salaireF = salaireF;
	}

	public String getNom() {
		return nom;
	}
	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "employe [nom=" + nom + ", email=" + email + ", recrutement=" + recrutement + ", salaireF=" + salaireF
				+ "]";
	}
	public Double getRecrutement() {
		return recrutement;
	}
	public void setRecrutement(Double recrutement) {
		this.recrutement = recrutement;
	}
	public Double getSalaireF() {
		return salaireF;
	}
	public void setSalaireF(Double salaireF) {
		if (this.getRecrutement()<=2005) {
			this.salaireF = 400;
		}else {
			this.salaireF = 280;
		}
	}

	@Override
	public int compareTo(Salaire e) {
        if(this.getSalaireF() ==e.getSalaireF()) return 0;
        else if (this.getSalaireF()>e.getSalaireF()) return 1;
        else return -1;	
	}
}