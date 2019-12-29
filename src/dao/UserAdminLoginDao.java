package dao;

import java.util.ArrayList;

import vo.UserAdminLoginVO;
import vo.UserVO;

public interface UserAdminLoginDao {
	
	ArrayList<UserVO> selectUserList();

}