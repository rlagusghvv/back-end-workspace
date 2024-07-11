package com.kh.time;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * java.time 패키지
 * - Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공 (JDK 1.8)
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스 포함
 * - 날짜와 시간에 대한 다양한 메서드를 제공
 */
public class B_Time {

	public void method1() {
		
		/*
		 * LocalDateTime
		 * - 날짜와 시간 정보를 모두 저장
		 * 
		 */
	
		LocalDateTime now = LocalDateTime.now();
		System.out.println("today : " + now);
		
		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2024, 7, 12, 17, 50, 0);
		System.out.println(when);
		
		// ZonedDateTime : LocalDateTime + 시간대
		System.out.println("ZoneDateTime : " + ZonedDateTime.now());
		
		// 년, 월, 일, 요일, 시, 분, 초
	    System.out.println(now.getYear() + "년");
	    System.out.println(now.getMonth()); // JULY 
	    System.out.println(now.getMonthValue() + "월"); // 7월
	    System.out.println(now.getDayOfMonth() + "일"); // 11일
	    System.out.println(now.getDayOfWeek()); // THURSDAY
	    System.out.println(now.getHour() + "시");
	    System.out.println(now.getMinute() + "분");
	    System.out.println(now.getSecond() + "초");
	    
	    System.out.println();
	    
	    // 날짜 조작
	    LocalDateTime plusDays = now.plusDays(1).plusMonths(2).plusYears(1);
	    System.out.println("plus : " + plusDays); // plus : 2025-09-12T14:19:17.961507
	    
	    LocalDateTime minusDays = now.minusYears(1).minusMonths(1).minusDays(1);
	    System.out.println("minus : " + minusDays); // minus : 2023-06-10T14:19:17.961507
	    
	    LocalDateTime withDays = now.withYear(2028).withMonth(8).withDayOfMonth(10);
	    System.out.println("with : " + withDays); // with : 2028-08-10T14:21:20.616812
	    
	    // 오늘이 해당 날짜보다 이후인지 확인
	    System.out.println("isAfter : " + now.isAfter(withDays)); // isAfter : false
	    
	    // 오늘이 해당 날짜보다 이전인지 확인
	    System.out.println("isBefore : " + now.isBefore(withDays)); // isBefore : true
	    
	    // LocalDate : 날짜 정보를 저장(날짜 정보만!!)
	    LocalDate localDate = LocalDate.now();
	    System.out.println("LocalDate : " + localDate); // LocalDate : 2024-07-11
	    localDate = LocalDate.of(2024, 11, 13);
	    System.out.println("LocalDate2 : " + localDate); // LocalDate2 : 2024-11-13
	    
	    // LocalTime : 시간 정보만 저장
	    LocalTime localtime = LocalTime.now();
	    System.out.println("LocalTime : " + localtime); // LocalTime : 14:29:03.693318
	    localtime = LocalTime.of(17, 49, 59);
	    System.out.println("LocalTime2 : " + localtime); // LocalTime2 : 17:49:59
	    
	    		
	    
		
	}
	
	/*
	 * Period와 Duration
	 * - 날짜와 시간 간격을 표현하기 위한 클래스
	 * - Period : 두 날짜 간의 차이
	 * - Duration : 시간의 차이
	 * 
	 */
	public void method2() {
		LocalDate date1 = LocalDate.of(2024, 1, 1);
		LocalDate date2 = LocalDate.of(2025, 12, 31);
		
		Period pe = Period.between(date1, date2);
		System.out.println("pe : " + pe); // pe : P1Y11M30D
		
		System.out.println("years : " + pe.getYears());
		System.out.println("months : " + pe.getMonths());
		System.out.println("days : " + pe.getDays());
		

		System.out.println("years : " + pe.get(ChronoUnit.YEARS));
		System.out.println("months : " + pe.get(ChronoUnit.MONTHS));
		System.out.println("days : " + pe.get(ChronoUnit.DAYS));
		
		LocalTime time1 = LocalTime.of(1, 2, 3);
		LocalTime time2 = LocalTime.of(11, 59, 55);
		
		Duration du = Duration.between(time1, time2);
		System.out.println("du : " + du); // du : PT10H57M52S
		
		System.out.println("hours : " + du.toHours());
		System.out.println("minutes : " + du.toMinutes());
		System.out.println("seconds : " + du.toSeconds());
		
		// 문자열을 LocalDate 객체로 파싱
		LocalDate date = LocalDate.parse("2024-11-13");
		System.out.println(date);
		
		// DateTimeFormatter
		// 날짜와 시간을 포맷팅(Formatting)된 문자열로 변환하는 메서드를 제공하는 클래스
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
		String formatDate = today.format(dtf);
		System.out.println(formatDate);
	}
	
	/*
	 * D-Day 계산기 : 년월일(각각 입력)을 입력하여 디데이 계산
	 * ChronoUnit.Days.between(날짜, 날짜)
	 * 또는 날짜.until(날짜, ChronoUnit.Days)
	 */
	public void method3() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("디데이 계산기 입니다. 원하는 디데이를 입력해주세요.");
		System.out.print("년 : ");
		int year = Integer.parseInt(sc.nextLine());
		System.out.print("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.print("일 : ");
		int day = Integer.parseInt(sc.nextLine());
		
		// 그냥 of로 받으면됨..
	    try {
	    	LocalDate date = LocalDate.of(year, month, day);
	    LocalDate localDate = LocalDate.now();
		long pe = ChronoUnit.DAYS.between(localDate, date);
		pe = localDate.until(date, ChronoUnit.DAYS); 
		if (pe == 0) {
			System.out.println("D-DAY");
		}
		else if (pe < 0) {
			System.out.println(date + "기준으로" + pe + "일 지났습니다.");
		} else {
			System.out.println(date + "까지 남은 D-DAY는 " + pe + "일 입니다.");
		}
		
		
		}
	    catch(DateTimeException e) {
	        System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
	        method3();
	    }
		
//		// 입력받은 숫자가 1자리여도 2자리로 들어갈 수 있게 형 변환
//		String formattedMonth = String.format("%02d", month);
//        String formattedDay = String.format("%02d", day);
//		LocalDate date = LocalDate.parse(year + "-" + formattedMonth + "-" + formattedDay);
		
	
	}
	
	
	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();
//		b.method2();
		b.method3();
	}
}
