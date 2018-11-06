import java.util.ArrayList;
public class Field {
private ArrayList<ArrayList<Tile>> field= new ArrayList<ArrayList<Tile>>();

 public void displayField() {
	 for(int i=0; i<field.size(); i++) {
		 for(int j=0; j<field.get(i).size();j++) {
			 if(field.get(i).get(j)!=null) {
				 System.out.print(field.get(i).get(j).getName() + "| ");
			 }
		 }
		 System.out.print("\n");
	 }
	 System.out.print("\n");
 }
 
 public int secNum() {
	 return field.size();
 }
 
 public ArrayList<Tile> getRow(int row){
	 return field.get(row);
 }
 
 public void addRow(ArrayList<Tile> tiles) {
	 field.add(tiles);
 }
 
 public void addToRow(ArrayList<Tile> tiles, int index) {
	 for(Tile t: tiles) {
		 field.get(index).add(t);
	 }
 }
 public Tile getTile(int row, int col) {
	 return field.get(row).get(col);
 }
}
