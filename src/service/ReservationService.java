package service;

import vo.ReservationVO;
import vo.UserVO;

public interface ReservationService {

	
	void roomCheckIn(int roomId); 		//예약 날짜 조회 및 예약 (
	
	void selectReservation();	//예약가능조회
	
	void cancelReservation();	//예약취소

	
}