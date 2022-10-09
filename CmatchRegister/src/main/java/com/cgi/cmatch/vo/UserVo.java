package com.cgi.cmatch.vo;


public class UserVo {
	private int id;
	
	private String userName;
	private String userPassword;
	private String ImageName;
	private String imageType;
	private byte[] pic;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getImageName() {
		return ImageName;
	}
	public void setImageName(String imageName) {
		ImageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	
	
}
