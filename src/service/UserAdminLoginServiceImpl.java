package service;

import java.util.ArrayList;

import dao.UserAdminLoginDaoImpl;
import dao.UserLoginDao;
import dao.UserLoginDaoImpl;
import vo.UserAdminLoginVO;
import vo.UserVO;

public class UserAdminLoginServiceImpl implements UserAdminLoginService {
	
	private static UserAdminLoginServiceImpl instance;

	public static UserAdminLoginService getInstance() {
		if(instance == null) {
			instance = new UserAdminLoginServiceImpl();
		}
		return instance;
	}
	
	UserLoginDao userLoginDao = UserLoginDaoImpl.getInstence();
	UserAdminLoginDaoImpl userAdminLoginDao = UserAdminLoginDaoImpl.getInstance();
	
	@Override
	public void userList() {
		ArrayList<UserVO> userList = userAdminLoginDao.selectUserList();
			
		System.out.println("-------------------------");
		System.out.println("번호\t아이디\t이름");
		System.out.println("-------------------------");
		for(int i = userList.size() - 1; 0 <= i; i--){
			UserVO user = userList.get(i);
			System.out.println(i + 1 + "\t" + user.getId() + "\t" + user.getName() + "\t" + user.getPhone() + "\t" + user.getEmail() + "\t" + user.getGrade());
		}
		System.out.println("-------------------------");
	}
	
	

}