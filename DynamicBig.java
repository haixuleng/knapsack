package knapsackNaive;

import java.util.ArrayList;

public class DynamicBig {
	int[] A; // array to store the computed values, A[w + 1]
	int[] B; // array to store the latest values B[w + 1]
	ArrayList<Item> inputArray; // input array
	int weight; // total weight the knapsack can use
	
	public DynamicBig(ArrayList<Item> input, int weight) {
		this.inputArray = input;
		this.weight = weight;
		System.out.println("Total weight is: "+ this.weight);
		initialize();
		run();
	}
	
	public void initialize() {
		// initialize the array A
		// set A[0][i] = 0
		this.A = new int[this.weight + 1];
		for(int i = 0; i < this.weight + 1; i++) {
			this.A[i] = 0;
		}
	}
	
	public void run() {
		for(int i = 1; i <= this.inputArray.size(); i++) {
			Item currentItem = this.inputArray.get(i - 1);
			this.B = new int[this.weight + 1];
			for(int x = 0; x <= this.weight; x++) {
				if(x < currentItem.weight) {
					// the item cannot be stored
					this.B[x] = Math.max(this.A[x], 0);
				}
				else {
					this.B[x] = Math.max(this.A[x], this.A[x - currentItem.weight] + currentItem.value);
				}
			}
			this.A = this.B; // update the previous array with latest results
		}
	}
	
	public int get() {
		return this.A[this.weight];
	}
	
}
