import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many elements are in the list? ");
		
		int elementNum = input.nextInt();
		
		double list[] = new double[elementNum];
		
		for(int i = 0; i < elementNum; i++) {
			System.out.print("Enter element " + (i+1) + ": ");
			list[i] = input.nextDouble();
		}
		System.out.println("The result is " + median(list));
	}
	public static double median(double[] originalList) {
		return partition(originalList, originalList.length/2);
	}
	
	public static double partition(double[] list, int desiredIndex) {
		
		if(list.length == 1) {
			return list[0];
		}
		
		double[] newList = new double[list.length];
		
		int smallerElements = 0;
		int biggerElements = 0;
		
		for(int i = 1; i < list.length; i++) {
			if (list[i] <= list[0]) {
				newList[smallerElements] = list[i];
				smallerElements++;
			} else {
				newList[newList.length-(biggerElements+1)] = list[i];
				biggerElements++;
			}
		}
		
		newList[smallerElements] = list[0];
		smallerElements++;
		
		if (smallerElements <= desiredIndex) {
			double partitionedList[] = new double[biggerElements];
			for(int i = 0; i < biggerElements; i++) {
				partitionedList[i] = newList[smallerElements+i];
			}
				
			return partition(partitionedList, desiredIndex-smallerElements);
			
		} else {
			double partitionedList[] = new double[smallerElements];
			for(int i = 0; i < smallerElements; i++) {
				partitionedList[i] = newList[i];
			}
			
			return partition(partitionedList, desiredIndex);
		}
		
	}
}
