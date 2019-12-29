package data;

import java.util.ArrayList;

import vo.RoomVO;

public class RoomDatabase {
	
	//싱글톤으로 만든다
	private static RoomDatabase instance;
	
	private RoomDatabase(){}
	
	public static RoomDatabase getInstance(){
		if(instance == null){
			instance = new RoomDatabase();
		}
		return instance;
	}
	
	public ArrayList<RoomVO> tb_room = new ArrayList<>(); //객실이라는 객체를 저장해둘 테이블
	
	//기본 객체를 추가해둔다
	{
		RoomVO room = new RoomVO();
		
		room.setRoomId(1);
		room.setHotelId(1);
		room.setRoomName("고스트객실");
		room.setRoomInfo("쏼ㄹ쏼라쏼라");
		room.setRoomOption("오션뷰아님/간이침대없음/룸서비스없음");
		room.setRoomLimit(1);
		room.setRoomPrice(10000000);
		tb_room.add(room);
	}
	
	{
		RoomVO room = new RoomVO();
		
		room.setRoomId(2);
		room.setHotelId(1);
		room.setRoomName("초호화객실");
		room.setRoomInfo("쏼ㄹ쏼라쏼라");
		room.setRoomOption("오션뷰임/간이침대많음/룸서비스많음");
		room.setRoomLimit(1);
		room.setRoomPrice(100000);
		tb_room.add(room);
	}
	
	{
		RoomVO room = new RoomVO();
		
		room.setRoomId(3);
		room.setHotelId(1);
		room.setRoomName("초호화객실33");
		room.setRoomInfo("쏼ㄹ쏼라쏼라");
		room.setRoomOption("오션뷰임/간이침대많음/룸서비스많음");
		room.setRoomLimit(1);
		room.setRoomPrice(100000);
		tb_room.add(room);
	}
	
	{
		RoomVO room = new RoomVO();
		
		room.setRoomId(4);
		room.setHotelId(1);
		room.setRoomName("초호화객실222");
		room.setRoomInfo("쏼ㄹ쏼라쏼라");
		room.setRoomOption("오션뷰임/간이침대많음/룸서비스많음");
		room.setRoomLimit(1);
		room.setRoomPrice(10000);
		tb_room.add(room);
	}
	
	
	
}