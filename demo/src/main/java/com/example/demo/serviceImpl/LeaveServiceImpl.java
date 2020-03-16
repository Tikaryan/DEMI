package com.example.demo.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LeaveDAO;
import com.example.demo.pojo.UserDO;
import com.example.demo.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService{

	@Autowired
	LeaveDAO leaveDAO;
	
	@Override
	@Transactional
	public void saveOrUpdate(UserDO userDO) {
		leaveDAO.save(userDO);
	}

}
