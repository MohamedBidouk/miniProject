package application;

public class utility {
	public employes emp;

	public employes getEmp() {
		return emp;
	}

	public void setEmp(employes emp) {
		this.emp = emp;
	}

	public utility(employes emp) {
		super();
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "utility [emp=" + emp + ", getEmp()=" + getEmp() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
