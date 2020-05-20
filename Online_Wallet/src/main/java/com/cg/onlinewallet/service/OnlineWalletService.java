package com.cg.onlinewallet.service;

public interface OnlineWalletService {
	
	Double addMoney(Integer userId, Double Amount);

	Double showBalance(Integer userId);

}
