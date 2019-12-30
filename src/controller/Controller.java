package controller;

import java.util.Scanner;

import service.HotelService;
import service.HotelServiceImpl;
import service.ReservationService;
import service.ReservationServiceImpl;
import service.UserAdminLoginService;
import service.UserAdminLoginServiceImpl;
import service.UserLoginService;
import service.UserLoginServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class Controller {
	
	UserService userService = UserServiceImpl.getInstance();
	UserLoginService user = UserLoginServiceImpl.getInstance();
	UserAdminLoginService Admin = UserAdminLoginServiceImpl.getInstance();
	HotelService hotel = HotelServiceImpl.getInstance();
	ReservationService reservationService =ReservationServiceImpl.getInstance();
	Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Controller().start();
		
	}
	
	private void start(){ //시작 화면
//		int menu2;
		String menu;
		
		do{
			System.out.println("---------- 메뉴 ------------");
			System.out.println("호텔 예약 시스템에 오신것을 환영합니다.");
			System.out.println("1. 호텔예약 시스템 시작");
			System.out.println("0. 프로그램 종료");
			System.out.println("--------------------------");
			System.out.println("메뉴에 해당하는 번호 입력>");
			
//			menu2 = Integer.parseInt(s.nextLine());
			
			menu = s.nextLine();
			switch(menu){
			case "시작" :
				begin();
				break;
			case "1" :
				begin();
				break;
			case "종료" :
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			case "0" :
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			}
		}while(menu != "종료");
	}

	public void begin() { //메인화면
		int menu;
		
		do{
			System.out.println("---------- 메뉴 ------------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 프로그램종료");
			System.out.println("--------------------------");
			System.out.println("메뉴에 해당하는 번호 입력>");
			
			menu = Integer.parseInt(s.nextLine());
			
			switch (menu) {
			case 1: //회원가입
				beginregister();
				break;
			case 2 : //로그인
				beginLogin();
				break;
			case 0 : //프로그램 종료
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			}
		}while(menu != 0);
	}
	
	
	private void beginregister(){ //회원가입 화면
		int menu;
		
		do{
			System.out.println("---------- 메뉴 ------------");
			System.out.println("1. 등록");
			System.out.println("2. 이전화면");
			System.out.println("--------------------------");
			System.out.println("메뉴에 해당하는 번호 입력>");
			
			menu = Integer.parseInt(s.nextLine());
			
			switch(menu){
			case 1 : //등록이동
				userService.join();
				break;
			case 0: //프로그램 종료
				
				break;
			}
			
			// 로그아웃 페이지 
		}while(menu != 0);
	}
	
	private void beginLogin(){ //로그인 분활 화면
		int menu;
		
		do{
			System.out.println("---------- 메뉴 ------------");
			System.out.println("1. 사용자 로그인");
			System.out.println("2. 관리자 로그인");
			System.out.println("3. 이전화면");
			System.out.println("--------------------------");
			System.out.println("메뉴에 해당하는 번호 입력>");
			
			menu = Integer.parseInt(s.nextLine());
			
			switch(menu){
			case 1 : //사용자로그인
				userService.login();
				break;
			case 2 : //관리자로그인
				userService.loginAdmin();
				break;
			case 3 : //이전화면
				begin();
				break;
			}
		}while(menu != 0);
	}
	
	public void userLogin(String userid) { //사용자 로그인화면으로 이동
		int menu;
		
		do{
			
			System.out.println("---------- 메뉴 ------------");
			System.out.println("1. 호텔예약하러 가기");
			System.out.println("2. 예약조회");
			System.out.println("3. 마이페이지");
			System.out.println("0. 로그아웃");
			System.out.println("--------------------------");
			System.out.println("메뉴에 해당하는 번호 입력>");
			
			menu = Integer.parseInt(s.nextLine());
			
			switch(menu){
			
			case 1 : //지역선택하러 가기
				localMove(userid);
				break;
			case 2 : //예약조회
				reservationService.searchReserv(userid);
				break;
			case 3 : //마이페이지
//				userMypage();
				break;
			case 0 : //로그아웃
				begin();
				break;
			}
		}while(menu != 0);
		
	}
	
	public void userAdminLogin() { //관리자 로그인화면으로 이동
		int menu;
		
		System.out.println("---------- 메뉴 ------------");
		System.out.println("1. 호텔등록 하기");
		System.out.println("2. 호텔 예약자 확인");
		System.out.println("3. 회원목록 확인");
		System.out.println("0. 로그아웃");
		System.out.println("--------------------------");
		System.out.println("메뉴에 해당하는 번호 입력>");
		
		
		
		do{
			
			menu = Integer.parseInt(s.nextLine());
			
			switch(menu){
			case 1 :
				System.out.println("미구현");
				System.exit(0);
				break;
			case 2 :
				System.out.println("미구현");
				System.exit(0);
				break;
			case 3 :
				Admin.userList();
				break;
			case 4 :
				begin();
				break;
			}
			
		}while(menu != 0);
		
	}
	
	
	public void localMove(String id){
//		Hotel hotel = new Hotel();
		int menu;
		
		System.out.println("---------- 메뉴 ------------");
		System.out.println("1. 지역선택 하기");
		System.out.println("2. 이전화면");
		System.out.println("--------------------------");
		System.out.println("메뉴에 해당하는 번호 입력>");
		
		
	
			menu = Integer.parseInt(s.nextLine());		
			
			switch(menu){
			case 1 :
				hotel.Search(id);
				break;
			case 2 :
				break;
			}
		
		
	}
	
//	public void reservationseCancal(String id){
//		Scanner can = new Scanner(System.in);
//		System.out.println("\t1.예약 취소  \r\t2.메인페이지");
//		int num=Integer.parseInt(can.nextLine());
//		
//		switch(num){
//		
//		case 1 :
//			reservationService.earchReserv(id);
//			break;
//		case 2 :
//			userLogin(id);
//			break;
//		}
//		
//	}
}
	
	
	
//	private void local(){
//		Controller as = new Controller();
//		int menu;
//		
//		System.out.println("---------- 메뉴 ------------");
//		System.out.println("1. 대전광역시");
//		System.out.println("2. 서울특별시");
//		System.out.println("3. 광주광역시");
//		System.out.println("4. 부산광역시");
//		System.out.println("5. 제주특별자치시");
//		System.out.println("6. 울산광역시");
//		System.out.println("7. 인천광역시");
//		System.out.println("8. 이전화면");
//		System.out.println("--------------------------");
//		System.out.println("메뉴에 해당하는 번호 입력>");
//		
//		menu = Integer.parseInt(s.nextLine());		
//		do{
//			switch(menu){
//			case 1 :
//				break;
//			case 2 :
//				break;
//			case 3 :
//				break;
//			case 4 :
//				break;
//			case 5 :
//				break;
//			case 6 :
//				break;
//			case 7 :
//				break;
//			case 8 :
//				as.localMove();
//				break;
//			}
//		}while(menu != 0);
//	}
