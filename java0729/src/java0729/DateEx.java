package java0729;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) {
		Date now = new Date();//웹 개발시 많이 볼수 있는 타입
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/hh/mm/ss");//시간 표현 방식을 객체를 따로 생성해서 지정해야 함
		String set = sdf.format(now);
		System.out.println(set);
		
		LocalDateTime lc = LocalDateTime.now();//스레드 사용할 때 자주 사용함
		
		String set2 = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(lc);
		System.out.println(set2);
	}

}
