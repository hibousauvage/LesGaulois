package personnage;

public class Romain {
	private String nom;
	private int force;
	Equipement[] equipements = new Equipement[2];
	int nbEquipements = 0;

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

	public void sEquiper(Equipement equipement) {

		switch (nbEquipements) {
		case 2: {
			System.out.println("le soldat " + this.getNom() + " est déjà bien protégé !");
			break;
		}
		case 1: {
			if (equipement == this.equipements[0]) {
				System.out.println("le soldat " + this.getNom() + " possède déjà un " + equipement);

			} else {
				this.equipements[1] = equipement;
				System.out.println("le soldat " + this.getNom() + " s'équipe avec un " + equipement);
				this.nbEquipements++;

			}
			break;

		}
		default: {
			this.equipements[0] = equipement;
			System.out.println("le soldat " + this.getNom() + " s'équipe avec un " + equipement);
			this.nbEquipements++;
			break;
		}

		}
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
		anus.sEquiper(Equipement.CASQUE);
		anus.sEquiper(Equipement.CASQUE);
		anus.sEquiper(Equipement.BOUCLIER);
		anus.sEquiper(Equipement.CASQUE);

	}
}
