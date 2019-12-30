package service;

import vo.ReservationVO;
import vo.UserVO;

public interface ReservationService {

	
	void roomCheckIn(int roomId, String userid); 		//예약 날짜 조회 및 예약 (
	
	public void searchReserv(String userid);

	String makePayment(int roomid, int staydate);
	

}