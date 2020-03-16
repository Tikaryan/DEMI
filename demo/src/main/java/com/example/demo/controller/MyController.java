package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetailsMO;
import com.example.demo.pojo.UserDO;
import com.example.demo.service.LeaveService;

@RestController
@CrossOrigin(origins = "*")
public class MyController {

	@Autowired
	LeaveService leaveService;

	@PostMapping(value ="/login")
	public ResponseEntity<String> greeting(@RequestBody UserDetailsMO userMO) {
		
		return ResponseEntity.ok("YEs");
	}
	
	@PostMapping(value ="/save")
	public ResponseEntity<String> gg(@RequestBody UserDO userDO) {
//		userMO.setUserDO(userMO);
//		UserDO userDO =userMO.getUserDO();
		String s ="hello";
//		leaveService.saveOrUpdate(userDO);
		
		
		return ResponseEntity.ok(s);
	}
	

}
