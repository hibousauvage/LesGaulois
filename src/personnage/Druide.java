package personnage;

import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion = 1;
	private int effetPotionMin;
	private int effetPotionMax;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\" " + texte + " \"");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		Random random = new Random();
		this.forcePotion = random.nextInt(this.effetPotionMin, this.effetPotionMax + 1);
		if (this.forcePotion > 7) {
			this.parler("J'ai prepare une super potion de force " + this.forcePotion);

		} else {
			this.parler(
					"Je n'ai pas trouve tous les ingredients, ma potion est seulement de force " + this.forcePotion);

		}

	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			this.parler("Non, Obélix !... Tu n'auras pas de potion magique !");

		} else {
			gaulois.boirePotion(forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix",50);
		Gaulois a = new Gaulois("Asterix",10);
		panoramix.booster(a);
		panoramix.booster(obelix);
				

	}
}
