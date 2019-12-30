package controller;

import java.util.Scanner;

import service.HotelServiceImpl;
import service.ReservationService;
import service.ReservationServiceImpl;
import service.RoomService;
import service.RoomServiceImpl;
//import dao.DateDaoImpl;
//import data.ReservDatabase;

public class Hotelroom {
	
	private Scanner sc = new Scanner(System.in);

//	public static void main(String[] args){
//		
HotelServiceImpl roomService = HotelServiceImpl.getInstance();
	
	public void roomMain(int a, String id){	//호텔 id를 받아야 함
		
		RoomService roomService = RoomServiceImpl.getInstance();//룸서비스 클래스를 불러온다
		//Reservation service 예약서비스 클래스를 불러온다
		//Review service 리뷰서비스 클래스를 불러온다
		int roomId;
		String userInput;
		ReservationService reservationService = ReservationServiceImpl.getInstance();
		
		do{
			System.out.println("----------------객실목록----------------");

			roomService.getRoom(a);//객실을 보여준다
			
			System.out.println("--------------------------------------");
			System.out.println("머물고 싶은 객실번호를 입력해주세요");
			System.out.println("호텔 선택 화면으로 돌아가시려면 0을 눌러주세요.");
			System.out.println("--------------------------------------");
			
			roomId = Integer.parseInt(sc.nextLine());
			
			if(roomId==0){
				System.out.println("이전 화면으로 돌아갑니다"); break;
			}
			
			System.out.println("--------------------------------------");
			System.out.println("선택하신 객실은 "+roomId+"입니다.");
			System.out.println("예약하시려면 1번,해당 객실의 리뷰를 보시려면 2번을 눌러주세요.");
			System.out.println("호텔 선택 화면으로 돌아가시려면 0을 눌러주세요.");
			System.out.println("--------------------------------------");
			
			userInput = sc.nextLine();
			
			if(userInput.equals("이전")){
				break;
			}
			else if(userInput.equals("예약")){/*reservation service를 roomId을 담아서 보내준다*/
				reservationService.roomCheckIn(roomId, id);
				break;
			}else if(userInput.equals("리뷰")){
			/*review service를 roomId를 담아서 보내준다*/
			}else{
			 System.out.println("잘못된 입력입니다.");
			}
		}while(roomId != 0 && !userInput.equals("이전"));
		
	}
	
}