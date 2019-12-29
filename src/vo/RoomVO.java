package vo;

//import data.HotelDatabase;

public class RoomVO {
	
	private int roomId;			//객실아이디
	private int hotelId;		//호텔아이디 (바깥에서 가져와야함)
	private String roomName;	//객실명
	private String roomInfo;	//소개
	private String roomOption;	//옵션 (와이파이, 주차장..? ㄴㄴ 호텔레벨에서. 일단 따로 생각하자..)
	private int roomLimit;		//인원수
	private int roomPrice; 		//가격
	
//	HotelDatabase database = HotelDatabase.getInstance(); //호텔 아이디를 가져오기 위해 호텔 데이터베이스를 가져온다
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {	//호텔 데이터 베이스에서 입력된 정보를 받아온다. 아직 미구현.
		this.hotelId = hotelId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}
	public String getRoomOption() {
		return roomOption;
	}
	public void setRoomOption(String roomOption) {
		this.roomOption = roomOption;
	}
	public int getRoomLimit() {
		return roomLimit;
	}
	public void setRoomLimit(int roomLimit) {
		this.roomLimit = roomLimit;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	
}