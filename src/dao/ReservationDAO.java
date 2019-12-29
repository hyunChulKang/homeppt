package dao;

import java.util.ArrayList;
import java.util.Date;

import vo.ReservationVO;
import vo.UserVO;

public interface ReservationDAO {

	ReservationVO reservationcheck();
	
	public ArrayList<ReservationVO> selectReservationList();
	
	ArrayList<ReservationVO> reservationList ();
	
	public boolean reservCheck(int roomid, Date checkin, Date checkout);
	
	public ArrayList<ReservationVO> reservedRoom(int roomid);
	
//	ArrayList<ReservationVO> numCheck (String userId, int reservationId, int roomId, int checkout, int checkin);
}
