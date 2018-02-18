
public class Contestant {
	private String name;
	private int score;
	private Location loc;
	
	/** @return the name of this contestant */
	public String getName() {
		return name;
	}
	
	/** @return the score of this contestant */
	public int getScore() {
		return score;
	}
	
	/** @return the location of this contestant */
	public Location getLoc() {
		return loc;
	}
	
	/** @param int for updated score */
	public void setScore(int newScore){
		score = newScore;
	}
	
	/** Changes the location of this contestant to a new row
	 *  and column.
	 *  @param newRow the new row
	 *  @param newCol the new column */
	public void updateLocation(int newRow, int newCol){
		loc = new Location(newRow, newCol);
	}
	
	public Contestant(int r, int c){
		loc = new Location(r, c);
	}
}
