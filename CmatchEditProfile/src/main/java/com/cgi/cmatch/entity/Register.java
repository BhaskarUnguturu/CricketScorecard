package com.cgi.cmatch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
//register entity holding follwing attributes
@Entity
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REG_ID")
	private int cMatchRegId;

	@Column(name = "REG_IMAGENAME")
	private String cMatchImageName;
	@Column(name = "REG_IMAGETYPE")
	private String cMatchImageType;

	@Column(name = "REG_USERNAME")
	private String cMatchUserName;
	@Column(name = "REG_PASSWORD")
	private String cMatchPassword;

	public String getcMatchUserName() {
		return cMatchUserName;
	}

	public void setcMatchUserName(String cMatchUserName) {
		this.cMatchUserName = cMatchUserName;
	}

	public String getcMatchPassword() {
		return cMatchPassword;
	}

	public void setcMatchPassword(String cMatchPassword) {
		this.cMatchPassword = cMatchPassword;
	}

	@Lob
	@Column(name = "REG_IMAGE")
	private byte[] cMatchImage;

	public int getcMatchRegId() {
		return cMatchRegId;
	}

	public void setcMatchRegId(int cMatchRegId) {
		this.cMatchRegId = cMatchRegId;
	}

	public String getcMatchImageName() {
		return cMatchImageName;
	}

	public void setcMatchImageName(String cMatchImageName) {
		this.cMatchImageName = cMatchImageName;
	}

	public String getcMatchImageType() {
		return cMatchImageType;
	}

	public void setcMatchImageType(String cMatchImageType) {
		this.cMatchImageType = cMatchImageType;
	}

	public byte[] getcMatchImage() {
		return cMatchImage;
	}

	public void setcMatchImage(byte[] cMatchImage) {
		this.cMatchImage = cMatchImage;
	}

}