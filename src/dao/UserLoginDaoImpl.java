package dao;

import java.util.ArrayList;

import data.Database;
import vo.UserLoginVO;
import vo.UserVO;

public class UserLoginDaoImpl implements UserLoginDao {

	private static UserLoginDaoImpl instence;
	
	private UserLoginDaoImpl() {}
	
	public static UserLoginDaoImpl getInstence(){
		if(instence == null){
			instence = new UserLoginDaoImpl();
		}
		return instence;
	}
	
	Database database = Database.getInstance();

//	@Override
//	public ArrayList<UserLoginVO> local() {
//		return database.tb_local;
//	}

	@Override
	public ArrayList<UserVO> selectUserMypage() {
		return database.tb_user;
	}

}