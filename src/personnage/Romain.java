package personnage;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert force >= 0;
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
		assert forceCoup >= 0;
		int forceDebut = this.force;
		this.force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert this.force < forceDebut;
	}

	public static void main(String[] args) {
		Romain anus = new Romain("Anus", 6);
		System.out.println(anus.prendreParole());
		anus.parler("je me chie dessus");
		anus.recevoirCoup(4);
		anus.recevoirCoup(3);
		anus.prendreParole();
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
	}
}
