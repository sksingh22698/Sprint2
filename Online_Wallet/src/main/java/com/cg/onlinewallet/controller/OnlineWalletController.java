package com.cg.onlinewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinewallet.service.OnlineWalletService;
@CrossOrigin(origins="*")
@RestController
public class OnlineWalletController {
	
	@Autowired
	public OnlineWalletService onlineWalletSprint2Service;

	
	public OnlineWalletController() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	/*************************************************************************************************************
	* Method:addMoney
	* Description:for adding money
	* @param userId:User's Id
	* @param amount:amount to be added
	* @returns Entity:it will return added amount.
	* Created By-Vinay Singh Parmar
	*************************************************************************************************************/
	
	@PutMapping("/addmoney/{userId}")
	public ResponseEntity<Double> addMoney(@PathVariable("userId") Integer userId, Double amount) {
		Double balance=onlineWalletSprint2Service.addMoney(userId, amount);
		return new ResponseEntity<Double>(balance, HttpStatus.OK);
	}
	
	/*********************************************************************************************************************
	* Method:showBalance
	* Description:for showing the balance in the account
	* @param userId:User's Id
	* @returns Entity:return the balance i.e. available in the account.
	* Created By-Vinay Singh Parmar
	***********************************************************************************************************************/
	
	@GetMapping("/showbalance/{userId}")
	public ResponseEntity<Double> showBalance(@PathVariable("userId") Integer userId) {
		Double balance = onlineWalletSprint2Service.showBalance(userId);
		return new ResponseEntity<Double>(balance,null,HttpStatus.OK);
	}
	
	

}
