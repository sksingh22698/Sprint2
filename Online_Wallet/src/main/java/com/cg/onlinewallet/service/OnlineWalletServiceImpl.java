package com.cg.onlinewallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinewallet.dao.OnlineWalletDao;
import com.cg.onlinewallet.entities.WalletAccount;
import com.cg.onlinewallet.entities.WalletUser;

@Service
public class OnlineWalletServiceImpl implements OnlineWalletService {

	
	public OnlineWalletServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private OnlineWalletDao onlineWalletSprint2Dao;


	/*********************************************************************************************************************
	 * Method: addMoney 
	 *
	 * Description: Increase the balance of the user balance with the added amount 
	 * 
	 * @param userId:User's userId
	 *      
	 * @param amount:amount which has to be increased
	 *
	 * Created By - Vinay Singh Parmar
	 * 
	 ***********************************************************************************************************************/
	@Override
	public Double addMoney(Integer userId, Double Amount) {
		WalletUser user = onlineWalletSprint2Dao.getUser(userId);
		Integer accountId = user.getAccountDetail().getAccountID();
		WalletAccount account = onlineWalletSprint2Dao.getAccount(accountId);
		Double balance = account.getAccountBalance();
		balance += Amount;
		account.setAccountBalance(balance);
		return account.getAccountBalance();
	}
	
	/*********************************************************************************************************************
	 * Method: showBalance Description: took and show the balance of the user
	 * 
	 * @param userId:User's userid
	 *            
	 * @returns Double: Balance took from the wallet
	
	 * Created By -Vinay Singh Parmar
	 *         
	 * 
	 ***********************************************************************************************************************/
	@Override
	public Double showBalance(Integer userId) {
		WalletUser user = onlineWalletSprint2Dao.getUser(userId);
		WalletAccount account = user.getAccountDetail();
		return account.getAccountBalance();
	}

}
