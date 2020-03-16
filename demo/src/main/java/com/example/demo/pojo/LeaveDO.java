package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LEAVE_TBL")
public class LeaveDO {

	@Id
	@Column(name="ID",unique = true, nullable = false)
	@GeneratedValue	(generator= "system-increment")
	private Integer id;
	
	@Column(name="FROM")
	private Integer from;
	
	@Column(name="TO")
	private Integer to;
	
	@Column(name="DAYS")
	private Integer days;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserDO  user_Id = new UserDO();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public UserDO getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(UserDO user_Id) {
		this.user_Id = user_Id;
	}
	
}
