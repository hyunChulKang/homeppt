package service;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controller;
//import controller.Hotel;
import controller.Hotelroom;
import dao.HotelDAO;
import dao.HotelDAOImpl;
import vo.HotelVO;



public class HotelServiceImpl implements HotelService {

	private static HotelServiceImpl instance;
	
	private HotelServiceImpl(){}
	
	public static HotelServiceImpl getInstance(){
		if(instance == null){
			instance = new HotelServiceImpl();
		}
		return instance;
	}
	HotelDAO hotelDao = HotelDAOImpl.getInstance();
	
	Scanner s = new Scanner(System.in);

	
	void HotelName(HotelVO hotelVO) { //지역아이디를 바탕으로 지역 호텔 목록 조회
		System.out.println("-----------리스트-----------");
		System.out.printf("호텔 이름  : " + hotelVO.getHotelName() + " || " );
		System.out.printf("호텔 등급 : " + hotelVO.getHotelGrade()+" || ");
		System.out.println();
		
	}
	
	void HotelInfo(HotelVO hotelVO) { // 지역 아이디와 호텔 아이디를 바탕으로 세부정보 조회
		System.out.println();
		System.out.println("호텔 소개 :" + hotelVO.getHotelInfo());
		System.out.println();
		System.out.println("호텔 주소 :" + hotelVO.getHotelAdress());
		System.out.println("호텔 연락처 :" + hotelVO.getHotelHp());
	}
	

	@Override
	public void Search() { //지역 아이디 바탕
//		Hotel hotel = new Hotel();
		String 광주;
		System.out.println("지역을 입력하세요");
		System.out.println("----------");
		System.out.println("지역 목록");
		System.out.println("광역시(특별시) : 서울, 인천, 대전, 세종, 광주, 대구, 울산, 부산, 제주");
		System.out.println("시도 : 경기도, 충청도, 강원도, 전라도, 경상도");
		System.out.println("이전화면으로 가시려면");
		System.out.println("'이전화면'을 입력해 주세요");
		String input="";
		do{
		input = s.nextLine();
			if(input.equals("대전")){
				int localId = 0;
				ArrayList <HotelVO> localList = hotelDao.selectlocal (localId);			
				for(HotelVO i : localList) {
					
					 HotelName(i);
				}
			}else if(input.equals("이전화면")){
				new Controller().localMove();
			}
		}while(!input.equals("서울")  || !input.equals("인천")  || !input.equals("대전") || !input.equals("세종")  
							  || !input.equals("광주")  || !input.equals("대구")  || !input.equals("울산") 
							  || !input.equals("부산") || !input.equals("제주"));
		
		getInfo();
	}
	@Override
	public void getInfo() { //지역 아이디 및 호텔 아이디 바탕
		String input;
//		int output;
//		if(!input.equals("이전화면"));
		System.out.println("---------------------------");
		System.out.println("세부 정보를 보시려면");
		System.out.println("호텔 이름을 입력해 주세요");
		System.out.println("---------------------------");
		do{
			Hotelroom room = new Hotelroom();
			int hotelId;
			int localId;
			
			System.out.println("이전화면으로 가시려면");
			System.out.println("'이전화면'을 입력해 주세요");
			input = s.nextLine();
//			output = Integer.parseInt(as.nextLine());
			switch(input){
			case "롯데시티호텔대전" :
				hotelId = 01;
				localId = 0;
				
//				ArrayList <HotelVO> hotelInfo = hotelDao.selecthotel (localId, hotelId);
				ArrayList <HotelVO> hotelInfo = hotelDao.selecthotel (localId, hotelId);
				for(HotelVO i : hotelInfo) {
					
					HotelInfo(i);
				}		
//				room.room();
				room.roomMain(hotelId);
				break;
			case "유성호텔" :
				hotelId = 02;
				localId = 0;
//				ArrayList<HotelVO> hotelInfo = hotelDao.selecthotel(localId,hotelId);
				ArrayList <HotelVO> hotelInfo2 = hotelDao.selecthotel (localId, hotelId);

				for (HotelVO i : hotelInfo2) {

					HotelInfo(i);
				}
				
				break;
			case "이전" :
				getInfo();
				break;
			}
			input = "이전화면";
		
		}while(!input.equals("이전화면"));
//		if(input.equals("롯데시티호텔대전")){
//
//		}
//		
//		if (input.equals("유성호텔")) {
//
//		}
//		String output;
//		do{
//			System.out.println("---------------------------");
//			System.out.println("이전화면으로 가시려면");
//			System.out.println("'이전화면'을 입력해 주세요");
//			System.out.println("---------------------------");
//			output = s.nextLine();
//		}while(!output.equals("이전화면"));
//		getInfo();
		
//		if (input.equals("유성호텔")) {
//			int hotelId = 01;
//			int localId = 0;
//			ArrayList<HotelVO> hotelInfo = hotelDao.selecthotel(localId,hotelId);
//
//			for (HotelVO i : hotelInfo) {
//
//				HotelInfo(i);
//			}
//		}
//		String output2;
//		do{
//			System.out.println("---------------------------");
//			System.out.println("이전화면으로 가시려면");
//			System.out.println("'이전화면'을 입력해 주세요");
//			System.out.println("---------------------------");
//			output2 = s.nextLine();
//		}while(!output2.equals("이전화면"));
//		getInfo();
//		}
//			Search();
	}
}		 