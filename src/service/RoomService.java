package service;

public interface RoomService {
	
	void getRoom(int hotelId); // 호텔을 검색했을 때 그 호텔이 가진 객실을 불러옴. 호텔 아이디를 넘겨받아야 함.
	
	void goReview(); //해당 객실의 리뷰 불러오기
	
	void goReservation(); //예약을 선택하면 예약 화면으로 넘어감.. 이 메소드 필요한가? 걍 리뷰 작성하는 서비스로 가야... 음... 아니겠군. 나중에 만들자.
	
}