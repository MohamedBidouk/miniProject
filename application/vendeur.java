package application;

public class vendeur extends Salaire{
	private double vente;
	private double pourcentage;
	vendeur(int matricule, String nom, String email, Double recrutement, Double salaireF, double vente, double pourcentage) {
		super(matricule, nom, email, recrutement, salaireF);
		this.vente = vente;
		this.pourcentage = pourcentage;
	}
	
	public void setSalaireF () {
		if (this.getRecrutement()<=2005) {
			this.salaireF = 400 + this.pourcentage;
		}else {
			this.salaireF = 280 + this.pourcentage;
		}
	}

	public double getVente() {
		return vente;
	}

	public void setVente(double vente) {
		this.vente = vente;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = this.vente * 0.2;
	}
	
	
}
