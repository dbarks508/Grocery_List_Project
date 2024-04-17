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
		SnackItem food4 = new SnackItem("bagel", "thomas", Size.REGULAR);
		FreshItem food5 = new FreshItem("banana", "dole", "standard", true, "yellow");
//		System.out.println(food3.toString());
		
		GroceryItem[] items = {food1, food3, food2, food4, food5};
		List<GroceryItem> groceryItems = new ArrayList<>(Arrays.asList(items));
		GroceryList gl = new GroceryList(groceryItems, "Prices.csv");
		System.out.println("Estimated price: " + gl.estimatePrice());

//		List<Price> prices = gl.generatePriceList();
//		for (Price p: prices) {
//			System.out.println(p.toString());
//		}
		
//		Vegetable v = null;
//		for (GroceryItem g : groceryItems) {
//			System.out.println(g.toString());
//			if(g instanceof Vegetable) {
//				Vegetable v = (Vegetable) g;
//				if(v.isFrozen()) v.setFrozen(false); 
//			}
//		}
//		
//		System.out.println("\nNEW food3: \n" + food3.toString());
		
		
		

	} // end main
		
		

} // end class
