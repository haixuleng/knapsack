package knapsackNaive;

import java.util.ArrayList;

public class Dynamic {
	int[][] A; // array to store the computed values, A[n + 1][w + 1]
	ArrayList<Item> inputArray; // input array
	int weight; // total weight the knapsack can use
	
	public Dynamic(ArrayList<Item> input, int weight) {
		this.inputArray = input;
		this.weight = weight;
		System.out.println("Total weight is: "+ this.weight);
		initialize();
		run();
		//printOut();
	}
	
	public void initialize() {
		// initialize the array A
		// set A[0][i] = 0
		this.A = new int[this.inputArray.size() + 1][this.weight + 1];
		for(int i = 0; i < this.weight + 1; i++) {
			this.A[0][i] = 0;
		}
	}
	
	public void run() {
		for(int i = 1; i <= this.inputArray.size(); i++) {
			Item currentItem = this.inputArray.get(i - 1);
			for(int x = 0; x <= this.weight; x++) {
				if(x < currentItem.weight) {
					// the item cannot be stored
					this.A[i][x] = Math.max(this.A[i - 1][x], 0);
				}
				else {
					this.A[i][x] = Math.max(this.A[i - 1][x], this.A[i - 1][x - currentItem.weight] + currentItem.value);
				}
			}
		}
	}
	
	public int get() {
		return this.A[this.inputArray.size()][this.weight];
	}
	
	public void printOut() {
		for(int i = 0; i <= this.inputArray.size(); i++) {
			System.out.println(i + ":");
			for(int j = 0; j <= this.weight; j++) {
				System.out.print(this.A[i][j] + " ");
			}
		}
	}
}
