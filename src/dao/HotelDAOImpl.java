package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import data.Database;
import service.HotelServiceImpl;
import vo.HotelVO;

public class HotelDAOImpl implements HotelDAO {

	private static HotelDAOImpl instance;

	private HotelDAOImpl() {
	}

	public static HotelDAOImpl getInstance() {
		if (instance == null) {
			instance = new HotelDAOImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();


	@Override
	public ArrayList<HotelVO> selectlocal(int localId) {
		ArrayList<HotelVO> tmp = new ArrayList<>();
		for(int i = 0; i < database.tb_local.size(); i++){
			if(database.tb_local.get(i).getLocalId() == localId){
				
				tmp.add(database.tb_local.get(i));
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<HotelVO> selecthotel(int localId, int hotelId) {
		ArrayList<HotelVO> tmp = new ArrayList<>();
		for(int i = 0; i < database.tb_hotel.size(); i++){
			if(database.tb_hotel.get(i).getLocalId() == localId && database.tb_hotel.get(i).getHotelId() == hotelId){
				
				tmp.add(database.tb_hotel.get(i));
			}
		}
		return tmp;
	}
}	