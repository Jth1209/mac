package Java0712;

import java.util.Scanner;
public class Ex06 {

	public static void main(String[] args) {//학생 성적 입력(배열 활용)
		boolean run = true;
		int studentNum =0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------");
            System.out.println("1.학생수 |2.점수입력. |3.점수리스트. |4.분석 |5.종료 |");
			System.out.println("------------------------------");
		    System.out.print("선택> ");
		    
		    int selectNo = Integer.parseInt(sc.nextLine());
		    
		    if(selectNo == 1) {
		        System.out.print("학생 수> ");
		    	studentNum = Integer.parseInt(sc.nextLine());
		    }else if(selectNo == 2) {
		    	scores = new int[studentNum];
		    	for(int i = 0; i < scores.length; i++) {
		    		System.out.print("scores["+i+"]> ");
		    		scores[i] = Integer.parseInt(sc.nextLine());
;		    	}
		    }else if(selectNo == 3) {
		    	for(int i = 0; i < scores.length; i++) {
		    		System.out.print("scores["+i+"]> ");
		    		System.out.println(scores[i]);
;		    	}
			}else if(selectNo == 4) {
			    int max = 0;
			    int sum = 0;
				for(int sScore : scores) {
			    	if( max< sScore) {
			    		max = sScore;
			    	}
			    	sum += sScore;
			    }
			    double avg = (double) sum / studentNum;
				System.out.println("최고 점수: "+max);
				System.out.println("평균 점수: "+avg);
				
			}else if(selectNo == 5) {
				run = false;
			}
		}System.out.println("프로그램 종료");
	}

}
