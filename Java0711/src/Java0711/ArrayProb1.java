package Java0711;

import java.util.Scanner;

public class ArrayProb1 {
	
	public static int getNum(String msg,Scanner scan) {
		System.out.print(msg);
		String input = scan.nextLine();
		return Integer.parseInt(input);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    int[] arr1 = new int[5];
	    for(int i = 0; i< arr1.length; i++) {
	    	arr1[i] = getNum("값: ",sc);
	    }
	    int find = getNum("검색어: ",sc);
	    
	    for(int i = 0; i < arr1.length; i++) {
	    	if(find == arr1[i]) {
	    		System.out.println(arr1[i]);
	    		
	    	}
	    }
	}

}
