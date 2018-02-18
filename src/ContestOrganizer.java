
public class ContestOrganizer {
	/** the number of rows of contestant */
	public static final int NUM_ROWS = 10;
	
	/** the number of columns of contestant */
	public static final int CONTESTANTS_PER_ROW = 10;
	
	/** the two-dimensional array of contestant */
	private Contestant[][] contestants; 
	
	/** Sorts arr in increasing order by score 
	 * Postcondition:
	 * - arr sorted in increasing order by score.
	 * - Location of each contestant correctly updated such that
	 * column number matches contestant's position in arr.
	 * @param arr the array to be sorted.*/
	public void sort(Contestant[] arr){
		Contestant temp;
		boolean swap = false; 
		do {
		for (int j = 0; j < CONTESTANTS_PER_ROW-1; j++) {
			if (arr[j].getScore() > arr[j+1].getScore()) {
				temp = arr[j]; 
				arr[j] = arr[j+1]; 
				arr[j+1] = temp; 
				
				arr[j].updateLocation(arr[j].getLoc().getRowNumber(), j);
				arr[j+1].updateLocation(arr[j+1].getLoc().getRowNumber(), j+1);
				
				swap = true; 
			}
		}
		} while (swap); 
	}
	
	/** Sorts each row of contestants into increasing order by score.
	 * Postcondition: Contestant with highest score in row[k] is
	 * 				  in the rightmost column of row[k], 0 <= k < NUM_ROWS */
	public void sortAllRows(){ 
		for (int i = 0; i < NUM_ROWS; i++) {
			sort(contestants[i]);
		}
	}

	/** Returns name of contestant with highest score
	 * Precondition:
	 * - Contestants have not been sorted by score.
	 * - Top score is unique
	 * - Only one contestant has the highest score.
	 * @return name of contestant with highest score. */
	public String findWinnerName(){
		sortAllRows();
		Contestant winner = contestants[0][0]; 
		for (int i = 0; i < NUM_ROWS; i++) {
			if (contestants[i][CONTESTANTS_PER_ROW-1].getScore() > winner.getScore()) {
				winner = contestants[i][CONTESTANTS_PER_ROW-1];
			}
		}
		
		return winner.getName();
	}
}
