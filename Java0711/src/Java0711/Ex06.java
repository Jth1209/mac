package Java0711;

import java.util.Scanner;

public class Ex06 {
	
	public static int getNum(String msg, Scanner scan) {
		System.out.println(msg);
		String input = scan.nextLine();
		return Integer.parseInt(input);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int w = 0;
		
		do {
			 n = getNum("n값: ",sc);
		}while(n <= 0);
		
		do {
			w = getNum("w값: ",sc);
		}while(w <= 0 || n < w );
		
		
		/*for(int i = 0; i < n/w; i++) {
			System.out.print("*".repeat(w));
		}
		if(n%w != 0) {
			for (int i = 0; i < n%w; i++) {
				System.out.print("*");
			}
		}*/
		
		for(int i = 0; i < n; i++) {
			if(i % w == 0) {
				System.out.println();
			}
			System.out.print("*");
		}
	}

}