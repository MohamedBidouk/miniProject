package application;

public class vendeur extends Salaire{
	private double vente;
	private double pourcentage;
	private vendeur(int matricule, String nom, String email, Double recrutement, Double salaireF, double vente, double pourcentage) {
		super(matricule, nom, email, recrutement, salaireF);
		this.vente = vente;
		this.pourcentage = pourcentage;
	}
	private double getVente() {
		return vente;
	}
	public void setVente(double vente) {
		this.vente = vente;
	}
	public double getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}
	@Override
	public String toString() {
		return "vendeur [vente=" + vente + ", pourcentage=" + pourcentage + ", nom=" + nom + ", email=" + email
				+ ", recrutement=" + recrutement + ", salaireF=" + salaireF + ", getVente()=" + getVente()
				+ ", getPourcentage()=" + getPourcentage() + ", getnom()=" + getNom() + ", getEmail()=" + getEmail()
				+ ", toString()=" + super.toString() + ", getRecrutement()=" + getRecrutement() + ", getSalaireF()="
				+ getSalaireF() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	private double calculSalaire() {
		if (this.getRecrutement()<=2005) {
			return 400;
		}else {
			return 280;
		}
	}
	
}
