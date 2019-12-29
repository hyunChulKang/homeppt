package dao;

import java.util.ArrayList;

import vo.RoomVO;

public interface RoomDao {

	ArrayList<RoomVO> selectRoom(int hotelId);
	
	
	
}