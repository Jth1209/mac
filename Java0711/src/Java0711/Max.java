package Java0711;

public class Max {
	public static void main(String[] args) {
		int[] a = {11,33,10,266,88};
		int max = 0;
		int temp =0;
		
		for(int i =0; i<a.length-1; i++) {
			if(a[i] < a[i+1]) {
				max = a[i+1];
			}
			
			for(int j =i; j >= 0; j--) {
				if(a[j] > a[j+1]) {
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}//sort algoritm ㅋ
					
			}
		}
		System.out.println(max);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}