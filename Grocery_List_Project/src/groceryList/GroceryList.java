package groceryList;

import java.util.List;

/**
 * Class GroceryList
 */
public class GroceryList {
	List<GroceryItem> groceryList;
	
	public GroceryList(List<GroceryItem> groceryList) {
		this.groceryList = groceryList;
	}
	
	public int getNumberOfItems() {
		return groceryList.size();
	}
	
	public int getNumberOfVegetables() {
		int numOfVeg = 0;
		for (GroceryItem g : groceryList) {
			if(g instanceof Vegetable) {
				numOfVeg++;
			}
		}
		return numOfVeg;
	} 
	
} // end class
