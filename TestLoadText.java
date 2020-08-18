package knapsackNaive;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestLoadText {
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/knapsack1.txt"); // result is 2493893
		//LoadText lt = new LoadText("data/input_random_15_100_100.txt");
		ArrayList<Item> data = lt.get();
		int weight = lt.getKnapsackSize();
		Dynamic dn = new Dynamic(data, weight);
		System.out.println("Result: " + dn.get());
		
	}
}
