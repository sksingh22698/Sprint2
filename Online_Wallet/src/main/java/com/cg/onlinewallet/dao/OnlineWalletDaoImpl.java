package com.cg.onlinewallet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.onlinewallet.entities.WalletAccount;
import com.cg.onlinewallet.entities.WalletUser;

@Repository
public class OnlineWalletDaoImpl implements OnlineWalletDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	public OnlineWalletDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveAccount(WalletAccount account) {
		entityManager.persist(account);
	}
	
	public WalletAccount getAccount(Integer accountId) {
		WalletAccount account=entityManager.find(WalletAccount.class, accountId);
		return account;
	}
	
	@Override
	public void saveUser(WalletUser user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
		}
	
	
	@Override
	public WalletUser getUser(Integer userId) {
		WalletUser user = entityManager.find(WalletUser.class, userId);
		return user;
	}
	
	
	
	
	
}
