package groceryList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class GroceryApp
 */
public class GroceryApp {

	/**
	 * Main method for testing. 
	 * @param args
	 */
	public static void main(String[] args) {
		FreshItem food1 = new FreshItem("apple", "dole", "honey crisp", true, "red");
		SnackItem food2 = new SnackItem("teddy graham", "nabisco",Size.FAMILY );
		Vegetable food3 = new Vegetable("broccoli", "veg farms", "raab", true, "green", true);
//		System.out.println(food3.toString());
		
		GroceryItem[] items = {food1, food3, food2};
		List<GroceryItem> groceryItems = new ArrayList<>(Arrays.asList(items));
		
//		Vegetable v = null;
		for (GroceryItem g : groceryItems) {
			System.out.println(g.toString());
			if(g instanceof Vegetable) {
				Vegetable v = (Vegetable) g;
				if(v.isFrozen()) v.setFrozen(false); 
			}
		}
		
		System.out.println("\nNEW food3: \n" + food3.toString());
		
		
		

	} // end main

} // end class
