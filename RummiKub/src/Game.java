import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private boolean victor=false;
	private Deck deck;
	private ArrayList<Player> players= new ArrayList<Player>();
	private Field field;
	private Scanner scan= new Scanner(System.in);

	public Game() {
		this.deck=new Deck();
		this.field= new Field();
	}
	public void startGame() {
		Player temp;
		choosePlayers();
		distributeTiles();
		displayAllHands();
		while(!victor) {
			playerAction();
			field.displayField();
			if(players.get(0).empty()) {
				victor=true;
				System.out.println("We found a winner! "+ players.get(0).getName() + " Congratulations!");
			}
			temp=players.remove(0);
			players.add(temp);
		}
	}

	public void playerAction() {
		int choice;
		boolean notfixed=true;
		System.out.println(players.get(0).getName() + ". What would you like to do?");
		System.out.println("1. Draw tile and pass");
		System.out.println("2. Play");
		choice= scan.nextInt();
		if(choice>2 || choice<1) {
			System.out.println("Must be one of the choices");
			while(notfixed) {
				System.out.println(players.get(0).getName() + ". What would you like to do?");
				System.out.println("1. Draw tile and pass");
				System.out.println("2. Play");
				choice= scan.nextInt();
				if(choice==1 || choice==2)break;
				System.out.println("Must be one of the choices");
			}
		}
		
		switch(choice) {
		case 1: players.get(0).addToHand(deck.draw());
				break;
		case 2: play();
				break;
		}	
	}
	
	public void play() {

		int row;
		ArrayList<Tile> tiles= new ArrayList<Tile>();
		System.out.println("Which cards would you like to play?");
		
		tiles=getInput();
		if(tiles.isEmpty()) {
			players.get(0).addToHand(deck.draw());
			return;
		}
		
		System.out.println("Which row would you like to put them in, if you want to create a new row type 100");
		row= scan.nextInt();
		
		if(row<0) {
			System.out.println("Must be a positive number");
		}else if(row>field.secNum()) {
			if(!addingRow(tiles)) {
				System.out.println("Lost your turn, draw a card and move on");
				players.get(0).addToHand(deck.draw());
				return;
			}
		}else {
			if(!addToRow(tiles,row)) {
				System.out.println("Lost your turn, draw a card and move on");
				players.get(0).addToHand(deck.draw());
				return;
			}
		}
		
	}
	
	public boolean addToRow(ArrayList<Tile> tiles, int row) {
		int diff, counter;
		
		diff=3-tiles.size();
		ArrayList<Tile> temp= new ArrayList<Tile>();
		
		if(diff>0) {
			temp=field.getRow(row);
			counter=temp.size()-1;
			for(int i=diff; i>0; i--) {
				tiles.add(0,temp.get(counter));
				counter--;
			}
			
			System.out.println("You chose");
			for(int i=0; i<tiles.size(); i++) System.out.print(tiles.get(i).getName()+ " ");
			System.out.print("\n");
			
			
			if(isSameColor(tiles)) {
				if(isRun(tiles)) {
					System.out.println("Set is a Run!");
					field.addToRow(tiles, row);
					players.get(0).remove(tiles);
					
				}
			}else if(isGroup(tiles)) {
				System.out.println("Set is a Group!");
				field.addToRow(tiles, row);
				players.get(0).remove(tiles);
			}else {
				System.out.println("Neither a run or a group");
				return false;
			}
		return true;
			
		}else {
			System.out.println("You chose");
			for(int i=0; i<tiles.size(); i++) System.out.print(tiles.get(i).getName()+ " ");
			System.out.print("\n");
			
			
			if(isSameColor(tiles)) {
				if(isRun(tiles)) {
					System.out.println("Set is a Run!");
					field.addToRow(tiles, row);
					players.get(0).remove(tiles);
					
				}
			}else if(isGroup(tiles)) {
				System.out.println("Set is a Group!");
				field.addToRow(tiles, row);
				players.get(0).remove(tiles);
			}else {
				System.out.println("Neither a run or a group");
				return false;
			}
		}
		return true;
	}
	
	public boolean addingRow(ArrayList<Tile> tiles) {
		
		if(!isThree(tiles)) {
			while(true) {
				tiles=getInput();
				if(tiles.isEmpty()) {
					return false;
				}
				if(isThree(tiles)) break;
			}
		}
		
		System.out.println("You chose");
		for(int i=0; i<tiles.size(); i++) System.out.print(tiles.get(i).getName()+ " ");
		System.out.print("\n");
		
		
		if(isSameColor(tiles)) {
			if(isRun(tiles)) {
				System.out.println("Set is a Run!");
				field.addRow(tiles);
				players.get(0).remove(tiles);
				
			}
		}else if(isGroup(tiles)) {
			System.out.println("Set is a Group!");
			field.addRow(tiles);
		}else {
			System.out.println("Neither a run or a group");
			return false;
		}
		return true;
	}
	
	public ArrayList<Tile> getInput() {
		String input;
		String[] splitInput;
		ArrayList<Tile> tiles= new ArrayList<Tile>();
		
		players.get(0).displayHand();
		
		input= scan.nextLine();
		if(input.length()<1) {
			System.out.println("You must type something");
			while(!input.equals("nevermind")) {
				System.out.println("Type nevermind to just draw a card");
				players.get(0).displayHand();
				input= scan.nextLine();
				if(input.length()>0) break;
			}
		}
		if(input.equals("nevermind")) return tiles;
		splitInput=input.split(" ");
		for(int i=0; i<splitInput.length; i++) tiles.add(players.get(0).getCard(Integer.parseInt(splitInput[i])-1));
		
		return tiles;
	}
	
	public boolean isThree(ArrayList<Tile> tiles) {
		if(tiles.size()<3) return false;
		return true;
	}
	
	public boolean isSameColor(ArrayList<Tile> tiles) {
		String color=tiles.get(0).getColor();
		for(Tile t: tiles) {
			if(!(t.getColor().equals(color))) {
				System.out.println("The colors don't match");
				return false;
			}
		}
		return true;
	}
	
	public boolean isRun(ArrayList<Tile> tiles) {
		for(int i=1; i<tiles.size(); i++) {
			if((tiles.get(i).getNum()- tiles.get(i-1).getNum())!= 1) {
				System.out.println("Not a run");
				return false;
			}
		}
		return true;
	}
	
	public boolean isGroup(ArrayList<Tile> tiles) {
		int num=tiles.get(0).getNum();
		for(Tile t: tiles) {
			if(t.getNum()!=num) {
				System.out.println("Not the same numbers");
				return false;
			}
		}
		return true;
	}
	
	public void displayAllHands() {
		for(Player p: players) {
			System.out.println(p.getName());
			p.displayHand();
			System.out.print("\n");
		}
	}
	
	public void distributeTiles() {
		Tile temp;
		for(Player p: players) {
			for(int j=0; j<7; j++) {
				temp=deck.draw();
				p.addToHand(temp);
			}
		}
	}
	
	public void choosePlayers() {
		int num;
		System.out.println("How many players are playing? ");
		num=scan.nextInt();
		if(num>4 || num<2) {
			System.out.println("Players must be between 2 and 4");
			for(int i=0; i<4; i++) {
				System.out.println("You have " + i + " tries to get this right");
				num=scan.nextInt();
				if(num<=4 && num>1) break;
			}
		}
		System.out.println("You chose " + num + " players");
		switch(num) {
		case 2: twoPlayer();
				break;
		case 3: threePlayer();
				break;
		case 4: fourPlayer();
				break;
		}
	}
	
	public void twoPlayer() {
		Player player1= new Player("Player 1");
		Player player2= new Player("Player 2");
		players.add(player1);
		players.add(player2);
	}
	
	public void threePlayer() {
		Player player1= new Player("Player 1");
		Player player2= new Player("Player 2");
		Player player3= new Player("Player 3");
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
	}
	
	public void fourPlayer() {
		Player player1= new Player("Player 1");
		Player player2= new Player("Player 2");
		Player player3= new Player("Player 3");
		Player player4= new Player("Player 4");
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
	}

	
}
