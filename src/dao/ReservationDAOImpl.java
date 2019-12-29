package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vo.ReservationVO;
import vo.UserVO;
import data.Database;

public class ReservationDAOImpl implements ReservationDAO {
	//--------------------------------------------------------//
	private static ReservationDAOImpl instance;				//싱클톤
	public static Calendar cal = Calendar.getInstance();
	
	private ReservationDAOImpl(){}
	
	public static ReservationDAOImpl getInstance(){
		if(instance == null){
			instance =new ReservationDAOImpl();
		}
		return instance;
	}
	//--------------------------------------------------------//
	
	Database database =Database.getInstance();
	
	@Override
	public ReservationVO reservationcheck() {
//		ReservationVO check12
		
		return null;
	}

	public void reservationinsert(ReservationVO reservation) {
		database.userReservationlist.add(reservation);
		
//		public void insertUser(UserVO user) {
//			database.tb_user.add(user);
//		}
	}

	@Override
	public ArrayList<ReservationVO> reservationList() {
		
		return database.userReservationlist;
	}

//	@Override
//	//예약하려는 룸아이디를 가져오면 이미 reserv된 리스트를 가져온다. 취소되지 않은 녀석이어야 한다.
//	public ArrayList<ReservationVO> reservedRoom(int roomid){
//		
//		
//		
//		ArrayList<ReservationVO> tmp = new ArrayList<>();
//		
//		for(int i = 0; i < database.tb_reservation.size(); i ++){
//			if(database.tb_reservation.get(i).getRoomId() == roomid &&
//					database.tb_reservation.get(i).getStatus() == 1) //1이면 예약됨
//			tmp.add(database.tb_reservation.get(i));
//		}
//		return tmp;
//	}
	
	
	
//	public static Date conv(int date){
//		int a = date%100; //일
//		date = date/100;
//		int b = date%100; //월
//		date = date/100;
//		int c = date%10000; //년도
//		date = date/10000;
//		
//		if(date>0){System.out.println("날짜를 잘못 입력하셨습니다"); return null;}
//		
//		cal.set(c, b-1, a);
//		Date time = cal.getTime();
//		return time;
//	}

	
	//예약하려는 룸아이디를 가져오면 이미 reserv된 리스트를 가져온다. 취소되지 않은 녀석이어야 한다.
		public ArrayList<ReservationVO> reservedRoom(int roomid){				// status 1- 예약완료 , 2- 예약취소 , 3 - 리뷰가능
			
			ArrayList<ReservationVO> tmp = new ArrayList<>();
			
			for(int i = 0; i < database.userReservationlist.size(); i ++){
				if(database.userReservationlist.get(i).getRoomId() == roomid &&
						database.userReservationlist.get(i).getStatus() == 1) //1이면 예약상태인 것
				tmp.add(database.userReservationlist.get(i));
			}
			return tmp;
		}
		
	
	@Override
	public boolean reservCheck(int roomid, Date checkin, Date checkout){
		
		boolean check = true;
		
		ArrayList<ReservationVO> reservRoom = reservedRoom(roomid);				//reservRoom(예약완료) 
		
		for(int i = 0; i <reservRoom.size(); i ++){
			
			 int a = checkin.compareTo(reservRoom.get(i).getCheckin());
			
			//들어가려는 날짜와 이미 예약된 날짜의 체크인을 비교한다.
			//0 이면 같은 날에 예약하길 원하는 것이고 		(no)
			//1이면 그 이후의 날을 예약하길 원하는 것이고
			//-1이면 그 이전의 날을 예약하길 원하는 것이다
			int b = checkin.compareTo(reservRoom.get(i).getCheckout());
			//들어가려는 날짜와 이미 예약된 날짜의 체크아웃 날짜를 비교한다. 
			//0 이면 나가는 날에 예약하길 원하는 것이고 	(yes)
			//1이면 나가는 날 이후에 예약하려는 것이고
			//-1이면 나가는 날 이전에 예약하려는 것이다 
			int c = checkout.compareTo(reservRoom.get(i).getCheckin());
			//나가는 날짜와 이미 예약된 날짜의 체크인을 비교한다.
			//0이면 누가 오는 날에 나가려는 것이고 		(yes)
			//1이면 누가 오는 날보다 이후에 나가려는 것이고
			//-1이면 누가 오는 날보다 이전에 나가려는 것이다
			int d = checkout.compareTo(reservRoom.get(i).getCheckout());
			//나가는 날짜와 이미 예약된 날짜의 체크아웃을 비교한다.
			//0이면 누가 나가는 날에 나가려는 것이고 		(상관없음)
			//1이면 누가 나가는 날보다 이후에 나가려는 것이고
			//-1이면 누가 나가는 날보다 이전에 나가려는 것이다.
			
			if (a == 0) {check = false;	System.out.println(checkin+"일 부터"+checkout + "일 까지는 " + "예약이 불가합니다."); return check;} 
			//같은 날짜에 예약하기는 불가능하다
			if (a == 1 && (d == -1 || d == 0)) {check = false; System.out.println(checkin+"일 부터"+checkout + "일 까지는 " + "예약이 불가합니다."); return check;} 
			//이미 예약된 날의 사이에 예약하기는 불가능하다
			if (a == -1 && c == 1 && (d == -1 || d == 0)) {check = false; System.out.println(checkout+"일은 이미 예약되어있습니다.");return check;} 
			//체크아웃날짜가 예약된 날의 체크인체크아웃 사이에 있으면 안된다
			if (a == 1 && b == -1 && d == 1) {check = false; System.out.println(checkin+"일은 예약이 불가합니다.");return check;} 
			//체크인날짜가 예약된 날의 체크인체크아웃 사이에 있으면 안된다
			if (a == -1 && d == 1 ) {check = false; System.out.println(checkin+"일 ~" + checkout + "일 사이에 이미예약이 있습니다.");return check;} 
			//체크인과체크아웃 사이에 예약된 날이 끼어있으면 안된다
		}
		
		return check;
	}

	@Override
	public ArrayList<ReservationVO> selectReservationList() {
		return database.userReservationlist;
	}
}