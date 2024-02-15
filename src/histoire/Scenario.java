package histoire;

import personnage.Gaulois;
import personnage.Romain;
import personnage.Druide;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Romain minus = new Romain("Minus",6);
		Gaulois obelix = new Gaulois("Obélix",25);
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.parler("Je vais aller preparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste!");
		panoramix.booster(asterix);
		asterix.parler("Bonjour a tous");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);


	}

}
