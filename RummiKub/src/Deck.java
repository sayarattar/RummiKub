import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	public ArrayList<Tile> deck= new ArrayList<Tile>();

	public Deck() {
		Tile redone= new Tile("red", 1);
		Tile redtwo= new Tile("red", 2);
		Tile redthree = new Tile("red", 3);
		Tile redfour= new Tile("red", 4);
		Tile redfive = new Tile("red", 5);
		Tile redsix = new Tile("red", 6);
		Tile redseven=new Tile("red", 7);
		Tile redeight=new Tile("red", 8);
		Tile rednine=new Tile("red", 9);
		Tile redten=new Tile("red", 10);
		Tile redeleven=new Tile("red", 11);
		Tile redtwelve= new Tile("red", 12);
		Tile redthirteen=new Tile("red", 13);
		Tile bone= new Tile("blue", 1);
		Tile btwo= new Tile("blue", 2);
		Tile bthree = new Tile("blue", 3);
		Tile bfour= new Tile("blue", 4);
		Tile bfive = new Tile("blue", 5);
		Tile bsix = new Tile("blue", 6);
		Tile bseven=new Tile("blue", 7);
		Tile beight=new Tile("blue", 8);
		Tile bnine=new Tile("blue", 9);
		Tile bten=new Tile("blue", 10);
		Tile beleven=new Tile("blue", 11);
		Tile btwelve= new Tile("blue", 12);
		Tile bthirteen=new Tile("blue", 13);
		Tile blone= new Tile("black", 1);
		Tile bltwo= new Tile("black", 2);
		Tile blthree = new Tile("black", 3);
		Tile blfour= new Tile("black", 4);
		Tile blfive = new Tile("black", 5);
		Tile blsix = new Tile("black", 6);
		Tile blseven=new Tile("black", 7);
		Tile bleight=new Tile("black", 8);
		Tile blnine=new Tile("black", 9);
		Tile blten=new Tile("black", 10);
		Tile bleleven=new Tile("black", 11);
		Tile bltwelve= new Tile("black", 12);
		Tile blthirteen=new Tile("black", 13);
		Tile oone= new Tile("orange", 1);
		Tile otwo= new Tile("orange", 2);
		Tile othree = new Tile("orange", 3);
		Tile ofour= new Tile("orange", 4);
		Tile ofive = new Tile("orange", 5);
		Tile osix = new Tile("orange", 6);
		Tile oseven=new Tile("orange", 7);
		Tile oeight=new Tile("orange", 8);
		Tile onine=new Tile("orange", 9);
		Tile oten=new Tile("orange", 10);
		Tile oeleven=new Tile("orange", 11);
		Tile otwelve= new Tile("orange", 12);
		Tile othirteen=new Tile("orange", 13);		
		
		deck.add(redone);
		deck.add(redtwo);
		deck.add(redthree);
		deck.add(redfour);
		deck.add(redfive);
		deck.add(redsix);
		deck.add(redseven);
		deck.add(redeight);
		deck.add(rednine);
		deck.add(redten);
		deck.add(redeleven);
		deck.add(redtwelve);
		deck.add(redthirteen);
		deck.add(bone);
		deck.add(btwo);
		deck.add(bthree);
		deck.add(bfour);
		deck.add(bfive);
		deck.add(bsix);
		deck.add(bseven);
		deck.add(beight);
		deck.add(bnine);
		deck.add(bten);
		deck.add(beleven);
		deck.add(btwelve);
		deck.add(bthirteen);
		deck.add(blone);
		deck.add(bltwo);
		deck.add(blthree);
		deck.add(blfour);
		deck.add(blfive);
		deck.add(blsix);
		deck.add(blseven);
		deck.add(bleight);
		deck.add(blnine);
		deck.add(blten);
		deck.add(bleleven);
		deck.add(bltwelve);
		deck.add(blthirteen);
		deck.add(oone);
		deck.add(otwo);
		deck.add(othree);
		deck.add(ofour);
		deck.add(ofive);
		deck.add(osix);
		deck.add(oseven);
		deck.add(oeight);
		deck.add(onine);
		deck.add(oten);
		deck.add(oeleven);
		deck.add(otwelve);
		deck.add(othirteen);
		
		shuffleDeck();
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public Tile draw() {
		return deck.remove(0);
	}
	
	
	public boolean empty() {
		return deck.isEmpty();
	}
}
