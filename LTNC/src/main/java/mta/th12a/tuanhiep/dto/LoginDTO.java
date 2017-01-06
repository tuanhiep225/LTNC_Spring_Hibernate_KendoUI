package mta.th12a.tuanhiep.dto;

public class LoginDTO {
	public String userName;
	public String passWord;
	
	public LoginDTO() {
	}

	public LoginDTO(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
