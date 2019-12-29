package service;

import java.util.ArrayList;

import vo.RoomVO;
import dao.RoomDao;
import dao.RoomDaoImpl;

public class RoomServiceImpl implements RoomService {
	
	//싱글톤으로 만든다
	private static RoomServiceImpl instance;
	
	private RoomServiceImpl(){}
	
	public static RoomServiceImpl getInstance(){
		if(instance == null){
			instance = new RoomServiceImpl();
		}
		return instance;
	}
	
	//RoomDaoImpl을 RoomDao타입으로 가져온다
	RoomDao roomDao = RoomDaoImpl.getInstance();
	
	//객실의 객체를 받았을 때 안의 내용을 프린트 해주는 메소드 구현
	void printRoomVO(RoomVO roomVO) {
		System.out.print("객실번호 : "+roomVO.getRoomId()+"\t");
		System.out.print("객실명 : "+roomVO.getRoomName()+"\t");
		System.out.print("객실가격 : "+roomVO.getRoomPrice()+"\t");
		System.out.println("인원수 : "+roomVO.getRoomLimit());
		System.out.println("옵션 : "+roomVO.getRoomOption());
		System.out.println("설명 : "+roomVO.getRoomInfo());
		System.out.println();
	}
	
	@Override //호텔 아이디를 넘겨받으면 dao에서 리스트를 받아 프린트 해준다
	public void getRoom(int hotelId) {
		ArrayList<RoomVO> tmp = roomDao.selectRoom(hotelId);
		for(RoomVO i : tmp){printRoomVO(i);}
	}

	@Override //리뷰하는 창으로 가는데 객실 아이디가 있는지 확인하고 해당하는 리뷰를 불러온다.
	public void goReview() {
		
		
	}

	@Override //예약하는 창으로 갈 수 있도록 해당 메소드를 불러와준다.
	public void goReservation() {
		
	}
	
}