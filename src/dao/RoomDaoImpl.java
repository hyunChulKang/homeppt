package dao;

import java.util.ArrayList;

import data.RoomDatabase;
import vo.RoomVO;

public class RoomDaoImpl implements RoomDao {
	
	//싱글톤으로 만든다
	private static RoomDaoImpl instance;
	
	private RoomDaoImpl(){}
	
	public static RoomDaoImpl getInstance(){
		if(instance == null){
			instance = new RoomDaoImpl();
		}
		return instance;
	}
	
	//RoomDatabase를 가져온다
	RoomDatabase database = RoomDatabase.getInstance();

	@Override//호텔 아이디를 넘겨받으면 관련 정보를 DB에서 모두 찾아서 리스트에 담아 리턴한다.
	public ArrayList<RoomVO> selectRoom(int hotelId) {
		ArrayList<RoomVO> tmp = new ArrayList<>();
		for(int i = 0; i < database.tb_room.size(); i++){
			if(database.tb_room.get(i).getHotelId() == hotelId){
				tmp.add(database.tb_room.get(i));
			}
		}
	return tmp;	
	}
	
}