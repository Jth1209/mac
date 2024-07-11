package Java0711;

import java.util.Scanner;

public class Max {
	public static int getNum(Scanner scan) {//사용자에 의해 입력 (표준 입력)
		String input  = scan.nextLine();
		return Integer.parseInt(input);
	}
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		System.out.print("입력할 숫자개수 : ");//사용자가 원하는 개수만큼 숫자를 받
	    int num = getNum(sc);
	    
		int[] a = new int[num];
		for(int i = 0 ; i < a.length; i++) {//사용자가 숫자 입력(위에서 정한 개수만큼)
		System.out.print("숫자 입력 : ");
			a[i] = getNum(sc);
		}
		
		int max = 0;
		int temp =0;
		
		for(int i =0; i<a.length-1; i++) {//최대값 구하
			if(a[i] < a[i+1]) {
				max = a[i+1];
			}
			
			for(int j =i; j >= 0; j--) {//입력된 숫자 오름차순 정렬 
				if(a[j] > a[j+1]) {
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}//sort asc;
					
			}
		}
		System.out.println("최대값: "+max);
	    System.out.println("정렬(asc) :");
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}