package knapsackNaive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
import java.util.Scanner;

public class LoadText {
	String fileToLoad;
	int length = 0;
	int knapsackSize;
	// First line of the file stores the number of vertexes from the test file
	public LoadText(String fileName) throws FileNotFoundException {
		fileToLoad = fileName;
		System.out.println(fileName);
		size();
	}

	public void size() throws FileNotFoundException {
		int size = 0;
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			size ++;
			myReader.nextLine();
			//System.out.println("Length of Input: " + size);
		}
		//myReader.close();
		length = size;
		System.out.println("Length of Input: " + size);
	}

	public ArrayList <Item> get() throws FileNotFoundException {
		ArrayList<Item> initData = new ArrayList<Item>(length - 1);
		//System.out.println(length);
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		//int numOfVer = 0;
		int index = 0;
		while(myReader.hasNextLine()) {
			String data = myReader.nextLine().strip();
			String[] values = data.split("\\s");
			if(index < 1) {
				index ++;
				this.knapsackSize = Integer.parseInt(values[0]);
				System.out.println(this.knapsackSize);
				continue; // starting line
			}
			int size = Integer.parseInt(values[0]);
			int weight = Integer.parseInt(values[1]);
			//System.out.println(s);
			initData.add(new Item(size,weight));
		}
		myReader.close();
		return initData;
	}
	
	public int getKnapsackSize() {
		return this.knapsackSize;
	}
}
