package vo;

public class UserAdminLoginVO {
	
	//관리자 확인
	private String adminid;
	private String adminpassword;
	private String adminname;
	private String adminphone;
	private String adminemail;
	private String admingrade;
	
	
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminphone() {
		return adminphone;
	}

	public void setAdminphone(String adminphone) {
		this.adminphone = adminphone;
	}

	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getAdmingrade() {
		return admingrade;
	}

	public void setAdmingrade(String admingrade) {
		this.admingrade = admingrade;
	}

}