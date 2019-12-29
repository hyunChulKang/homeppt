package service;

import java.util.ArrayList;

import vo.UserLoginVO;
import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;
import dao.UserLoginDao;
import dao.UserLoginDaoImpl;

public class UserLoginServiceImpl implements UserLoginService {

	private static UserLoginServiceImpl instance;
	
	private UserLoginServiceImpl() {};

	public static UserLoginService getInstance() {
		if(instance == null){
			instance = new UserLoginServiceImpl();
		}
		return instance;
	}
	
	UserLoginDao userLoginDao = UserLoginDaoImpl.getInstence();
	UserLoginDaoImpl userDao = UserLoginDaoImpl.getInstence();
	

	
	@Override
	public void userMypage() {
		ArrayList<UserVO> userList = userDao.selectUserMypage();
		
		System.out.println("-------------------------");
		System.out.println("번호\t아이디\t이름\t핸드폰번호\t이메일\t등급");
		System.out.println("-------------------------");
		for(int i = userList.size() - 1; 0 <= i; i--){
			UserVO user = userList.get(i);
			System.out.println(i + "\t" + user.getId() + "\t" + user.getName() + "\t" + user.getPhone() + "\t" + user.getEmail() + "\t" + user.getGrade());
		}
		System.out.println("-------------------------");
	}


	
//	@Override
//	public void local() {
//		ArrayList<UserLoginVO> local = userLoginDao.local();
//
//		System.out.println("-------------------------");
//		System.out.println("순서" + "\t지역이름");
//		System.out.println("-------------------------");
//		for(int i = 0; i < local.size(); i++){
//			UserLoginVO locallist = local.get(i);
//			System.out.println(i + 1 + "\t" +locallist.getLocalCity());
//		}
//		System.out.println(local.size());
//		System.out.println("-------------------------");
//	}
	
	
	
	
	

}