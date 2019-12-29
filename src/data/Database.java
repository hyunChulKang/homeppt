package data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vo.HotelVO;
import vo.ReservationVO;
import vo.UserAdminLoginVO;
import vo.UserVO;

public class Database { //기본적은 데이터를 입력
	
	private static Database instance;
	
	private Database(){}
	
	public static Database getInstance(){
		if(instance == null){
			instance = new Database();
		}
		return instance;
	}
	
	//사용자 로그인 정보
	//관리자 사용자목록 조회
	public ArrayList<UserVO> tb_user = new ArrayList<>();

	{
		UserVO user = new UserVO();
		user.setName("관리자");
		user.setId("admin");
		user.setPassword("admin");
		user.setPhone("01012341234");
		user.setEmail("admin@admin.com");
		user.setGrade("관리자");
		tb_user.add(user);
	}
	
	//관리자 로그인 정보
	public ArrayList<UserAdminLoginVO> tb_admin = new ArrayList<>();

	{
		UserAdminLoginVO user = new UserAdminLoginVO();
		user.setAdminname("관리자");
		user.setAdminid("admin");
		user.setAdminpassword("admin");
		user.setAdminphone("01012341234");
		user.setAdminemail("admin@admin.com");
		user.setAdmingrade("관리자");
		tb_admin.add(user);
	}
	
//	//사용자 지역선택
//	public ArrayList<UserLoginVO> tb_local = new ArrayList<>();
//	{
//		UserLoginVO local = new UserLoginVO();
//		local.setLocalCity("대전광역시");
//		tb_local.add(local);
//		local = new UserLoginVO();
//		local.setLocalCity("서울특별시");
//		tb_local.add(local);
//		local = new UserLoginVO();
//		local.setLocalCity("광주광역시");
//		tb_local.add(local);
//		local = new UserLoginVO();
//		local.setLocalCity("부산광역시");
//		tb_local.add(local);
//		local = new UserLoginVO();
//		local.setLocalCity("제주특별자치시");
//		tb_local.add(local);
//		local = new UserLoginVO();
//		local.setLocalCity("울산광역시");
//		tb_local.add(local);
//		local = new UserLoginVO();
//		local.setLocalCity("인천광역시");
//		tb_local.add(local);
//	}
	
	public ArrayList <HotelVO> tb_local = new ArrayList<>();
	
	{
			HotelVO hotel = new HotelVO();
			hotel.setLocalId(0);		
			hotel.setHotelName("롯데시티호텔대전");
			hotel.setHotelGrade("4성급");
			tb_local.add(hotel);
		
	}
	
	{
			HotelVO hotel = new HotelVO();
			hotel.setLocalId(0);
			hotel.setHotelName("유성호텔");
			hotel.setHotelGrade("3성급");
			tb_local.add(hotel);
		
	}
	 public ArrayList <HotelVO> tb_hotel = new ArrayList<>();
	 {
			HotelVO hotel = new HotelVO();
			hotel.setHotelId(01);
			hotel.setLocalId(0);
			hotel.setHotelName("롯데시티호텔대전");
			hotel.setHotelInfo("롯데시티호텔 대전 - <4성급:한국관광공사 인증> -\n 대전컨벤션센터 바로 앞에 위치한 롯데시티호텔 대전은  엑스포과학공원 동문게이트에서 도보로 채 5분이 걸리지 않는 거리에 있습니다.\n 차로 5분이면 한밭 수목원까지, 10분이면 대전정부청사와 카이스트 등까지 가실 수 있습니다.\n 대전에 자리한 이 호텔에는 공용 지역 무료 무선 인터넷 등이 완비되어 있습니다. \n 또한, 구내에 회의실, 24시간 리셉션 등이 갖춰져 있으며, 금고, 세탁 서비스, 비즈니스 센터 시설과 서비스를 사용하실 수 있습니다.\n 무료 구내 전용 주차장도 제공됩니다. 총 304개의 객실에는 에어컨이 완비되어 있으며, 고급 세면 용품, 평면 TV 등의 최고급 시설을 제공하고 있습니다. \n 모든 객실에 커피/차 메이커, 객실 내 금고, 냉장고 등이 구비되어 있습니다. \n 편안한 숙면을 위해 침대 및 침구류는 해온(he:on) 베딩 시스템으로 구성되어 있습니다. \n 18층에 위치한 C’ cafe에서는 별도의 비용을 지불하면 조식, 중식, 석식 뷔페를 즐기실 수 있습니다.\n"
					+ "2층에 있는 C’lounge에는 카페와 바 공간으로, 별도의 비용을 지불하면 조식, 중식, 석식을 맛보실 수 있습니다.");
			hotel.setHotelAdress("엑스포로123번길 33, 유성구, 대전, 대한민국");
			hotel.setHotelHp("042-333-100");
			tb_hotel.add(hotel);
			
	 }
	 {
		 {
				HotelVO hotel = new HotelVO();
				hotel.setHotelId(02);
				hotel.setLocalId(0);
				hotel.setHotelName("유성호텔");
				hotel.setHotelInfo("대전 유성호텔 - <3성급:한국관관공사 인증> -\n 대전 유성호텔은 대전 1호선 유성온천역 5번 출구와 유성시외버스정류소에서 도보로 단 5분 거리에 있어 교통이 편리합니다.\n 조금만 걸어가시면 유성온천공원 족욕체험장까지 가실 수 있으며 차로 15분이면 한밭 수목원, 대전 예술의 전당, 대전정부청사까지 가실 수 있습니다.\n 핀란드식 사우나, 수영장 등을 갖춘 이 호텔에 머무시면 대전에 계시는 동안 럭셔리한 휴가를 보내실 수 있습니다.\n 또한 카페, 24시간 리셉션, 회의실 등도 이용하실 수 있습니다.\n 내부에는 수영장이 완비된 피트니스센터가 있습니다. 내부에 마련된 스파와 웰니스 센터에서 다양한 트리트먼트를 받으면서 휴식을 취하실 수 있습니다.\n 각 객실에는 냉방 시설이 완비되어 있고 커피 메이커, 냉장고 및 커피/차 메이커도 제공하고 있습니다.\n 전 객실에 슬리퍼, 헤어드라이어, 샤워 시설 등이 구비된 개인 욕실이 있습니다. 내부에는 가드니아 뷔페 식당이 있습니다. ");
				hotel.setHotelAdress("온천로 9, 유성구, 대전, 대한민국");
				hotel.setHotelHp("042-820-0100");
				tb_hotel.add(hotel);
				
		 }
	 }
	 
		
		public ArrayList<ReservationVO> userReservationlist = new ArrayList<>();
		{
			ReservationVO userReservList = new ReservationVO();
			
			userReservList.setCheckin(conv(20191225));
			userReservList.setCheckout(conv(20200102));
			userReservList.setPaymethod("현금");
			userReservList.setRequest("없음");
			userReservList.setReservationId(2019);
			userReservList.setReservationPrice(1000000);
			userReservList.setRoomId(1912);
			userReservList.setCount(8);
			userReservationlist.add(userReservList);
		}
		
			public Date conv(int date){
				int a = date%100; //일
				date = date/100;
				int b = date%100; //월
				date = date/100;
				int c = date%10000; //년도
				date = date/10000;
				
				Calendar cal = Calendar.getInstance();
				cal.set(c, b-1, a);
				Date time = cal.getTime();
			return time;
			}
			
}