package com.LongTime.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LongTime")
public class UserEntity {
	
	@Column(name="Uname")
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="Mobno")
	private int mobile;
	@Column(name="EmailId")
	private String email;
	public UserEntity(String name, int id, int mobile, String email) {
		super();
		this.name = name;
		this.id = id;
		this.mobile = mobile;
		this.email = email;
	}
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", id=" + id + ", mobile=" + mobile + ", email=" + email + "]";
	}
	
	
}
