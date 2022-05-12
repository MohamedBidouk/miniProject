package application;

public class employes extends Salaire{
	private double HSupp;
	private double PHSupp;
	employes(int matricule, String nom, String email, Double recrutement, Double salaireF, double hSupp, double pHSupp) {
		super(matricule, nom, email, recrutement, salaireF);
		HSupp = hSupp;
		PHSupp = pHSupp;
	}
	private double getHSupp() {
		return HSupp;
	}
	public void setHSupp(double hSupp) {
		HSupp = hSupp;
	}
	private double getPHSupp() {
		return PHSupp;
	}
	public void setPHSupp(double pHSupp) {
		PHSupp = pHSupp;
	}
	@Override
	public String toString() {
		return "employes [HSupp=" + HSupp + ", PHSupp=" + PHSupp + ", nom=" + nom + ", email=" + email
				+ ", recrutement=" + recrutement + ", salaireF=" + salaireF + ", getHSupp()=" + getHSupp()
				+ ", getPHSupp()=" + getPHSupp() + ", getnom()=" + getNom() + ", getEmail()=" + getEmail()
				+ ", toString()=" + super.toString() + ", getRecrutement()=" + getRecrutement() + ", getSalaireF()="
				+ getSalaireF() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	public double calculSalaireFixe() {
		if (this.getRecrutement()<=2005) {
			return 400;
		}else {
			return 280;
		}
	}
}
