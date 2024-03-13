package personnage;

public class Musee {
	private Trophee[] trophees = new Trophee[100];
	private int nbTrophee;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee]=new Trophee(gaulois, equipement);
		nbTrophee++;
	}
}
