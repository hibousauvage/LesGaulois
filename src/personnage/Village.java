package personnage;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;

		this.villageois = new Gaulois[nbVillageoisMax];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		this.villageois[nbVillageois] = gaulois;
		nbVillageois++;

	}

	public Gaulois trouverHabitant(int numVillageois) {
		return this.villageois[numVillageois];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + this.chef.getNom() + " vivent les l�gendaires gaulois :");

		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("- " + this.villageois[i].getNom());
		}

	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		exeption index out of bound -> les indice vont de 0 a 29
		Chef abraracourcix = new Chef("Abraracourcix", 8, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		village.ajouterHabitant(obelix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		l'indice de astezrix est 0 malgr�s le fait que ce soit le premier villageois, le reste du tableaux est compose de Gaulois null
		village.afficherVillageois();
	}
}
