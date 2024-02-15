package personnage;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;

	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\" " + texte + " \"");
	}

	private String prendreParole() {
		return "Le romain " + this.nom + " : ";

	}

	public void recevoirCoup(int forceCoup) {
		this.force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	public static void main(String[] args) {
		Romain anus = new Romain("Anus", 6);
		System.out.println(anus.prendreParole());
		anus.parler("je me chie dessus");
		anus.recevoirCoup(4);
		anus.recevoirCoup(3);
		anus.prendreParole();
	}
}
