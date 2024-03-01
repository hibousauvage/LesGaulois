package personnage;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMax;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.nbVillageoisMax = nbVillageoisMax;
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
		nbVillageois ++;
		
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return this.villageois[numVillageois];
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		exeption index out of bound -> les indice vont de 0 a 29
		Chef abraracourcix = new Chef("Abraracourcix", 8, village);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		l'indice de astezrix est 0 malgrés le fait que ce soit le premier villageois, le reste du tableaux est compose de Gaulois null
		
	}
}
