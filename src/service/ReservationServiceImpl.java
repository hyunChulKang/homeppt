package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import controller.Controller;
import vo.ReservationVO;
import vo.UserVO;
import dao.ReservationDAO;
import dao.ReservationDAOImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Database;
import data.Session;


public class ReservationServiceImpl implements ReservationService{
	//----------------------------------------------------//
	private static ReservationServiceImpl instance;
	
	private ReservationServiceImpl(){}												//싱글톤
	
	public static ReservationServiceImpl getInstance(){
		if(instance == null){
			instance =new ReservationServiceImpl();
		}
		return instance;
	}
	ReservationDAO reservDao = ReservationDAOImpl.getInstance();
	UserDao userDao =UserDaoImpl.getInstance();
	UserVO userVO = new UserVO();
	ArrayList<ReservationVO> reservtaionCheckList = reservDao.reservationList();
	//----------------------------------------------------//
	
	@Override
	public  void roomCheckIn(int roomId, String userid){
//		String userid=Session.LoginUser.getId();
		int count=0;
//		System.out.println("체크인 날짜를\t(ex 20200701) 입력주세요>");
//		int startDt =Integer.parseInt(s.nextLine());
//		Date checkin =ReservationDAOImpl.conv(startDt);
//		
//					
//		System.out.println("체크아웃 날짜를\t(ex 20200701) 입력주세요>");
//		int endDt =Integer.parseInt(s.nextLine());
//		Date checkout = ReservationDAOImpl.conv(endDt);
								
//		boolean reservCheck2 =reservDao.reservCheck(roomid, checkin, checkout);
					
//		if(reservCheck2 == false){				//실패하면 다시 입력하도록 하기 
//			System.out.println("호텔정보화면으로 가고 싶으면  '호텔' 입력 해주시고 \r 날짜를 다시 설정하려면 '날짜선택'을 입력주세요");
//			String replay =s.nextLine();
//			if(replay.equals("호텔")){
//			hs.getInfo();
//			}else if (replay.equals("날짜선택"))
//				roomCheckIn(roomid);
//		}
		
//		SimpleDateFormat format_recentTime1 = new SimpleDateFormat("yyyyMMdd");
//		int checkinf = Integer.parseInt(format_recentTime1.format(checkin));
//		
//		SimpleDateFormat format_recentTime2 = new SimpleDateFormat("yyyyMMdd");
//		int checkoutf = Integer.parseInt(format_recentTime2.format(checkout));
//		
		
		
//		System.out.println("결제방식선택하세요 \r\t 현금 \t 카드");
//		reservationId++;
		
//		UserReservationlist.add();
//		UserReservationlist.add(reservationId);
//		UserReservationlist.add(roomid);
//		UserReservationlist.add(checkinf);
//		UserReservationlist.add(checkoutf);
		
//		for(int i =0; i<UserReservationlist.size(); i++){
//				System.out.print("\t"+UserReservationlist.get(i));
//				
//		}
//		System.out.println();
		
		
//		//-------------------------------체크인 입력부---------------------------------------//	
			Scanner s = new Scanner(System.in);
			System.out.println("체크인 날짜를\t(ex 20200701) 입력주세요>");
			String checkinday = s.nextLine();									//String 타입
			int checkindays1 =Integer.parseInt(checkinday);
			
			System.out.println("체크아웃 날짜를\t(ex 20200701) 입력주세요>");
			int checkoutday =Integer.parseInt(s.nextLine());					//int 타입
		    
			 Date fristday =conv(checkindays1);
		     Date lastday =conv(checkoutday);
//		//-------------------------------체크인 날짜 계산---------------------------------------//
		     int startYear = Integer.parseInt(checkinday.substring(0,4));
		     int startMonth= Integer.parseInt(checkinday.substring(4,6));
		     int startDate = Integer.parseInt(checkinday.substring(6,8));
		     Calendar cal1 = Calendar.getInstance();
		     cal1.set(startYear, startMonth -1, startDate);
		     
		//--------------------------------날짜 출력-------------------------------------------//    
//		     userReservList.setUserId();
//		     for(int i = 0; i< alluserList.size(); i++){
//		    	 System.out.print("\t"+alluserList.get(i));
//		     }
		     while(true) {
		    	 count++;
		         cal1.add(Calendar.DATE, 1);
		         int checkdays =getDateByInteger(cal1.getTime());								//	Calendar의 날짜를 하루씩 증가한다.
		         if(getDateByInteger(cal1.getTime()) >= checkoutday) 							// 현재 날짜가 종료일자보다 크거나 같을때
		        	 break;
		     }
		     
		     SimpleDateFormat format_recentTime = new SimpleDateFormat("yyMMddmmss");				//현재 시간을 예약아이디로 입력부
		     Date recentTime = new Date();
		     int reservationId = Integer.parseInt(format_recentTime.format(recentTime));	
		     ReservationVO userReservList = new ReservationVO();
		     
		    //--------------------------------날짜 출력-------------------------------------------//
		     
		     boolean reservCheck = reservDao.reservCheck(roomId, fristday, lastday);				//예약체크
		     if(!reservCheck){
		    	 System.out.println("예약실패 다시");
		    	 }
		     else if(reservCheck == true){																//예약체크에 따른 예약성공실패
		    	 System.out.println("예약성공");
		    	 String requestText =request();														//요청사항
		    	 String paymethod = makePayment(roomId, count);
		    	 System.out.println(count);
		    	 int dayPrice=reservDao.getRoomPrice(roomId);
		    	 int totalPrice = dayPrice*count;
		    	 
		    	 userReservList.setUserId(userid);														//현재 접속중인 유져아이디
		    	 userReservList.setReservationId(reservationId);
		    	 userReservList.setRoomId(roomId);													//선택한 룸아이디
		    	 userReservList.setCheckin(fristday);
		    	 userReservList.setCheckout(lastday);
		    	 userReservList.setCount(count);
		    	 userReservList.setPaymethod(paymethod);
		    	 userReservList.setReservationPrice(totalPrice);
		    	 userReservList.setRequest(requestText);
		    	 userReservList.setStatus(1);
		    	 
		    	 reservDao.insertUser(userReservList);
		     }
			
		}//The end roomCheckIn
	
	public String request() {																		//요청사항메소드
		System.out.println("------------------------------------------");
		System.out.println("객실에 대한 추가 요구사항이 있을 경우 기재해주세요 (200자 이하)");
		System.out.println("------------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		String request = sc.nextLine();
		
		return request;
	}
	
	public static Date conv(int date){
		Calendar cal1 = Calendar.getInstance();
		int a = date%100; //일
		date = date/100;
		int b = date%100; //월
		date = date/100;
		int c = date%10000; //년도
		date = date/10000;
		
		cal1.set(c, b-1, a);
		Date time = cal1.getTime();
		
		return time;
	}
	
	public static int getDateByInteger(Date date) {										//날짜를 숫자로치환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(sdf.format(date));
	}
	
	@Override
	public String makePayment(int roomid, int staydate) {
		
		String paymentMethod = "";
		int price = reservDao.getRoomPrice(roomid);
		double prices = (double)price*staydate;
		
		do{
		System.out.println("------------------------------------------");
		System.out.println("결제하실 방의 가격은"+prices+"입니다.");
		System.out.println("1. 결제하기");
		System.out.println("2. 결제취소");
		System.out.println("------------------------------------------");
		Scanner sc = new Scanner(System.in);
		int ans = Integer.parseInt(sc.nextLine());
		if(ans == 2){break;}
		if(ans == 1){
			System.out.println("------------------------------------------");
			System.out.println("결제 방법을 선택해주세요");
			System.out.println("1. 현금");
			System.out.println("2. 계좌이체");
			System.out.println("3. 카드");
			System.out.println("4. 결제취소");
			System.out.println("------------------------------------------");
			
			ans = Integer.parseInt(sc.nextLine());
			
			if(ans == 1){paymentMethod = "현금";
			System.out.println("결제가 완료되었습니다. 감사합니다.");}
			if(ans == 2){paymentMethod = "계좌이체";
			System.out.println("결제가 완료되었습니다. 감사합니다.");}
			if(ans == 3){paymentMethod = "카드";
			System.out.println("결제가 완료되었습니다. 감사합니다.");}
			if(ans == 4){break;}
			
		}return paymentMethod;
		
		}while(true);
		
		return paymentMethod;
	}

	@Override
	public void searchReserv(String userid) { //검색과 동시에 예약을 취소하거나 리뷰를 작성할 수 있다
		
		ArrayList<ReservationVO> reserv = reservDao.getUserReserv(userid);
		
		do{
			Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------------");
		for(int i = 0; i < reserv.size(); i++){
			System.out.print("예약"+(i+1)+"번>");
			reservDao.resVOprint(reserv.get(i));
		}
		System.out.println("------------------------------------------");
		System.out.println("1. 예약취소하기");
		System.out.println("2. 리뷰쓰기");
		System.out.println("3. 나가기");
		System.out.println("------------------------------------------");
		
		int ans = Integer.parseInt(sc.nextLine());
		if(ans == 1){
			System.out.println("예약리스트에서 취소하실 예약번호를 선택해주세요(ex.예약12번)");
			System.out.println("유저 화면으로 돌아가시려면 0을 눌러주세요");
			ans = Integer.parseInt(sc.nextLine());
			
			if(ans == 0){break;}
			if(reserv.get(ans-1).getStatus() == 1){
				System.out.println("예약이 취소되었습니다.");
				System.out.println("결제금액 "+reserv.get(ans-1).getReservationPrice()+"을");
				System.out.println("결제하신 방법인 "+reserv.get(ans-1).getPaymethod()+"(으)로 돌려드립니다.");
				reservDao.cancelReserv(reserv.get(ans-1).getReservationId()); 			//예약상태를 취소로 바꾸는 메소드
				break;
			}
			if(reserv.get(ans-1).getStatus() == 2 ||
					reserv.get(ans-1).getStatus() ==3){
				System.out.println("선택하신 예약은 취소하실 수 없습니다.");
				System.out.println();
			}
		}
		if(ans == 2){
			System.out.println("리뷰를 작성하시려는 예약을 선택해주세요(ex.예약12번)");
			System.out.println("유저 화면으로 돌아가시려면 0을 눌러주세요");
			ans = Integer.parseInt(sc.nextLine());
			
			if(ans == 0){break;}
			if(reserv.get(ans-1).getStatus() == 1 ||
					reserv.get(ans-1).getStatus() == 2){
				System.out.println("선택하신 예약은 리뷰를 작성하실 수 없습니다.");
				System.out.println();
			}
			if(reserv.get(ans-1).getStatus() == 3){
				//리뷰를 작성하는 메소드를 불러온다
				break;
			}
		}
		if(ans == 3){break;}
		}while(true);
		
	}

	

	@Override
	public void selectReservation(String userid) {
		
		
		System.out.println("------------------------------");
		System.out.println("번호\t 아이디\t예약번호\t객실아이디\t예약기간\t\t예약상태");
		System.out.println("------------------------------");
			for(int i =reservDao.reservationList().size() -1; 0<= i; i--){
				ReservationVO reList =reservDao.reservationList().get(i);
				System.out.println(i + 1+"\t"+ reList.getUserId()
									 + "\t"
									 + reList.getReservationId()
									 + "\t"
									 + reList.getRoomId() 		
									 + "\t"
									 + getDateByInteger(reList.getCheckin())
									 + "~" 
									 + getDateByInteger(reList.getCheckout())
									 +"("
									 + (reList.getCount()-1)
									 +"박"
									 + reList.getCount()
									 +"일"
									 +")"
									 + "\t"
									 + reList.getStatus()
									 );
									 	
			}
			System.out.println("-------------------------------------");
			 Controller cont = new Controller();
			 searchReserv(userid);
	
		
			
	}

}

//	@Override
//	public void cancelReservation(String id) {
//		public static void reservMain (int roomid, String userid){
//			
//			//메소드에 필요한 클래스를 객체로 생성
//			ReservService reservService = ReservServiceImpl.getInstance();
//			ReservVO rvo = new ReservVO();
//			
//			//날짜 선택하는 메소드 실행 + 결제까지한꺼번에 진행함
//			rvo = reservService.selectDate(roomid);
//			
//			//고객이 결제했을 경우 데이터베이스에 저장
//			if(rvo.getPaymethod() != ""){
//				rvo.setRoomId(roomid);
//				rvo.setUserId(userid);
//				reservService.addReserv(rvo);
//			}
//			
