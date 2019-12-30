package dao;

import java.util.ArrayList;
import java.util.Date;

import vo.ReservationVO;
import vo.UserVO;

public interface ReservationDAO {

	
	public ArrayList<ReservationVO> selectReservationList();
	
	ArrayList<ReservationVO> reservationList ();
	
	void insertUser(ReservationVO reservation);
	
	public boolean reservCheck(int roomid, Date checkin, Date checkout);
	
	public ArrayList<ReservationVO> reservedRoom(int roomid);
	
	public int getRoomPrice(int roomid);
	
	public void cancelReserv(int ReservId);
	
	public ArrayList<ReservationVO> getUserReserv(String userid);
	
	public void resVOprint (ReservationVO rvo);
	
	

}
