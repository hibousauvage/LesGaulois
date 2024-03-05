package personnage;

public class Romain {
	private String nom;
	private int force;
	private boolean vainqueur;
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

	public boolean getVainqueur() {
		return vainqueur;
	}

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup >= 0;
//		int forceDebut = this.force;
//		this.force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert this.force < forceDebut;
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null; // précondition
		assert force >= 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if(force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte =
		// ejecterEquipement();
		// parler("J'abandonne...");
		// }

//		switch (force) {
//		case oldForce: {
//			
//			parler("J'ai rien senti");
//			break;
//		}
//		case 0: {
//			parler("Aïe");
//			break;
//		}
//		default:
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//			break;
//		}
		if (force == oldForce) {
			parler("J'ai rien senti");
			vainqueur = true;
		} else if (force == 0) {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		} else {
			parler("aie");
		}

		// postcondition la force a diminuée
		assert force <= oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texteDebut;
		String texteMilieu = "";
		String texteFin = "";
		texteDebut = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			texteMilieu = "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipements; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}

			}
			texteFin = resistanceEquipement + "!";
		}
		parler(texteDebut + texteMilieu + texteFin);
		if (forceCoup >= resistanceEquipement) {
			forceCoup -= resistanceEquipement;
		} else {
			forceCoup = 0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] != null) {

				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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

	public int getForce() {
		return force;
	}
}
