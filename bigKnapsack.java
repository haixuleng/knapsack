package knapsackNaive;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class bigKnapsack {
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/knapsack_big.txt"); // result is 2493893
		//LoadText lt = new LoadText("data/input_random_15_100_100.txt");
		ArrayList<Item> data = lt.get();
		int weight = lt.getKnapsackSize();
		DynamicBig dn = new DynamicBig(data, weight);
		System.out.println("Result: " + dn.get());
		
	}
}
