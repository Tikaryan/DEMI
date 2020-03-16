package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetailsMO;
import com.example.demo.pojo.UserDO;


public interface LeaveDAO {
	
	public void save(UserDO userDO);



	
}
