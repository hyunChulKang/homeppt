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
	ArrayList<UserVO> tb_user = userDao.selectUserList();
	//----------------------------------------------------//
	
	@Override
	public  void roomCheckIn(int roomId, String id){
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
		     ReservationVO userReservList = new ReservationVO();
		     userReservList.setUserId(id);														//현재 접속중인 유져아이디
		     userReservList.setRoomId(roomId);													//선택한 룸아이디
		     
//		     SimpleDateFormat format_recentTime = new SimpleDateFormat("yyyyMMdd");				//현재 시간을 예약아이디로 입력부
//		     Date recentTime = new Date();
//		     int checkin = Integer.parseInt(format_recentTime.format(recentTime));	
//		     userReservList.setUserId();
//		     for(int i = 0; i< alluserList.size(); i++){
//		    	 System.out.print("\t"+alluserList.get(i));
//		     }
		     while(true) {
		    	 count++;
		         cal1.add(Calendar.DATE, 1);
		         Integer checkdays =getDateByInteger(cal1.getTime());								//	Calendar의 날짜를 하루씩 증가한다.
		         if(getDateByInteger(cal1.getTime()) >= checkoutday) 							// 현재 날짜가 종료일자보다 크거나 같을때
		        	 break;
		     }
		     Controller cont = new Controller();
		     cont.userLogin(id);
		    //--------------------------------날짜 출력-------------------------------------------//  
		}//The end roomCheckIn
	
	
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
	public void selectReservation() {
		
		System.out.println("------------------------------");
		System.out.println("번호\t 아이디\t이름\t예약번호\t객실아이디\t예약기간");
		System.out.println("------------------------------");
			for(int i =reservtaionCheckList.size() -1; 0<= i; i--){
				ReservationVO reList =reservtaionCheckList.get(i);
				System.out.println(i + 1+ reList.getUserId()
									 + "\t"
//									 + reList.getUserId()
//									 + "\t"
									 + reList.getReservationId()
									 + "\t"
									 + reList.getRoomId() 		
									 + "\t"
									 + getDateByInteger(reList.getCheckin())
									 + "~" 
									 +getDateByInteger(reList.getCheckout())
									 +"("
									 +(reList.getCount()-1)
									 +"박"
									 +reList.getCount()
									 +"일"
									 +")");	
			}
			System.out.println("-------------------------------------");
			
	}
	
	@Override
	public void cancelReservation() {
		
	}
}