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
		SnackItem food4 = new SnackItem("oreo", "nabisco", Size.REGULAR);
		SnackItem food5 = new SnackItem("bagel", "sarah lee", Size.REGULAR);
		FreshItem food6 = new FreshItem("banana", "dole", "standard", true, "yellow");
				
		//		System.out.println(food3.toString());
		
		GroceryItem[] items = {food1, food3, food2, food4, food5, food6};
		List<GroceryItem> groceryItems = new ArrayList<>(Arrays.asList(items));
		
		GroceryList gl = new GroceryList(groceryItems, "Prices.csv");
//		System.out.println("Items: "+ gl.getNumberOfItems() + " || Veggies: " + gl.getNumberOfVegetables());
		
		List<Price> prices = gl.generatePriceList();
		for (Price p: prices) {
			System.out.println(p.toString());
		}
		
		System.out.println();
		
//		Vegetable v = null;
		for (GroceryItem g : groceryItems) {
			System.out.println(g.toString());
//			if(g instanceof Vegetable) {
//				Vegetable v = (Vegetable) g;
//				if(v.isFrozen()) v.setFrozen(false); 
//			}
		}
		
//		System.out.println("\nNEW food3: \n" + food3.toString());
		
		System.out.println("\nEstimated total:");
		System.out.println(gl.estimatePrice());
		

	} // end main

} // end class
