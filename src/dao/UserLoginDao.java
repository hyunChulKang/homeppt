package dao;

import java.util.ArrayList;

//import vo.UserLoginVO;
import vo.UserVO;

public interface UserLoginDao {
	
//	ArrayList<UserLoginVO> local();
	
	ArrayList<UserVO> selectUserMypage();

}