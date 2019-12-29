package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.HotelVO;

public interface HotelDAO {
	

	
	ArrayList<HotelVO> selectlocal(int localId);

	ArrayList<HotelVO> selecthotel(int localId ,int hotelId);
}