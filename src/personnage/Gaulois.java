package personnage;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\" " + texte + " \"");
	}

//	private String prendreParole() {
//		return "Le gaulois " + this.nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(this.nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((this.force / 3) * this.effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] equipementRomain = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; equipementRomain != null && i < equipementRomain.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = equipementRomain[i];
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci druide, je sens que ma force est " + this.effetPotion + " fois decuple.");

	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			String equipementDonner = "";
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophees(this, trophees[i]);
				equipementDonner += "\n" + trophees[i];
			}

			parler("Je donnne au musee tous mes trophees :" + equipementDonner);

		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		System.out.println("executer");
		Gaulois asterix = new Gaulois("Asterix", 9);
		System.out.println(asterix);
		System.out.println(asterix.getNom());
		System.out.println(asterix.prendreParole());
		asterix.parler("mon chibre est enorme !!");
		Romain plexus = new Romain("Plexus", 5);
		asterix.frapper(plexus);
		asterix.frapper(plexus);
		asterix.frapper(plexus);
		Romain cactus = new Romain("Cactus", 15);
		asterix.boirePotion(5);
		asterix.frapper(cactus);

	}

}
