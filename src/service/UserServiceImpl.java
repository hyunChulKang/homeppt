package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.Controller;
import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

public class UserServiceImpl implements UserService { //클래스를 생성할때 인터페이스를 추가하여 생성 가능

	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}
	
	public static UserServiceImpl getInstance(){
		if(instance == null){
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	UserDao userDao = UserDaoImpl.getInstance();
	Scanner s = new Scanner(System.in);
	
	@Override
	public void join() {
		//메인화면 이동
		Controller as = new Controller();
		//회원가입
		
		System.out.println("--------------------------");
		System.out.println("이름 : ");
		System.out.println("ex) 홍길동");
		System.out.println("--------------------------");
		String name = s.nextLine();
		
		String regName = "^[가-힣]*$";
		Pattern regexName = Pattern.compile(regName);
		Matcher matcherName = regexName.matcher(name);
		
		if(matcherName.find()){
		}else{
			System.out.println("이름이 유효 하지 않습니다. \n ※ 한글로 입력하여주세요.");
			join();
		}
		
		System.out.println("--------------------------");
		System.out.println("아이디 : ");
		System.out.println("ex) pjm7981");
		System.out.println("--------------------------");
		String id = s.nextLine();
		
		String regId = "[a-z0-9_-]{5,20}";
		Pattern regexId = Pattern.compile(regId);
		Matcher matcherId = regexId.matcher(id);
		
		if(matcherId.find()){
		}else{
			System.out.println("아이디가 유효 하지 않습니다.\n ※ 영어와 숫자를 사용하여주세요. \n 틀렸습니다 처음부터 다시 시작해주세요.");
			join();
		}
		
		System.out.println("--------------------------");
		System.out.println("비밀번호 : ");
		System.out.println("ex) whd123!@#");
		System.out.println("--------------------------");
		String password = s.nextLine();
		
		String regPassword = "([a-z].*[A-Z])|([A-Z].*[a-z])\"|([0-9].*[!,@,#,^,&,*,(,),/])|([!,@,#,^,&,*,(,),/].*[0-9])";
		
		Pattern regexPassword = Pattern.compile(regPassword);
		Matcher matcherPassword = regexPassword.matcher(password);
		Matcher matcherPassword2 = regexPassword.matcher(password);  
		
		if(matcherPassword.find() && matcherPassword2.find()){
		}else{
			System.out.println("비밀번호가 유효 하지 않습니다. \n ※ 영어와 숫자, 특수문자가 포함되어야 됩니다. \n 틀렸습니다 처음부터 다시 시작해주세요.");
			join();
		}
		
		System.out.println("--------------------------");
		System.out.println("전화번호 : ");
		System.out.println("ex) 01012341234");
		System.out.println("--------------------------");
		String phone = s.nextLine();
		
		String regPhone = "^01(?:0|1|[6-9])?(\\d{3}|\\d{4})?(\\d{4})$";
		Pattern regexPhone = Pattern.compile(regPhone);
		Matcher matcherPhone = regexPhone.matcher(phone);
		
		if(matcherPhone.find()){
		}else{
			System.out.println("핸드폰 번호가 유효 하지 않습니다. \n ※ 예제에 따라주세요 \n 틀렸습니다 처음부터 다시 시작해주세요.");
			join();
		}
		
		System.out.println("--------------------------");
		System.out.println("이메일 : ");
		System.out.println("ex) whdals123@naver.com");
		System.out.println("--------------------------");
		String email = s.nextLine();
		
		String regEmail = "[a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$";
		Pattern regexEmail = Pattern.compile(regEmail);
		Matcher matcherEmail = regexEmail.matcher(email);
		
		if(matcherEmail.find()){
		}else{
			System.out.println("이메일이 유효 하지 않습니다. \n ※ 예제에 따라주세요 \n 틀렸습니다 처음부터 다시 시작해주세요.");
			join();
		}
		
		UserVO user = new UserVO();
		
		user.setName(name);
		user.setId(id);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		user.setGrade("일반등급");
		
		UserVO userCheck = userDao.selectUser("ID", user.getId());
		
		if(userCheck == null){
			userDao.insertUser(user);
			System.out.println("가입해주셔서 감사합니다.");
			as.begin();
		}else{
			System.out.println("아이디가 중복 되었습니다.");

		}
		

	}

	@Override
	public void login() {
		Controller as = new Controller();		//로그인
		
		System.out.println("--------------------------");
		System.out.println("아이디 : ");
		System.out.println("--------------------------");
		String id = s.nextLine();
		
		System.out.println("--------------------------");
		System.out.println("비밀번호 : ");
		System.out.println("--------------------------");
		String password = s.nextLine();
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("ID", id);
		param.put("PASSWORD", password);
		
		UserVO user = userDao.selectUser(param);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력 하셨습니다.");
		}else{
			Session.LoginUser = user;
			System.out.println("로그인 성공 !!");
			System.out.println(user.getName() + "님 환영합니다.");
			as.userLogin();
		}
	}

	@Override
	public void loginAdmin() {
		Controller as = new Controller();
		//로그인
		
		System.out.println("--------------------------");
		System.out.println("아이디 : ");
		System.out.println("--------------------------");
		String id = s.nextLine();
		
		System.out.println("--------------------------");
		System.out.println("비밀번호 : ");
		System.out.println("--------------------------");
		String password = s.nextLine();
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("ID", id);
		param.put("PASSWORD", password);
		
		UserVO user = userDao.selectUser(param);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력 하셨습니다.");
		}else{
			Session.LoginUser = user;
			System.out.println("로그인 성공 !!");
			System.out.println(user.getName() + "님 환영합니다.");
			as.userAdminLogin();
		}
		
	}

}
