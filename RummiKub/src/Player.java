import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Tile> hand= new ArrayList<Tile>();
	
	public Player(String name) {
		this.name=name; 
	}

	public void displayHand() {
		String tot="";
		for(int i=0; i<hand.size(); i++) {
			tot+=hand.get(i).getColor();
			tot+=hand.get(i).getNum();
			tot+="|";
		}
		System.out.println(tot);
	}
	
	public void addToHand(Tile tile) {
		hand.add(tile);
	}
	
	/*public void removeFromHand(Tile tile) {
		System.out.println(tile.getName() + " Is removed from hand");
		hand.remove(tile);
	}*/
	
	public Tile getCard(int index) {
		return hand.get(index);
	}
	
	public boolean empty() {
		return hand.isEmpty();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void remove(ArrayList<Tile> tiles) {
		for(Tile t: tiles) {
			hand.remove(t);
		}
	}
}
