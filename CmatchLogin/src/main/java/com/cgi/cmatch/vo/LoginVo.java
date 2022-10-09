package com.cgi.cmatch.vo;

public class LoginVo {

	private String username;
	private String password;
	private String token;
	private String imageName;
	private String imagetype;
	private byte[] imagePic;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagetype() {
		return imagetype;
	}

	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}

	public byte[] getImagePic() {
		return imagePic;
	}

	public void setImagePic(byte[] imagePic) {
		this.imagePic = imagePic;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
