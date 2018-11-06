
public class Tile {
private int num;
private String color;
	public Tile() {}
	
	public Tile(String color, int num) {
		this.num=num;
		this.color=color;
	}
	
	public String getName() {
		String temp="";
		temp+=color;
		temp+=num;
		return temp;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public String getColor() {
		return this.color;
	}

}
