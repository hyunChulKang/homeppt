package dao;

import java.util.ArrayList;

import data.Database;
import vo.UserAdminLoginVO;
import vo.UserVO;

public class UserAdminLoginDaoImpl implements UserAdminLoginDao {
	
	private static UserAdminLoginDaoImpl Instance;
	
	private UserAdminLoginDaoImpl() {}
	
	public static UserAdminLoginDaoImpl getInstance() {
		if(Instance == null) {
			Instance = new UserAdminLoginDaoImpl();
		}
		return Instance;
	}
	
	Database database = Database.getInstance();
	

	@Override
	public ArrayList<UserVO> selectUserList() {
		return database.tb_user;
	}

}