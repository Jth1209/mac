package Java0711;

import java.util.Scanner;

public class Array1 {

	public static int getNum(String msg,Scanner scan) {
		System.out.println(msg);
		String input = scan.nextLine();
		return Integer.parseInt(input);
	}
	public static void main(String[] args) {
		int[] array = new int[5];
		int[] Rarray = new int[5];
		Scanner sc = new Scanner(System.in);
		
		for(int i =0; i<array.length; i++) {
			array[i] = getNum("n의 값 ",sc);
		}
		for(int i = 0; i<array.length; i++) {
			Rarray[i] = array[array.length-1-i];
		}
		System.out.println(Rarray[4]);
		
	}

}
